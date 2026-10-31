package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.TipoDescuento;

/** Domain repository contract for TipoDescuento. */
public interface TipoDescuentoRepository extends Repository<TipoDescuento> {
    List<TipoDescuento> findActivos();
}
