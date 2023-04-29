package unam.dgtic.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Colonia;
import unam.dgtic.services.Servicio;
import java.util.Collection;
import java.util.Optional;
@RequestScoped
@Path("/colonia")
@Produces(MediaType.APPLICATION_JSON)
public class ColoniaRestController {
    @Inject
    private Servicio<Colonia> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Colonia> ColoniaOptional = Optional.ofNullable(servicio.buscarId(id));
        if (ColoniaOptional.isPresent()) {
            return Response.ok(ColoniaOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Colonia> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<Colonia> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Colonia Colonia) {
        try {
            Colonia nuevoColonia = servicio.guardar(Colonia);
            return Response.ok(nuevoColonia).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}