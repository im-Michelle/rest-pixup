package unam.dgtic.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Municipio;
import unam.dgtic.services.Servicio;
import java.util.Collection;
import java.util.Optional;
@RequestScoped
@Path("/municipio")
@Produces(MediaType.APPLICATION_JSON)
public class MunicipioRestController {
    @Inject
    private Servicio<Municipio> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Municipio> MunicipioOptional = Optional.ofNullable(servicio.buscarId(id));
        if (MunicipioOptional.isPresent()) {
            return Response.ok(MunicipioOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Municipio> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<Municipio> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Municipio Municipio) {
        try {
            Municipio nuevoMunicipio = servicio.guardar(Municipio);
            return Response.ok(nuevoMunicipio).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}