package bodenor.api.lectura.service;

import bodenor.api.com.Util;
import bodenor.api.continuidad.model.Continuidad;
import bodenor.api.continuidad.service.ContinuidadService;
import bodenor.api.lectura.model.LecturaCircutorCVMC10;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * Microservicio Lectura [MSLectura]
 *
 * @author Jorge Silva Borda.
 */
@Path("/lectura")
public class MSLectura {

    @Inject
    @RestClient
    private ContinuidadService continuidad;

    /**
     * Recibe request http POST para ingresar un registro de continuidad de
     * Lectura de Remarcador CircutorCVMC10.
     *
     * @param contenido El contenido del mensaje que viene en el request.
     * @return Continuidad
     */
    @POST
    @Path("/circutorcvmC10")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Transactional
    public Continuidad postLectura(String contenido) {
        contenido = contenido.replaceAll("\\n", "");
        LecturaCircutorCVMC10 lectura = new LecturaCircutorCVMC10();
        lectura.setOrigen("circutorcvmC10");

        String regexp = "";

        Pattern pattern;
        Matcher matcher;

        //Patrón regexp sacar timestamp del mensaje
        regexp = "(TIMESTAMP\\[)([0-9]{4}-[0-9]{1,2}-[0-9]{1,2}\\s+[0-9]{1,2}\\:[0-9]{1,2}\\:[0-9]{1,2})(\\])";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);
        if (matcher.find()) {
            //System.out.println("Fecha: " + matcher.group(2));
            lectura.setTimestamp(matcher.group(2));
        }

