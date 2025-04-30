# Procesador de Transacciones Bancarias (CLI)

## 📌 Introducción
Este proyecto es una aplicación de línea de comandos (CLI) desarrollada en **Java**, que procesa un archivo CSV con transacciones bancarias y genera un reporte con la siguiente información:


1. **Balance Final**: Suma de los montos de transacciones de tipo "Crédito" menos la suma de los montos de tipo "Débito".
2. **Transacción de Mayor Monto**: Identificación del ID y monto de la transacción con el valor más alto.
3. **Conteo de Transacciones**: Cantidad total de transacciones de tipo "Crédito" y "Débito".

## 🚀 Tecnologías Utilizadas
- **Java**
- **Maven** (para gestión de dependencias)
- **JUnit 5** (para pruebas unitarias)
- **CSV Parser** para manejo de archivos CSV

## 🛠️ Instrucciones de Ejecución
### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/Sung1523/Reto-Cobol.git
cd ProcesadorTransacciones
```

### 2️⃣ Compilar el Proyecto con Maven
```bash
mvn clean install
```

### 3️⃣ Ejecutar la Aplicación
```bash
java -jar target/ProcesadorTransacciones.jar src/main/resources/transactions.csv
```

## 🔍 Enfoque y Solución
El programa sigue una estructura modular dividiendo las responsabilidades en:
- **Lectura del CSV**: Se utiliza `ProcesadorCSV` para leer las transacciones desde un archivo CSV.
- **Procesamiento de Datos**: Se implementa `ReporteTransacciones` para calcular el balance, el conteo de transacciones y la mayor transacción.
- **Manejo de Casos Especiales**: Se agregó validación para cuando la lista de transacciones está vacía, mostrando un mensaje claro en la CLI.

## 📂 Estructura del Proyecto
```
ProcesadorTransacciones
│── src
│   ├── main
│   │   ├── java
│   │   │   └── com/reto/
│   │   │       ├── Main.java               # Punto de entrada de la aplicación
│   │   │       ├── Transaccion.java        # Modelo de datos para una transacción
│   │   │       ├── ProcesadorCSV.java      # Clase para leer y procesar el archivo CSV
│   │   │       ├── ReporteTransacciones.java # Lógica para calcular el balance, mayor transacción y conteo
│   ├── test
│   │   ├── java
│   │   │   └── com/reto/
│   │   │       ├── ProcesadorCSVTest.java   # Pruebas unitarias para la lectura de CSV
│   │   │       ├── ReporteTransaccionesTest.java # Pruebas unitarias para cálculos
│── pom.xml  # Configuración de Maven
│── README.md # Documentación del proyecto
│── transactions.csv # Archivo de ejemplo con transacciones
```

## 🧪 Documentación y Calidad del Código
El código está documentado con comentarios explicativos en los puntos clave del procesamiento de datos. Además, se han implementado pruebas unitarias con JUnit para validar el correcto funcionamiento de la aplicación.

### Ejemplo de Pruebas Unitarias
```java
@Test
void testBalanceFinal() {
    List<Transaccion> transacciones = Arrays.asList(
        new Transaccion(1, "Crédito", 100),
        new Transaccion(2, "Débito", 50)
    );
    double balanceEsperado = 50;
    assertEquals(balanceEsperado, ReporteTransacciones.calcularBalance(transacciones));
}
```

Este README proporciona una guía clara sobre el proyecto, su ejecución y su estructura. ¡Si tienes alguna duda o sugerencia, no dudes en contribuir! 🚀}

## Contacto
- Correo: samantha.ramos@pucp.edu.pe.

- Telefono: 993801460.

