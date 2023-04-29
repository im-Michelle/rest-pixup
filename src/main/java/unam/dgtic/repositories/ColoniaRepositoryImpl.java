package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.Estado;
import unam.dgtic.models.Colonia;
import unam.dgtic.models.Municipio;

import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class ColoniaRepositoryImpl implements CrudRepository<Colonia> {
    @Inject
    private EntityManager em;

    @Override
    public Colonia guardar(Colonia obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public Colonia buscarId(int id) {
        Query query = em.createQuery("from Colonia m where m.id=:id");
        query.setParameter("id", id);
        return (Colonia) query.getSingleResult();

    }

    @Override
    public Collection<Colonia> buscarTodos() {
        return em.createQuery("from Colonia", Colonia.class).getResultList();
    }

    @Override
    public Collection<Colonia> buscaRelacion(int id) {
        Municipio municipio=em.find(Municipio.class,id);
        Query query = em.createQuery("from Colonia m where m.municipio=:idMunicipio");
        query.setParameter("idMunicipio", municipio);
        return query.getResultList() != null ? query.getResultList():
                new ArrayList<>();
    }
}
