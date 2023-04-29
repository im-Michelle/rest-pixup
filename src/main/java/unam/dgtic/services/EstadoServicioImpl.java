package unam.dgtic.services;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.models.Estado;
import unam.dgtic.repositories.CrudRepository;
import java.util.ArrayList;
import java.util.Collection;
@Stateless
public class EstadoServicioImpl implements Servicio<Estado>{
    @Inject
    private CrudRepository<Estado> estadoCrudRepository;
    @Override
    public Estado guardar(Estado obj) {
        return estadoCrudRepository.guardar(obj);
    }
    @Override
    public Estado buscarId(int id) {
        return estadoCrudRepository.buscarId(id);
    }
    @Override
    public Collection<Estado> buscarTodos() {
        return estadoCrudRepository.buscarTodos();
    }
    @Override
    public Collection<Estado> buscaRelacion(int id) {
        return new ArrayList<>();
    }
    @Override
    public Collection<Estado> filtro(String filtro) {
        return new ArrayList<>();
    }
}