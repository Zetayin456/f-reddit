package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Rol;

/** Domain repository contract for Rol. */
public interface RolRepository extends Repository<Rol> {
    List<Rol> findActivos();
}
