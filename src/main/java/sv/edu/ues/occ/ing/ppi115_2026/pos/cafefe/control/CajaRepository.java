package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Caja;

/** Domain repository contract for Caja. */
public interface CajaRepository extends Repository<Caja> {
    void crear(Caja caja);
    void modificar(Caja caja);
    void eliminar(Caja caja);
    Caja buscarPorId(Object id);
}
