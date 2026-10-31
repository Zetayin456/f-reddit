package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import jakarta.ejb.Local;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Descuento;


public interface DescuentoDAOInterface extends DescuentoRepository {
    /** Descuentos cuyo tipo padre está activo. */
    List<Descuento> findActivos();
}
