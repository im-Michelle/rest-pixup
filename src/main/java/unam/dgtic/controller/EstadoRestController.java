package unam.dgtic.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Estado;
import unam.dgtic.services.Servicio;
import java.util.Collection;
import java.util.Optional;
@RequestScoped
@Path("/estado")
@Produces(MediaType.APPLICATION_JSON)
public class EstadoRestController {
    @Inject
    private Servicio<Estado> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Estado> estadoOptional = Optional.ofNullable(servicio.buscarId(id));
        if (estadoOptional.isPresent()) {
            return Response.ok(estadoOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Estado> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Estado estado) {
        try {
            Estado nuevoEstado = servicio.guardar(estado);
            return Response.ok(nuevoEstado).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}