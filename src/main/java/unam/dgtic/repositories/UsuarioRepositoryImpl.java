package unam.dgtic.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.models.Estado;
import unam.dgtic.models.Usuario;

import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class UsuarioRepositoryImpl implements CrudRepository<Usuario> {
    @Inject
    private EntityManager em;

    @Override
    public Usuario guardar(Usuario obj) {
        if (obj.getId() > 0) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        return obj;
    }

    @Override
    public Usuario buscarId(int id) {
        Query query = em.createQuery("from Usuario m where m.id=:id");
        query.setParameter("id", id);
        return (Usuario) query.getSingleResult();

    }

    @Override
    public Collection<Usuario> buscarTodos() {
        return em.createQuery("from Usuario", Usuario.class).getResultList();
    }

    @Override
    public Collection<Usuario> buscaRelacion(int id) {
        return new ArrayList<>();
    }
    public Collection<Usuario> buscarFiltro(String patron){
        Query query = em.createQuery(
                "select m from Usuario m where m.nombre like " +
                        "concat('%',:patron,'%')");
        query.setParameter("patron", patron);
        return query.getResultList() != null ? query.getResultList():
                new ArrayList<>();
    }
}
