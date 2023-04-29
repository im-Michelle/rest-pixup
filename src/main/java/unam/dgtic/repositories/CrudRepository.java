package unam.dgtic.repositories;
import java.util.Collection;
public interface CrudRepository<T> {
    T guardar(T obj);
    //busca Id de T
    T buscarId(int id);
    Collection<T> buscarTodos();
    Collection<T> buscaRelacion(int id);
}