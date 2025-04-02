package com.reto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ProcesadorCSVTest {

    @Test
    void testLeerCSV() {
        List<Transaccion> transacciones = ProcesadorCSV.leerCSV("src/main/resources/transactions_large.csv");
        // Verifica que no está vacío
        assertFalse(transacciones.isEmpty(), "La lista de transacciones no debe estar vacía.");

        // Verifica que la cantidad de registros leída sea la esperada (1000 en este caso)
        assertEquals(1000, transacciones.size(), "La cantidad de transacciones leída no es la esperada.");

        // Verifica que el primer registro tiene valores válidos
        Transaccion transaccion = transacciones.get(0);
        assertTrue(transaccion.getMonto() > 0, "El monto de la transacción debe ser mayor que 0.");
        assertTrue(transaccion.getId() > 0, "El ID de la transacción debe ser mayor que 0.");
        assertTrue(transaccion.getTipo().equals("Crédito") || transaccion.getTipo().equals("Débito"), 
                   "El tipo de transacción debe ser 'Crédito' o 'Débito'.");
    }
}