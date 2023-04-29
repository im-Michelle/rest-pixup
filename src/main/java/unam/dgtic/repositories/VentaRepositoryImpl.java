package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.Domicilio;
import unam.dgtic.models.Usuario;
import unam.dgtic.models.Venta;

import java.util.ArrayList;
import java.util.Collection;
@RequestScoped
public class VentaRepositoryImpl implements  CrudRepository<Venta> {

    @Inject
    private EntityManager em;

    @Override
    public Venta guardar(Venta obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public Venta buscarId(int id) {
        Query query = em.createQuery("from Venta v where v.id=:id");
        query.setParameter("id", id);
        return (Venta) query.getSingleResult();

    }

    @Override
    public Collection<Venta> buscarTodos() {
        return em.createQuery("from Venta", Venta.class).getResultList();
    }

    @Override
    public Collection<Venta> buscaRelacion(int id) {
        Usuario usuario=em.find(Usuario.class,id);
        Query query = em.createQuery("select m from Venta m where m.usuario=:idUsuario");
        query.setParameter("idUsuario", usuario);
        return query.getResultList() != null ? query.getResultList():
                new ArrayList<>();
    }
}
