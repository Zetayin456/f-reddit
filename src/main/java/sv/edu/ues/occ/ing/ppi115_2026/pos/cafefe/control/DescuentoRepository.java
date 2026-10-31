package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Descuento;

/** Domain repository contract for Descuento. */
public interface DescuentoRepository extends Repository<Descuento> {
    List<Descuento> findActivos();
}
