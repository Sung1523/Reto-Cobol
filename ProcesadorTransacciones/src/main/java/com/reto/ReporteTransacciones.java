package com.reto;

import java.util.List;

/**
 * Clase que genera un reporte basado en las transacciones procesadas.
 */
public class ReporteTransacciones {
    public static void generarReporte(List<Transaccion> transacciones) {
        double balance = calcularBalance(transacciones); // Calcula el balance usando el método
        int[] conteo = contarTransacciones(transacciones); // Obtiene el conteo de créditos y débitos
        int creditos = conteo[0];
        int debitos = conteo[1];
        Transaccion transaccionMayor = encontrarTransaccionMayor(transacciones); // Encuentra la transacción de mayor monto
    
        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones disponibles para procesar.");
        } else {
            System.out.println("Balance Final: " + balance);
            System.out.println("Transacción de Mayor Monto: ID " + transaccionMayor.getId() + " - " + transaccionMayor.getMonto());
            System.out.println("Conteo de Transacciones: Crédito: " + creditos + " Débito: " + debitos);
        }
    }
    
    // Método para calcular el balance final
    public static double calcularBalance(List<Transaccion> transacciones) {
        if (transacciones.isEmpty()) {
            return 0.0;
        }
    
        double balance = 0.0;
    
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getTipo().equalsIgnoreCase("Crédito")) {
                balance += transaccion.getMonto();
            } else if (transaccion.getTipo().equalsIgnoreCase("Débito")) {
                balance -= transaccion.getMonto();
            }
        }
    
        return balance;
    }
    
    // Método para contar las transacciones de tipo "Crédito" y "Débito"
    public static int[] contarTransacciones(List<Transaccion> transacciones) {
        int creditos = 0, debitos = 0;
    
        for (Transaccion t : transacciones) {
            if (t.getTipo().equalsIgnoreCase("Crédito")) {
                creditos++;
            } else if (t.getTipo().equalsIgnoreCase("Débito")) {
                debitos++;
            }
        }
    
        return new int[]{creditos, debitos}; // Retorna un array con los conteos
    }
    
    // Método para encontrar la transacción de mayor monto
    public static Transaccion encontrarTransaccionMayor(List<Transaccion> transacciones) {
        if (transacciones.isEmpty()) {
            return new Transaccion(0, "N/A", 0.0); // Retorna una transacción vacía si la lista está vacía
        }
    
        Transaccion transaccionMayor = transacciones.get(0);
        for (Transaccion t : transacciones) {
            if (t.getMonto() > transaccionMayor.getMonto()) {
                transaccionMayor = t;
            }
        }
    
        return transaccionMayor;
    }
}