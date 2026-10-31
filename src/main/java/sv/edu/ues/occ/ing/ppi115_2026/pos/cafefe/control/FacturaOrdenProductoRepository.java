package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.FacturaOrdenProducto;

/** Domain repository contract for FacturaOrdenProducto. */
public interface FacturaOrdenProductoRepository extends Repository<FacturaOrdenProducto> {
    void crear(FacturaOrdenProducto registro);
    FacturaOrdenProducto modificar(FacturaOrdenProducto registro);
    void eliminar(FacturaOrdenProducto registro);
    FacturaOrdenProducto buscarPorId(Object id);
    List<FacturaOrdenProducto> findAllWithRelations();
}
