import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class conversor {
    private static final String BRL = "BRL";
    private static final String ARS = "ARS";
    private static final String COP = "COP";
    private static final String USD = "USD";

    public static void realizarConversion(int opcion, Scanner scanner) {
        String monedaBase = "";
        String monedaDestino = "";

        switch (opcion) {
            case 1 -> { monedaBase = BRL; monedaDestino = USD; }
            case 2 -> { monedaBase = USD; monedaDestino = BRL; }
            case 3 -> { monedaBase = ARS; monedaDestino = USD; }
            case 4 -> { monedaBase = USD; monedaDestino = ARS; }
            case 5 -> { monedaBase = COP; monedaDestino = USD; }
            case 6 -> { monedaBase = USD; monedaDestino = COP; }
            default -> {
                System.out.println("Lo siento la opción no es válida.");
                return;
            }
        }

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try {
            double tasa = usoDeAPI.obtenerTasaCambio(monedaBase, monedaDestino);
            double resultado = cantidad * tasa;

            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaHora = ahora.format(formato);

            System.out.printf("Fecha y hora: %s%n", fechaHora);
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", cantidad, monedaBase, resultado, monedaDestino);

            registroServicio.guardarSolicitud(cantidad, monedaBase, resultado, monedaDestino, fechaHora);
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
