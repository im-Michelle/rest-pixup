package unam.dgtic.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Domicilio;
import unam.dgtic.models.Venta;
import unam.dgtic.services.Servicio;

import java.util.Collection;
import java.util.Optional;

@RequestScoped
@Path("/venta")
@Produces(MediaType.APPLICATION_JSON)
public class VentaRestController {
    @Inject
    private Servicio<Venta> servicio;

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Venta> ventaOptional = Optional.ofNullable(servicio.buscarId(id));
        if (ventaOptional.isPresent()) {
            return Response.ok(ventaOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Venta> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<Venta> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Venta venta) {
        try {
            Venta nuevaVenta = servicio.guardar(venta);
            return Response.ok(nuevaVenta).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
