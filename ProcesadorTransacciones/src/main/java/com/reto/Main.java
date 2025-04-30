package com.reto;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                try {
                    new ProcessBuilder("cmd", "/c", "chcp", "65001").inheritIO().start().waitFor();
                } catch (Exception e) {
                    System.err.println("No se pudo configurar la consola para UTF-8");
                }
            }

            //String archivoCSV = "src/main/resources/transactions_large.csv";
            String archivoCSV = "src/main/resources/data.csv";

            List<Transaccion> transacciones = ProcesadorCSV.leerCSV(archivoCSV);
            // Verifica si la lista está vacía y muestra un mensaje adecuado
            if (transacciones.isEmpty()) {
                System.out.println("No se encontraron transacciones para procesar.");
                System.out.println("Balance final: 0.00");
            } else {
                ReporteTransacciones.generarReporte(transacciones);
            }        
    
        } 
        
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}