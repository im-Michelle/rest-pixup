package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Pago;
import unam.dgtic.repositories.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class PagoServicioImpl implements Servicio<Pago> {
    @Inject
    private CrudRepository<Pago> crudRepository;

    @Override
    public Pago guardar(Pago obj) {
        return crudRepository.guardar(obj);
    }

    @Override
    public Pago buscarId(int id) {
        return crudRepository.buscarId(id);
    }

    @Override
    public Collection<Pago> buscarTodos() {
        return crudRepository.buscarTodos();
    }

    @Override
    public Collection<Pago> buscaRelacion(int id) {
        return crudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<Pago> filtro(String filtro) {
        return new ArrayList<>();
    }
}
