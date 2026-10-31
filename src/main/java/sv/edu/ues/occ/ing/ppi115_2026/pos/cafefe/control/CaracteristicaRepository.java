package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Caracteristica;

/** Domain repository contract for Caracteristica. */
public interface CaracteristicaRepository extends Repository<Caracteristica> {
    List<Caracteristica> findAllWithRelations();
    List<Caracteristica> findActivos();
}
