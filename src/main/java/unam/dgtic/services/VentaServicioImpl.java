package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Venta;
import unam.dgtic.repositories.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class VentaServicioImpl implements Servicio<Venta> {

    @Inject
    private CrudRepository<Venta> crudRepository;

    @Override
    public Venta guardar(Venta obj) {
        return crudRepository.guardar(obj);
    }

    @Override
    public Venta buscarId(int id) {
        return crudRepository.buscarId(id);
    }

    @Override
    public Collection<Venta> buscarTodos() {
        return crudRepository.buscarTodos();
    }

    @Override
    public Collection<Venta> buscaRelacion(int id) {
        return crudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<Venta> filtro(String filtro) {
        return new ArrayList<>();
    }
}
