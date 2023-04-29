package unam.dgtic.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Usuario;
import unam.dgtic.repositories.CrudRepository;
import unam.dgtic.repositories.UsuarioRepositoryImpl;

import java.util.Collection;

@Stateless
public class UsuarioServicioImpl implements Servicio<Usuario>{
    @Inject
    private CrudRepository<Usuario> usuarioCrudRepository;
    @Override
    public Usuario guardar(Usuario obj) {
        return usuarioCrudRepository.guardar(obj);
    }

    @Override
    public Usuario buscarId(int id) {
        return usuarioCrudRepository.buscarId(id);
    }

    @Override
    public Collection<Usuario> buscarTodos() {
        return usuarioCrudRepository.buscarTodos();
    }

    @Override
    public Collection<Usuario> buscaRelacion(int id) {
        return usuarioCrudRepository.buscaRelacion(id);
    }

    @Override
    public Collection<Usuario> filtro(String filtro) {
        return ((UsuarioRepositoryImpl)usuarioCrudRepository).buscarFiltro(filtro);
    }


}
