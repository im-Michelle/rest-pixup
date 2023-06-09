package unam.dgtic.services;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@RequestScoped
public class ProducirEntityManager {
    @PersistenceContext(name="conexion")
    private EntityManager em;
    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return em;
    }
}
