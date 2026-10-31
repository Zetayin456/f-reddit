package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control.TipoDescuentoRepository;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.TipoDescuento;

@Named("tipoDescuentoFrm")
@ViewScoped
public class TipoDescuentoFrm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TipoDescuentoRepository tipoDescuentoRepository;

    private List<TipoDescuento> registros;
    private TipoDescuento registroSeleccionado;

    @PostConstruct
    public void init() {
        btnNuevoHandler();
        cargarRegistros();
    }

    public void cargarRegistros() {
        try {
            if (tipoDescuentoRepository != null) {
                this.registros = tipoDescuentoRepository.findRange(0, 100);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al cargar registros", ex);
        }
    }

    public void btnNuevoHandler(ActionEvent ae) {
        btnNuevoHandler();
    }

    public void btnNuevoHandler() {
        this.registroSeleccionado = new TipoDescuento();
        this.registroSeleccionado.setActivo(true);
    }

    public void btnGuardarHandler(ActionEvent ae) {
        guardar();
    }

    public void btnGuardarHandler() {
        guardar();
    }

public void guardar() {
    try {
        if (this.registroSeleccionado != null) {
            Integer limite = this.registroSeleccionado.getDescuentoMaximo();
            if (limite == null || limite < 0 || limite > 100) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Validación",
                                "El descuento máximo debe estar entre 0% y 100%."));
                return;
            }
            if (this.registroSeleccionado.getIdTipoDescuento() == null) {
                this.registroSeleccionado.setIdTipoDescuento(UUID.randomUUID());
                tipoDescuentoRepository.create(this.registroSeleccionado);
            } else {
                tipoDescuentoRepository.edit(this.registroSeleccionado);
            }
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tipo de Descuento guardado correctamente"));
            btnNuevoHandler();
            cargarRegistros();
        }
    } catch (Exception ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al guardar TipoDescuento", ex);
    }
}

    public void seleccionar(TipoDescuento registro) { this.registroSeleccionado = registro; }

    public void eliminar(TipoDescuento registro) {
        try {
            tipoDescuentoRepository.remove(registro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tipo de descuento eliminado."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar: " + ex.getMessage()));
        }
        btnNuevoHandler();
        cargarRegistros();
    }

    public List<TipoDescuento> getModelo() {
        return registros;
    }

    public List<TipoDescuento> getRegistros() {
        return registros;
    }

    public void setRegistros(List<TipoDescuento> registros) {
        this.registros = registros;
    }

    public TipoDescuento getRegistroSeleccionado() {
        return registroSeleccionado;
    }

    public void setRegistroSeleccionado(TipoDescuento registroSeleccionado) {
        this.registroSeleccionado = registroSeleccionado;
    }
}
