package unam.dgtic.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.TipoDomicilio;
import unam.dgtic.services.Servicio;
import java.util.Collection;
import java.util.Optional;
@RequestScoped
@Path("/tipodomicilio")
@Produces(MediaType.APPLICATION_JSON)
public class TipoDomicilioRestController {
    @Inject
    private Servicio<TipoDomicilio> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<TipoDomicilio> TipoDomicilioOptional = Optional.ofNullable(servicio.buscarId(id));
        if (TipoDomicilioOptional.isPresent()) {
            return Response.ok(TipoDomicilioOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<TipoDomicilio> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<TipoDomicilio> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(TipoDomicilio TipoDomicilio) {
        try {
            TipoDomicilio nuevoTipoDomicilio = servicio.guardar(TipoDomicilio);
            return Response.ok(nuevoTipoDomicilio).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}