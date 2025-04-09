import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class registroServicio {
    private static final String ARCHIVO = "historialDeConversiones.txt";

    public static void guardarSolicitud(double cantidad, String monedaBase, double resultado, String monedaDestino, String fechaHora) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("historialDeConversiones.txt", true))) {
            writer.printf("[%s] %.2f %s a %s = %.2f%n", fechaHora, cantidad, monedaBase, monedaDestino, resultado);
        } catch (IOException e) {
            System.out.println("Error al guardar la solicitud: " + e.getMessage());
        }
    }
}
