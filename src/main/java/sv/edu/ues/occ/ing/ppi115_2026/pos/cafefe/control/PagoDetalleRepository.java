package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.PagoDetalle;

/** Domain repository contract for PagoDetalle. */
public interface PagoDetalleRepository extends Repository<PagoDetalle> {
    void crear(PagoDetalle registro);
    PagoDetalle modificar(PagoDetalle registro);
    void eliminar(PagoDetalle registro);
    List<PagoDetalle> obtenerTodos();
}
