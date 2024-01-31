package codificacionEjemplo;

import java.util.Base64;
import java.util.Scanner;

public class CodificadorBase64 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que introduzca una cadena
        System.out.println("Introduce una cadena para codificar en Base64:");
        String input = scanner.nextLine();

        // Codificar la entrada en Base64
        String encodedString = Base64.getEncoder().encodeToString(input.getBytes());

        // Mostrar la cadena codificada
        System.out.println("Cadena codificada en Base64: " + encodedString);

        // Cerrar el scanner
        scanner.close();
    }
}
