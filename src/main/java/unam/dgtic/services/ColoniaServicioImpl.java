package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Colonia;
import unam.dgtic.repositories.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class ColoniaServicioImpl implements Servicio<Colonia>{
    @Inject
    private CrudRepository<Colonia> coloniaCrudRepository;
    @Override
    public Colonia guardar(Colonia obj) {
        return coloniaCrudRepository.guardar(obj);
    }

    @Override
    public Colonia buscarId(int id) {
        return coloniaCrudRepository.buscarId(id);
    }

    @Override
    public Collection<Colonia> buscarTodos() {
        return coloniaCrudRepository.buscarTodos();
    }

    @Override
    public Collection<Colonia> buscaRelacion(int id) {
        return coloniaCrudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<Colonia> filtro(String filtro) {
        return new ArrayList<>();
    }
}
