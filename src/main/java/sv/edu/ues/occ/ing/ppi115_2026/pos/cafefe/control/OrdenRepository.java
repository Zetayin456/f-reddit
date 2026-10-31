package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Orden;

/** Domain repository contract for Orden. */
public interface OrdenRepository extends Repository<Orden> {
    void crear(Orden orden);
    Orden modificar(Orden orden);
    void eliminar(Orden orden);
    List<Orden> obtenerTodos();
    List<Orden> findAllWithDetails();
}
