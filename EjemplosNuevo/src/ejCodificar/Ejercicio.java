package ejCodificar;

import java.util.Base64;
import java.util.Random;

public class Ejercicio {


	public static String generarPalabra() {
		String pal = "";
		Random rnd = new Random();
		for (int i = 0; i < 4; i++) {

			int letra = rnd.nextInt(122-97)+97;
			pal += (char)letra;
	
	

		}
		

		return pal;
	}

	public static void main(String[] args) {

		String palabra = generarPalabra();
		System.out.println("palabra= " + palabra);

		String encodedString = Base64.getEncoder().encodeToString(palabra.getBytes());

		System.out.println("Cadena codificada en Base64: " + encodedString);
		 try {
	            // Decodificar la cadena de Base64
	            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

	            // Convertir los bytes decodificados a una cadena
	            String decodedString = new String(decodedBytes);

	            // Mostrar la cadena decodificada
	            System.out.println("Cadena decodificada: " + decodedString);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: La entrada no está en un formato Base64 válido.");
	        }

	}
}