        //Patrón regexp sacar IP Conversor del mensaje
        regexp = "(IP\\[)([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})(\\])";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);
        if (matcher.find()) {
            //System.out.println("IP: " + matcher.group(2));
            lectura.setIp(matcher.group(2));
        }

        //Patrón regexp sacar Id Remarcador en el conversor del mensaje
        regexp = "(EQUIPO\\[)([0-9]{1,8})(\\]IDREM\\[)([0-9]{1,8})(\\])";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);
        if (matcher.find()) {
            //System.out.println("NUMREMARCADOR: " + matcher.group(2) + matcher.group(4));
            lectura.setNumremarcador(Integer.parseInt(matcher.group(2) + matcher.group(4)));
        }

        //Patrón regexp sacar campos del mensaje
        regexp = "(\\[)([0-9]{1,3})(\\])(\\:)(\\s+)(-?)([0-9]{1,9})";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);

        //Recorrer la cantidad de coincidencias del patrón
        while (matcher.find()) {//Campos específicos de modelo circutorcvmC10
            if (matcher.group(2).trim().equals("49")) {
                Double item49 = Double.parseDouble(matcher.group(6) + matcher.group(7));
                lectura.setItem49(item49);
            }
            if (matcher.group(2).trim().equals("50")) {
                Double item50 = Double.parseDouble(matcher.group(6) + matcher.group(7));
                lectura.setItem50(item50);
            }
            if (matcher.group(2).trim().equals("95")) {
                Double item95 = Double.parseDouble(matcher.group(6) + matcher.group(7));
                lectura.setItem95(item95);
            }
            if (matcher.group(2).trim().equals("96")) {
                Double item96 = Double.parseDouble(matcher.group(6) + matcher.group(7));
                lectura.setItem96(item96);
            }
        }

        //Campos específicos del remarcador Circutor CVMC10 para calcular
        //Energía acumulada y Potencia.
        Double lecturareal = 0.0D;
        Double lecturaproyectada = 0.0D;
        Double potencia = 0.0D;
        Double ultimomaximo = 0.0D;
        Double delta = 0.0;

        //Revisión de valores---------------------------------------------------
        //Timestamp
        System.out.println("lectura.getTimestamp(): " + lectura.getTimestamp());
        if (lectura.getTimestamp().length() < 19) {
            System.out.println("El formato de entrada de Timestamp no es válido");
            return new Continuidad();
        }

        //Items de cálculo------------------------------------------------------
        Integer existe = 1;
        Double item95 = lectura.getItem95();
        System.out.println("Item95: " + item95);
        if (item95 == null) {
            System.out.println("Item95 nulo");
            existe = 0;
        }
        Double item96 = lectura.getItem96();
        System.out.println("Item96: " + item96);
        if (item96 == null) {
            System.out.println("Item96 nulo");
            existe = 0;
        }
        if (existe == 1) {//Si los items de energía existen, se calcula la energía con el valor que viene cada uno.
            lecturareal = lectura.getEnergia();
        }

        boolean existepotencia = true;
        Double item49 = lectura.getItem49();
        System.out.println("Item49: " + item49);
        if (item49 == null) {
            System.out.println("Item49 nulo");
            existepotencia = false;
        }
        Double item50 = lectura.getItem50();
        System.out.println("Item50: " + item50);
        if (item50 == null) {
            System.out.println("Item50 nulo");
            existepotencia = false;
        }
        if (existepotencia) {//Si los items de potencia existen, se calcula la potencia con el valor de cada uno.
            potencia = lectura.getPotencia();
        } else {//Si no existen, se guarda un 0.0
            potencia = 0.0D;
        }
        //Ir a obtener la lectura anterior con rest client
        //Parámetros de entrada para el MSContinuidad: (origen, timestamp, numremarcador)
        //Se excluye parámetro IP por ahora
        Continuidad anterior = continuidad.getAnterior(lectura.getOrigen(), lectura.getTimestamp(), lectura.getNumremarcador());
        System.out.println("");
        System.out.println("");
        System.out.println("Continuidad Anterior encontrada: ");
        System.out.println(anterior.toCsv());
        Continuidad newContinuidad = new Continuidad();
        
        System.out.println("");
        System.out.println("");
        if (existe == 1) {
            System.out.println("Se puede calcular.");
            if (anterior.getLecturareal() == null) {//No hay anterior en BD.
                System.out.println("No existe registro anterior en BD. Se guarda lo que viene.");
                newContinuidad.setLecturareal(lectura.getEnergia());
                newContinuidad.setUltimomaximo(0.0D); //UltimoMaximo a cero.
                newContinuidad.setDelta(lectura.getEnergia()); // El delta es variación. Desde anterior a actual. ([lectura actual] - [lectura anterior]).
                newContinuidad.setLecturaproyectada(lectura.getEnergia());
            } else if (anterior.getLecturareal() <= lectura.getEnergia()) {  //Existe al menos una anterior y su lectura es menor que la nueva (Caso normal).
                /**
                 * Se calcula todo en base a: (consumo = lectura nueva - lectura
                 * anterior) //Variación desde la lectura anterior a la actual.
                 * Finalmente, ese valor (delta), se le agrega a la continuidad
                 * (Lectura Proyectada).
                 */
                System.out.println("Existe una anterior, es menor que la que viene. Se calcula.");
                newContinuidad.setLecturareal(lectura.getEnergia());
                newContinuidad.setUltimomaximo(anterior.getLecturareal());
                newContinuidad.setDelta(lectura.getEnergia() - anterior.getLecturareal());
                newContinuidad.setLecturaproyectada(anterior.getLecturaproyectada() + newContinuidad.getDelta());
            } else if (anterior.getLecturareal() > lectura.getEnergia()) { //La lectura que viene entrando es menor que la anterior. Puede existir un reseteo acá
                /**
                 * Se considera que cualquier caso en que la lectura que viene
                 * entrando corresponde a un reseteo Se calcula el delta en base
                 * a cero, es decir, el delta es la lectura que viene llegando.
                 * [delta = (lectura nueva - 0)] Lectura Proyectada = (lectura
                 * proyectada anterior + delta)
                 */
                System.out.println("Existe una anterior, es mayor que la que viene. Se calcula reseteo.");
                newContinuidad.setDelta(lectura.getEnergia());
                newContinuidad.setLecturaproyectada(anterior.getLecturaproyectada() + newContinuidad.getDelta());
                newContinuidad.setLecturareal(lectura.getEnergia());
                newContinuidad.setUltimomaximo(lectura.getEnergia());
            }

        }else{//No se puede calcular
            System.out.println("No se puede calcular");
            if (anterior.getLecturareal() == null) {//No hay anterior en BD.
                //No se puede resolver la lectura de ninguna forma porque faltan datos mínimos requeridos
                System.out.println("No existe una anterior. No se puede guardar nada.");
                return new Continuidad();
            } else {
                System.out.println("Existe una anterior. Se guarda esa, pero con Delta 0.0");
                newContinuidad.setDelta(0.0D);
                newContinuidad.setLecturaproyectada(anterior.getLecturaproyectada());
                newContinuidad.setLecturareal(anterior.getLecturareal());
                newContinuidad.setUltimomaximo(anterior.getLecturareal());
            }
        }


        newContinuidad.setOrigen(lectura.getOrigen());
        newContinuidad.setTimestamp(lectura.getTimestamp());
        newContinuidad.setFecha(Util.getFechaTimestamp(lectura.getTimestamp()));
        newContinuidad.setAnio(Integer.parseInt(Util.getAnioTimestamp(lectura.getTimestamp())));
        newContinuidad.setMes(Integer.parseInt(Util.getMesTimestamp(lectura.getTimestamp())));
        newContinuidad.setDia(Integer.parseInt(Util.getDiaTimestamp(lectura.getTimestamp())));
        newContinuidad.setNumremarcador(lectura.getNumremarcador());
        newContinuidad.setPotencia(potencia);
        newContinuidad.setExiste(existe);

        System.out.println("");
        System.out.println("");
        System.out.println("###############################################################################");
        System.out.println("Contenido del mensaje:");
        System.out.println("");
        System.out.println(contenido);
        System.out.println("");

        System.out.println("Resultado de parseo entrada:");
        System.out.println("Lectura");
        System.out.println(lectura.toCsv());
        System.out.println("");

        System.out.println("Resultado LecturaCircutor:");
        System.out.println(lectura.toString());
        System.out.println("");

        System.out.println("Resultado Continuidad Anterior registrada:");
        System.out.println(newContinuidad.toCsv());
        System.out.println("");
        System.out.println("###############################################################################");

        continuidad.postContinuidad(newContinuidad);

        return newContinuidad;
    }
}
