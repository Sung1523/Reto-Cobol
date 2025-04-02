package com.reto;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String archivoCSV = "src/main/resources/transactions_large.csv";

        List<Transaccion> transacciones = ProcesadorCSV.leerCSV(archivoCSV);
        // Verifica si la lista está vacía y muestra un mensaje adecuado
        if (transacciones.isEmpty()) {
            System.out.println("No se encontraron transacciones para procesar.");
            System.out.println("Balance final: 0.00");
        } else {
            ReporteTransacciones.generarReporte(transacciones);
            double balanceFinal = ReporteTransacciones.calcularBalance(transacciones);
            System.out.println("Balance final de las transacciones: " + balanceFinal);
        }        
    }
}