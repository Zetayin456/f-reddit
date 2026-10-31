package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control.CajaDAOInterface;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Caja;

/** Read-only paginated endpoint used by the frontend's CajaService. */
@Path("v1/cajas")
@Produces(MediaType.APPLICATION_JSON)
public class CajaResource {

    @EJB
    private CajaDAOInterface cajaDAO;

    @GET
    public Response findRange(@QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("max") @DefaultValue("20") int max) {
        if (first < 0 || max < 1) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("first debe ser ≥ 0 y max debe ser ≥ 1")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }

        List<CajaDTO> cajas = cajaDAO.findRange(first, max).stream()
                .map(CajaDTO::from)
                .collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<CajaDTO>>(cajas) { })
                .header("total-registros", cajaDAO.count())
                .build();
    }

    /** A flat DTO avoids serializing Caja's lazy invoice relationship. */
    public static class CajaDTO {
        private UUID idCaja;
        private String nombre;
        private Boolean activo;
        private String observaciones;

        public CajaDTO() {
        }

        static CajaDTO from(Caja caja) {
            CajaDTO dto = new CajaDTO();
            dto.idCaja = caja.getIdCaja();
            dto.nombre = caja.getNombre();
            dto.activo = caja.getActivo();
            dto.observaciones = caja.getObservaciones();
            return dto;
        }

        public UUID getIdCaja() { return idCaja; }
        public String getNombre() { return nombre; }
        public Boolean getActivo() { return activo; }
        public String getObservaciones() { return observaciones; }
    }
}
