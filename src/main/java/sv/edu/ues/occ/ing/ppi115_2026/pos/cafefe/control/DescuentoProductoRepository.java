package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import java.util.UUID;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.DescuentoProducto;

/** Domain repository contract for DescuentoProducto. */
public interface DescuentoProductoRepository extends Repository<DescuentoProducto> {
    List<DescuentoProducto> findAllWithRelations();
    List<DescuentoProducto> findByProductoWithRelations(UUID idProducto);
}
