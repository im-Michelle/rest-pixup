package unam.dgtic.controller;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.models.Pago;
import unam.dgtic.models.Venta;
import unam.dgtic.services.Servicio;

import java.util.Collection;
import java.util.Optional;

@RequestScoped
@Path("/pago")
@Produces(MediaType.APPLICATION_JSON)
public class PagoRestController {
    @Inject
    private Servicio<Pago> servicio;
    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id) {
        Optional<Pago> pagoOptional = Optional.ofNullable(servicio.buscarId(id));
        if (pagoOptional.isPresent()) {
            return Response.ok(pagoOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/todos")
    public Collection<Pago> todos(@PathParam("id") int id) {
        return servicio.buscarTodos();
    }
    @GET
    @Path("/relacion/{id}")
    public Collection<Pago> relacion(@PathParam("id") int id) {
        return servicio.buscaRelacion(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Pago pago) {
        try {
            Pago nuevoPago = servicio.guardar(pago);
            return Response.ok(nuevoPago).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
