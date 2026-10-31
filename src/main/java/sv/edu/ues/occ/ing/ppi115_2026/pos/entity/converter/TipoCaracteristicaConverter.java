package sv.edu.ues.occ.ing.ppi115_2026.pos.entity.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import java.util.UUID;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control.TipoCaracteristicaRepository;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.TipoCaracteristica;

@FacesConverter(value = "tipoCaracteristicaConverter", managed = true)
public class TipoCaracteristicaConverter implements Converter<TipoCaracteristica> {

    @Inject
    private TipoCaracteristicaRepository tipoCaracteristicaRepository;

    @Override
    public TipoCaracteristica getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            UUID id = UUID.fromString(value);
            return tipoCaracteristicaRepository.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, TipoCaracteristica value) {
        if (value == null || value.getIdTipoCaracteristica() == null) {
            return "";
        }
        return value.getIdTipoCaracteristica().toString();
    }
}