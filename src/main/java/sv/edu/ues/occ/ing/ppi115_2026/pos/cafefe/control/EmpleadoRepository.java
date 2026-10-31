package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Empleado;

/** Domain repository contract for Empleado. */
public interface EmpleadoRepository extends Repository<Empleado> {
    List<Empleado> findActivos();
}
