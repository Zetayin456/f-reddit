package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Producto;

/** Domain repository contract for Producto. */
public interface ProductoRepository extends Repository<Producto> {
    List<Producto> findActivos();
    List<Producto> findActivosConDescuentos();
    List<Producto> findConCaracteristicas();
}
