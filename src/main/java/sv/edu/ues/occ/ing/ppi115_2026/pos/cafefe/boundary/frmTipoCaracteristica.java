package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.boundary;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control.TipoCaracteristicaRepository;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.TipoCaracteristica;

@Named(value = "frmTipoCaracteristica")
@ViewScoped
public class frmTipoCaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TipoCaracteristicaRepository tipoCaracteristicaRepository;

    private TipoCaracteristica registro;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public TipoCaracteristicaRepository getTipoCaracteristicaRepository() {
        return tipoCaracteristicaRepository;
    }

    public TipoCaracteristica createNewEntity() {
        TipoCaracteristica tc = new TipoCaracteristica();
        tc.setIdTipoCaracteristica(UUID.randomUUID());
        tc.setActivo(true);
        return tc;
    }

    public TipoCaracteristica getRegistro() {
        if (registro == null) {
            registro = createNewEntity();
        }
        return registro;
    }

    public void setRegistro(TipoCaracteristica registro) {
        this.registro = registro;
    }

    public void limpiar() {
        this.registro = createNewEntity();
    }

    public void btnCrearHandler() {
        try {
            if (registro.getIdTipoCaracteristica() == null) {
                registro.setIdTipoCaracteristica(UUID.randomUUID());
            }
            tipoCaracteristicaRepository.create(registro);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tipo de característica guardado correctamente"));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo guardar el tipo de característica"));
        }
    }
}
