import java.util.Scanner;

public class conversorDeMoneda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion >= 1 && opcion <= 6) {
                conversor.realizarConversion(opcion, scanner);
            } else if (opcion == 7) {
                System.out.println("¡Gracias, vuelve pronto!");
            } else {
                System.out.println("Lo siento, opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n--Bienvenid@--");
        System.out.println("\n*** Conversor de Moneda ***");
        System.out.println("1. Real brasileño --> Dólar :D");
        System.out.println("2. Dólar --> Real brasileño :D");
        System.out.println("3. Peso argentino --> Dólar :D");
        System.out.println("4. Dólar --> Peso argentino :D");
        System.out.println("5. Peso colombiano --> Dólar :D");
        System.out.println("6. Dólar --> Peso colombiano :D");
        System.out.println("7. Salir\n");
        System.out.print("**Porfavor digite una opción: ");
}
}