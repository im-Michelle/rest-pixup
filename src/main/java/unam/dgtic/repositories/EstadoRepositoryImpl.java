package unam.dgtic.repositories;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.Estado;
import java.util.ArrayList;
import java.util.Collection;
@RequestScoped
public class EstadoRepositoryImpl implements CrudRepository<Estado> {
    @Inject
    private EntityManager em;
    @Override
    public Estado guardar(Estado obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        }else{
            em.persist(obj);
        }
        return obj;
    }
    @Override
    public Estado buscarId(int id) {
        Query query = em.createQuery("from Estado p where p.id=:idEstado");
        query.setParameter("idEstado", id);
        return ((Estado) query.getSingleResult());
    }
    @Override
    public Collection<Estado> buscarTodos() {
        return em.createQuery("from Estado", Estado.class).getResultList();
    }
    @Override
    public Collection<Estado> buscaRelacion(int id) {
        return new ArrayList<>();
    }
}