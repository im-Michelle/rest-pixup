package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.*;

import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class PagoRepositoryImpl implements CrudRepository<Pago> {
    @Inject
    private EntityManager em;

    @Override
    public Pago guardar(Pago obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public Pago buscarId(int id) {
        Query query = em.createQuery("from Pago p where p.id=:id");
        query.setParameter("id", id);
        return (Pago) query.getSingleResult();

    }

    @Override
    public Collection<Pago> buscarTodos() {
        return em.createQuery("from Pago", Pago.class).getResultList();
    }

    @Override
    public Collection<Pago> buscaRelacion(int id) {
        Venta venta=em.find(Venta.class,id);
        Query query = em.createQuery("from Pago m where m.venta=:idVenta");
        query.setParameter("idVenta", venta);
        return query.getResultList() != null ? query.getResultList():
                new ArrayList<>();
    }
}
