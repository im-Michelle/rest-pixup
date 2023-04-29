package unam.dgtic.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Domicilio;
import unam.dgtic.services.Servicio;
import java.util.Collection;
import java.util.Optional;
@RequestScoped
@Path("/domicilio")
@Produces(MediaType.APPLICATION_JSON)
public class DomicilioRestController {
    @Inject
    private Servicio<Domicilio> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Domicilio> DomicilioOptional = Optional.ofNullable(servicio.buscarId(id));
        if (DomicilioOptional.isPresent()) {
            return Response.ok(DomicilioOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Domicilio> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<Domicilio> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Domicilio Domicilio) {
        try {
            Domicilio nuevoDomicilio = servicio.guardar(Domicilio);
            return Response.ok(nuevoDomicilio).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}