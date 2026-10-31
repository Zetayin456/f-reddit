package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;

/** Common persistence contract for the application's domain repositories. */
public interface Repository<T> {
    void create(T entity);
    T edit(T entity);
    void remove(T entity);
    T find(Object id);
    List<T> findRange(int first, int max);
    int count();
}
