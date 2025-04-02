package com.reto;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de leer y procesar un archivo CSV con transacciones bancarias.
 */
public class ProcesadorCSV {
    public static List<Transaccion> leerCSV(String nombreArchivo) {
        List<Transaccion> transacciones = new ArrayList<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), StandardCharsets.UTF_8))) {
            br.readLine(); // Omitir la primera línea (encabezado)

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int id = Integer.parseInt(datos[0]);
                    String tipo = datos[1].trim();
                    double monto = Double.parseDouble(datos[2]);

                    transacciones.add(new Transaccion(id, tipo, monto));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return transacciones;
    }
}