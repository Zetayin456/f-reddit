package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.TipoProducto;

/** Domain repository contract for TipoProducto. */
public interface TipoProductoRepository extends Repository<TipoProducto> {
    List<TipoProducto> findActivos();
}
