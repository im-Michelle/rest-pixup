package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Domicilio;
import unam.dgtic.repositories.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class DomicilioServicioImpl implements Servicio<Domicilio>{
    @Inject
    private CrudRepository<Domicilio> domicilioCrudRepository;
    @Override
    public Domicilio guardar(Domicilio obj) {
        return domicilioCrudRepository.guardar(obj);
    }

    @Override
    public Domicilio buscarId(int id) {
        return domicilioCrudRepository.buscarId(id);
    }

    @Override
    public Collection<Domicilio> buscarTodos() {
        return domicilioCrudRepository.buscarTodos();
    }

    @Override
    public Collection<Domicilio> buscaRelacion(int id) {
        return domicilioCrudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<Domicilio> filtro(String filtro) {
        return new ArrayList<>();
    }
}
