package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.TipoDomicilio;
import unam.dgtic.models.Municipio;

import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class TipoDomicilioRepositoryImpl implements CrudRepository<TipoDomicilio> {
    @Inject
    private EntityManager em;

    @Override
    public TipoDomicilio guardar(TipoDomicilio obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public TipoDomicilio buscarId(int id) {
        Query query = em.createQuery("from TipoDomicilio m where m.id=:id");
        query.setParameter("id", id);
        return (TipoDomicilio) query.getSingleResult();

    }

    @Override
    public Collection<TipoDomicilio> buscarTodos() {
        return em.createQuery("from TipoDomicilio", TipoDomicilio.class).getResultList();
    }

    @Override
    public Collection<TipoDomicilio> buscaRelacion(int id) {
        return new ArrayList<>();
    }
}
