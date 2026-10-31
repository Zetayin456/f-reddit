package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import java.util.UUID;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.TipoDescuento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TipoDescuentoDAOTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private TipoDescuentoDAO tipoDescuentoDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        TipoDescuento entidad = new TipoDescuento();
        entidad.setIdTipoDescuento(UUID.randomUUID());
        tipoDescuentoDAO.create(entidad);
        verify(em, times(1)).persist(entidad);
    }

    @Test
    public void testFind() {
        UUID id = UUID.randomUUID();
        TipoDescuento esperada = new TipoDescuento();
        esperada.setIdTipoDescuento(id);
        when(em.find(TipoDescuento.class, id)).thenReturn(esperada);

        TipoDescuento resultado = tipoDescuentoDAO.find(id);
        assertNotNull(resultado);
        assertEquals(id, resultado.getIdTipoDescuento());
    }

    @Test
    public void testEdit() {
        TipoDescuento entidad = new TipoDescuento();
        entidad.setIdTipoDescuento(UUID.randomUUID());
        tipoDescuentoDAO.edit(entidad);
        verify(em, times(1)).merge(entidad);
    }

    @Test
    public void testRemove() {
        TipoDescuento entidad = new TipoDescuento();
        entidad.setIdTipoDescuento(UUID.randomUUID());

        when(em.merge(entidad)).thenReturn(entidad);

        tipoDescuentoDAO.remove(entidad);

        verify(em, times(1)).merge(entidad);
        verify(em, times(1)).remove(entidad);
    }
}