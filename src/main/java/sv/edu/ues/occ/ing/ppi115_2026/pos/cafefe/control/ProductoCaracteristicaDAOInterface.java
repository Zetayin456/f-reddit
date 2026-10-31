package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;
import jakarta.ejb.Local;
import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.ProductoCaracteristica;
public interface ProductoCaracteristicaDAOInterface extends ProductoCaracteristicaRepository {
    List<ProductoCaracteristica> findAllWithRelations();
}
