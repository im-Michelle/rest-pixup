package unam.dgtic.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Usuario;
import unam.dgtic.services.Servicio;
import unam.dgtic.services.UsuarioServicioImpl;
import java.util.Collection;
import java.util.Optional;
@RequestScoped
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioRestController {
    @Inject
    private Servicio<Usuario> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Usuario> UsuarioOptional = Optional.ofNullable(servicio.buscarId(id));
        if (UsuarioOptional.isPresent()) {
            return Response.ok(UsuarioOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Usuario> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<Usuario> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("salvar")
    public Response crear(Usuario usuario) {
        try {
            Usuario nuevoUsuario = servicio.guardar(usuario);
            return Response.ok(nuevoUsuario).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    @GET
    @Path("/filtro/{dato}")
    public Collection<Usuario> usuarioFiltro(@PathParam("dato") String dato) {
        return servicio.filtro(dato);
    }
}