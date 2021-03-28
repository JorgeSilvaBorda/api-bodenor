/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.continuidad.service;

import bodenor.api.continuidad.model.Continuidad;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Microservicio Continuidad [MSContinuidad]
 *
 * @author Jorge Silva Borda.
 */
@Path("/api/continuidad")
public class MSContinuidad {

    @Inject
    EntityManager manager;

    /**
     * Obtiene un registro de continuidad registrado inmediatamente anterior
     * al que viene ingresando.
     *
     * @param origen Tipo de remarcador
     * @param timestamp String con el timestamp que viene de linux
     * Normalmente crontab desde una shell.
     * @param numremarcador Integer con el número compuesto que viene 
     * de la shell.
     * Se compome de NUMCONVERSOR + IDREMARCADOR_EN_CONVERSOR
     * @return Continuidad
     */
    @Path("/anterior")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Continuidad getAnterior(@QueryParam("origen") String origen, @QueryParam("timestamp") String timestamp, @QueryParam("numremarcador") Integer numremarcador) {
        System.out.println("Entra a buscar continuidad");
        System.out.println("MSContinuidad Recibe: " + "[origen:" + origen + "]" + "[timestamp:" + timestamp + "]" + "[numremarcador:" + numremarcador + "]");

        String query = "SELECT "
                + "C "
                + "FROM "
                + "CONTINUIDAD_TEST C "
                + "WHERE "
                + "C.origen = '" + origen + "' "
                + "AND C.timestamp < TIMESTAMP('" + timestamp + "') "
                + "AND C.numremarcador = " + numremarcador + " "
                + ""
                + "ORDER BY "
                + "C.timestamp DESC "
                + "";
        System.out.println(query);
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        if (resultado.size() == 0) {
            return new Continuidad();
        } else {
            return resultado.get(0);
        }

    }

    /**
     * Publica una continuidad.
     * @param continuidad Continuidad.
     * @return Continuidad publicada.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Continuidad postContinuidad(Continuidad continuidad) {
        System.out.println("Entra a insertar la continuidad");
        System.out.println("Continuidad a insertar: " + continuidad.toCsv());
        manager.persist(continuidad);
        return continuidad;
    }

}
