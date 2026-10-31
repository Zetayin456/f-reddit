package sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Caracteristica;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Descuento;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Empleado;
import sv.edu.ues.occ.ing.ppi115_2026.pos.cafefe.entity.Producto;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActiveDropdownDAOTest {
    @Mock EntityManager em;
    private static void inject(Object dao, EntityManager em) throws Exception {
        Field field = dao.getClass().getDeclaredField("em"); field.setAccessible(true); field.set(dao, em);
    }

    @Test void employeeDropdownQueriesOnlyActiveEmployees() throws Exception {
        EmpleadoDAO dao = new EmpleadoDAO(); inject(dao, em);
        @SuppressWarnings("unchecked") TypedQuery<Empleado> query = mock(TypedQuery.class);
        List<Empleado> active = List.of(new Empleado());
        when(em.createQuery(anyString(), eq(Empleado.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(active);
        assertSame(active, dao.findActivos());
        verify(em).createQuery(contains("e.activo = TRUE"), eq(Empleado.class));
    }

    @Test void characteristicDropdownRequiresActiveCharacteristicAndType() throws Exception {
        CaracteristicaDAO dao = new CaracteristicaDAO(); inject(dao, em);
        @SuppressWarnings("unchecked") TypedQuery<Caracteristica> query = mock(TypedQuery.class);
        List<Caracteristica> active = List.of(new Caracteristica());
        when(em.createQuery(anyString(), eq(Caracteristica.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(active);
        assertSame(active, dao.findActivos());
        verify(em).createQuery(contains("c.activo = TRUE AND c.idTipoCaracteristica.activo = TRUE"), eq(Caracteristica.class));
    }

    @Test void discountDropdownRequiresItsDiscountTypeToBeActive() throws Exception {
        DescuentoDAO dao = new DescuentoDAO(); inject(dao, em);
        @SuppressWarnings("unchecked") TypedQuery<Descuento> query = mock(TypedQuery.class);
        List<Descuento> active = List.of(new Descuento());
        when(em.createQuery(anyString(), eq(Descuento.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(active);
        assertSame(active, dao.findActivos());
        verify(em).createQuery(contains("t.activo = TRUE"), eq(Descuento.class));
    }

    @Test void productRepositoryFetchesCharacteristicsAndTheirTypes() throws Exception {
        ProductoDAO dao = new ProductoDAO(); inject(dao, em);
        @SuppressWarnings("unchecked") TypedQuery<Producto> query = mock(TypedQuery.class);
        List<Producto> products = List.of(new Producto());
        when(em.createQuery(anyString(), eq(Producto.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(products);
        assertSame(products, dao.findConCaracteristicas());
        ArgumentCaptor<String> jpql = ArgumentCaptor.forClass(String.class);
        verify(em).createQuery(jpql.capture(), eq(Producto.class));
        assertTrue(jpql.getValue().contains("LEFT JOIN FETCH pc.idCaracteristica c"));
        assertTrue(jpql.getValue().contains("LEFT JOIN FETCH c.idTipoCaracteristica"));
    }
}
