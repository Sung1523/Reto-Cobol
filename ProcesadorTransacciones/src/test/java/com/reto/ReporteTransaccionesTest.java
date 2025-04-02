package com.reto;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ReporteTransaccionesTest {

    @Test
    void testBalanceFinal() {
        List<Transaccion> transacciones = Arrays.asList(
            new Transaccion(1, "Crédito", 100.00),
            new Transaccion(2, "Débito", 50.00),
            new Transaccion(3, "Crédito", 200.00),
            new Transaccion(4, "Débito", 75.00),
            new Transaccion(5, "Crédito", 150.00)
        );

        // Balance esperado = (100 + 200 + 150) - (50 + 75) = 
        double balanceEsperado = 100+200+150-50-75;
        assertEquals(balanceEsperado, ReporteTransacciones.calcularBalance(transacciones), 
                     "El balance calculado no es el esperado.");
    }

    @Test
    void testBalanceConSaldoNegativo() {
        List<Transaccion> transacciones = Arrays.asList(
            new Transaccion(1, "Débito", 100.00),
            new Transaccion(2, "Débito", 150.00),
            new Transaccion(3, "Débito", 50.00)
        );

        // Balance esperado = (0) - (100 + 150 + 50) = 
        double balanceEsperado = -300.00;
        assertEquals(balanceEsperado, ReporteTransacciones.calcularBalance(transacciones), 
                     "El balance calculado no es el esperado.");
    }

    @Test
    void testBalanceConSoloCreditos() {
        List<Transaccion> transacciones = Arrays.asList(
            new Transaccion(1, "Crédito", 100.00),
            new Transaccion(2, "Crédito", 200.00)
        );

        // Balance esperado = (100 + 200) - (0) = 300.00
        double balanceEsperado = 300.00;
        assertEquals(balanceEsperado, ReporteTransacciones.calcularBalance(transacciones), 
                     "El balance calculado no es el esperado.");
    }

    @Test
    void testBalanceConSoloDebitos() {
        List<Transaccion> transacciones = Arrays.asList(
            new Transaccion(1, "Débito", 50.00),
            new Transaccion(2, "Débito", 75.00)
        );

        // Balance esperado = (0) - (50 + 75) = -125.00
        double balanceEsperado = -125.00;
        assertEquals(balanceEsperado, ReporteTransacciones.calcularBalance(transacciones), 
                     "El balance calculado no es el esperado.");
    }
}