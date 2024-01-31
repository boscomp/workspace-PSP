package cifradoEjemplo;

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que introduzca una cadena
        System.out.println("Introduce una cadena para aplicar el hash MD5:");
        String input = scanner.nextLine();

        try {
            // Obtener una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calcular el hash MD5 de la cadena
            byte[] hashBytes = md.digest(input.getBytes());

            // Convertir los bytes del hash a una cadena en formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            // Mostrar la cadena cifrada
            System.out.println("Resultado del hash MD5: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo MD5 no está disponible.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
