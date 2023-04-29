package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.Domicilio;
import unam.dgtic.models.Usuario;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@RequestScoped
public class DomicilioRepositoryImpl implements CrudRepository<Domicilio> {
    @Inject
    private EntityManager em;

    @Override
    public Domicilio guardar(Domicilio obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public Domicilio buscarId(int id) {
        Query query = em.createQuery("from Domicilio m where m.id=:id");
        query.setParameter("id", id);
        return (Domicilio) query.getSingleResult();

    }

    @Override
    public Collection<Domicilio> buscarTodos() {
        return em.createQuery("from Domicilio", Domicilio.class).getResultList();
    }

    @Override
    public Collection<Domicilio> buscaRelacion(int id) {
        Usuario usuario=em.find(Usuario.class,id);
        Query query = em.createQuery("select m from Domicilio m where m.usuario=:idUsuario");
        query.setParameter("idUsuario", usuario);
        return query.getResultList() != null ? query.getResultList():
                new ArrayList<>();
    }
}
