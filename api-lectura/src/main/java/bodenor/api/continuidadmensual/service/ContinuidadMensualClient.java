package bodenor.api.continuidadmensual.service;

import bodenor.api.continuidad.model.Continuidad;
import bodenor.api.continuidadmensual.model.ContinuidadMensual;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "config.api.continuidad")
@Path("/continuidad")
public interface ContinuidadMensualClient {
    
    
    @GET
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    public ContinuidadMensual getContinuidadMensual(@QueryParam("numremarcador") Integer numremarcador, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes);
    
    @POST
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ContinuidadMensual postContinuidadMensual(ContinuidadMensual continuidad);
    
    @PATCH
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadMensual patchContinuidadMensual(ContinuidadMensual continuidad);
    
}
