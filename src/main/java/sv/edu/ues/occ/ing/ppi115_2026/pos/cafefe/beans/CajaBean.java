package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control.CajaRepository;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Caja;

@Named("cajaBean")
@ViewScoped
public class CajaBean implements Serializable {

    @Inject
    private CajaRepository repository;

    private Caja registro = new Caja();

    public List<Caja> getLista() {
        return repository.findRange(0, 100);
    }

    public void guardar() {
        try {
            if (registro.getIdCaja() == null) {
                registro.setIdCaja(UUID.randomUUID());
                repository.crear(registro);
            } else {
                repository.modificar(registro);
            }
            mensaje(FacesMessage.SEVERITY_INFO, "Éxito", "Caja guardada correctamente.");
            nuevoRegistro();
        } catch (Exception e) {
            mensaje(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo guardar la caja: " + e.getMessage());
        }
    }

    public void seleccionar(Caja caja) { registro = caja; }
    public void eliminar(Caja caja) {
        try { repository.eliminar(caja); mensaje(FacesMessage.SEVERITY_INFO, "Éxito", "Caja eliminada."); }
        catch (Exception e) { mensaje(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar la caja: " + e.getMessage()); }
        nuevoRegistro();
    }
    public void nuevoRegistro() { registro = new Caja(); registro.setActivo(true); }
    private void mensaje(FacesMessage.Severity nivel, String titulo, String texto) { FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nivel, titulo, texto)); }

    public Caja getRegistro() {
        return registro;
    }

    public void setRegistro(Caja registro) {
        this.registro = registro;
    }
}
