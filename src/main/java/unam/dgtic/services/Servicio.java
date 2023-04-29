package unam.dgtic.services;
import jakarta.ejb.Local;
import java.util.Collection;
@Local
public interface Servicio<T> {
    T guardar(T obj);
    T buscarId(int id);
    Collection<T> buscarTodos();
    Collection<T> buscaRelacion(int id);
    Collection<T> filtro(String filtro);
}