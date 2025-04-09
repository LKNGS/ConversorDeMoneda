import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner

            if (opcion >= 1 && opcion <= 6) {
                Object Conversor;
                Conversor.realizarConversion(opcion, scanner);
            } else if (opcion == 7) {
                System.out.println("¡Hasta luego!");
            } else {
                System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Conversor de Moneda ---");
        System.out.println("1. Peso colombiano a Dólar");
        System.out.println("2. Dólar a Peso colombiano");
        System.out.println("3. Bolívar a Dólar");
        System.out.println("4. Dólar a Bolívar");
        System.out.println("5. Peso mexicano a Dólar");
        System.out.println("6. Dólar a Peso mexicano");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
}
}