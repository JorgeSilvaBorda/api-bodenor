package bodenor.api.continuidadmensual.service;

import bodenor.api.continuidad.model.Continuidad;
import bodenor.api.continuidadmensual.model.ContinuidadMensual;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/api/continuidad")
public class MSContinuidadMensual {
    
    @Inject
    EntityManager manager;
    
    @GET
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    public ContinuidadMensual getContinuidadMensual(@QueryParam("numremarcador") Integer numremarcador, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        ContinuidadMensual continuidad = new ContinuidadMensual(numremarcador, anio, mes);
        String query = "SELECT C FROM CONTINUIDADMENSUAL C WHERE C.numremarcador = " + numremarcador + " AND C.anio = " + anio + " AND C.mes = " + mes;
        
        System.out.println(query);
        List<ContinuidadMensual> resultado = manager.createQuery(query, ContinuidadMensual.class).getResultList();
        if (resultado.size() == 0) {
            return new ContinuidadMensual();
        } else {
            return resultado.get(0);
        }
    }
    
    /**
     * Publica una nueva continuidad mensual que no existe. Debe venir con al menos
     * numremarcador, anio, mes, timeini, lecturaini
     * @param continuidad
     * @return 
     */
    @POST
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadMensual postContinuidadMensual(ContinuidadMensual continuidad) {
        System.out.println("Entra a insertar la continuidad mensual");
        System.out.println("Continuidad a insertar: " + continuidad.toCsv());
        manager.persist(continuidad);
        return continuidad;
    }
    
    @PATCH
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadMensual patchContinuidadMensual(ContinuidadMensual continuidad) {
        System.out.println("Entra a actualizar la continuidad mensual");
        System.out.println("Continuidad mensual que viene: " + continuidad.toCsv());
        
        manager.merge(continuidad);
        System.out.println("Continuidad mensual que queda: " + continuidad.toCsv());
        return continuidad;
    }
}
