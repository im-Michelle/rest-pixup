package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.TipoDomicilio;
import unam.dgtic.repositories.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class TipoDomicilioServicioImpl implements Servicio<TipoDomicilio>{
    @Inject
    private CrudRepository<TipoDomicilio> tipoDomicilioCrudRepository;
    @Override
    public TipoDomicilio guardar(TipoDomicilio obj) {
        return tipoDomicilioCrudRepository.guardar(obj);
    }

    @Override
    public TipoDomicilio buscarId(int id) {
        return tipoDomicilioCrudRepository.buscarId(id);
    }

    @Override
    public Collection<TipoDomicilio> buscarTodos() {
        return tipoDomicilioCrudRepository.buscarTodos();
    }

    @Override
    public Collection<TipoDomicilio> buscaRelacion(int id) {
        return tipoDomicilioCrudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<TipoDomicilio> filtro(String filtro) {
        return new ArrayList<>();
    }
}
