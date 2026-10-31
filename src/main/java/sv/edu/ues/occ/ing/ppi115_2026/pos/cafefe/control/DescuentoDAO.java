package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Descuento;

@Stateless
public class DescuentoDAO extends DefaultDAO<Descuento> implements DescuentoDAOInterface {

    @PersistenceContext(unitName = "cafefePU")
    private EntityManager em;

    public DescuentoDAO() {
        super(Descuento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Descuento> findActivos() {
        return em.createQuery("SELECT d FROM Descuento d JOIN FETCH d.idTipoDescuento t "
                + "WHERE t.activo = TRUE ORDER BY d.nombre", Descuento.class)
                .getResultList();
    }
}
