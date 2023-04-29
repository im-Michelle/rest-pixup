package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Municipio;
import unam.dgtic.repositories.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;

@Stateless
public class MunicipioServicioImpl implements Servicio<Municipio>{
    @Inject
    private CrudRepository<Municipio> municipioCrudRepository;
    @Override
    public Municipio guardar(Municipio obj) {
        return municipioCrudRepository.guardar(obj);
    }

    @Override
    public Municipio buscarId(int id) {
        return municipioCrudRepository.buscarId(id);
    }

    @Override
    public Collection<Municipio> buscarTodos() {
        return municipioCrudRepository.buscarTodos();
    }

    @Override
    public Collection<Municipio> buscaRelacion(int id) {
        return municipioCrudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<Municipio> filtro(String filtro) {
        return new ArrayList<>();
    }
}
