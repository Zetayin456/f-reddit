package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import java.util.UUID;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Rol;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.EmpleadoRol;

/** Domain repository contract for EmpleadoRol. */
public interface EmpleadoRolRepository extends Repository<EmpleadoRol> {
    List<EmpleadoRol> findByEmpleado(UUID idEmpleado);
    List<EmpleadoRol> findAllWithRelations();
    List<Rol> findRolesByEmpleado(UUID idEmpleado);
}
