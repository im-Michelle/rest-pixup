package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.Estado;
import unam.dgtic.models.Municipio;

import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class MunicipioRepositoryImpl implements CrudRepository<Municipio> {
    @Inject
    private EntityManager em;

    @Override
    public Municipio guardar(Municipio obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public Municipio buscarId(int id) {
        Query query = em.createQuery("from Municipio m where m.id=:id");
        query.setParameter("id", id);
        return (Municipio) query.getSingleResult();

    }

    @Override
    public Collection<Municipio> buscarTodos() {
        return em.createQuery("from Municipio", Municipio.class).getResultList();
    }

    @Override
    public Collection<Municipio> buscaRelacion(int id) {
        Estado estado=em.find(Estado.class,id);
        Query query = em.createQuery("from Municipio m where m.estado=:idEstado");
        query.setParameter("idEstado", estado);
        return query.getResultList() != null ? query.getResultList():
                new ArrayList<>();
    }
}
