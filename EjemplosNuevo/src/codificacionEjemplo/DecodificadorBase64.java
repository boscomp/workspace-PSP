package codificacionEjemplo;

import java.util.Base64;
import java.util.Scanner;

public class DecodificadorBase64 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que introduzca una cadena en Base64
        System.out.println("Introduce una cadena codificada en Base64:");
        String inputBase64 = scanner.nextLine();

        try {
            // Decodificar la cadena de Base64
            byte[] decodedBytes = Base64.getDecoder().decode(inputBase64);

            // Convertir los bytes decodificados a una cadena
            String decodedString = new String(decodedBytes);

            // Mostrar la cadena decodificada
            System.out.println("Cadena decodificada: " + decodedString);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: La entrada no está en un formato Base64 válido.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}