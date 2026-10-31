package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.EmpleadoRol;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Rol;

@Stateless
public class EmpleadoRolDAO extends DefaultDAO<EmpleadoRol> implements EmpleadoRolDAOInterface, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "cafefePU")
    private EntityManager em;

    public EmpleadoRolDAO() {
        super(EmpleadoRol.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<EmpleadoRol> findByEmpleado(UUID idEmpleado) {
        if (idEmpleado == null) return Collections.emptyList();
        try {
            return em.createQuery("SELECT er FROM EmpleadoRol er "
                            + "JOIN FETCH er.idEmpleado JOIN FETCH er.idRol "
                            + "WHERE er.idEmpleado.idEmpleado = :idEmpleado", EmpleadoRol.class)
                     .setParameter("idEmpleado", idEmpleado)
                     .getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Rol> findRolesByEmpleado(UUID idEmpleado) {
        if (idEmpleado == null) {
            return Collections.emptyList();
        }
        return em.createQuery("SELECT DISTINCT r FROM EmpleadoRol er "
                        + "JOIN er.idEmpleado e JOIN er.idRol r "
                        + "WHERE e.idEmpleado = :idEmpleado AND er.activo = TRUE "
                        + "AND e.activo = TRUE AND r.activo = TRUE ORDER BY r.nombre", Rol.class)
                .setParameter("idEmpleado", idEmpleado)
                .getResultList();
    }

    @Override
    public List<EmpleadoRol> findAllWithRelations() {
        return em.createQuery("SELECT DISTINCT er FROM EmpleadoRol er "
                + "JOIN FETCH er.idEmpleado JOIN FETCH er.idRol "
                + "ORDER BY er.idEmpleado.nombre, er.idRol.nombre", EmpleadoRol.class)
                .getResultList();
    }
}
