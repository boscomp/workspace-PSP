package serviciosenred;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;

import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

// Clase para gestionar peticiones HTTP en Java 11.
public class GestorPeticionesHTTPJava11 {
    // Método para almacenar el contenido de una página web en un archivo local.
    public int almacenarPagina(String esquema, String servidor, String recurso, String path) {
        try {
            // Codifica el recurso para que pueda ser incluido en la URL sin problemas con caracteres especiales.
            recurso = URLEncoder.encode(recurso, StandardCharsets.UTF_8);
            // Construye la dirección completa a la que se hará la petición.
            String direccionCompleta = esquema + servidor + recurso;

            // Crea una instancia de HttpClient configurada para seguir redirecciones y usar HTTP/1.1.
            HttpClient httpClient = HttpClient
            	.newBuilder()
            	.version(Version.HTTP_1_1) // Usa HTTP versión 1.1.
            	.followRedirects(HttpClient.Redirect.NORMAL) // Sigue redirecciones de forma normal.
            	.build();
            // Construye la petición HTTP con los encabezados requeridos.
            HttpRequest request = HttpRequest.newBuilder()
            		.GET() // Se especifica que el método de la petición es GET.
                    .uri(URI.create(direccionCompleta)) // Establece la URI de la petición.
                    .headers("Content-Type", "text/plain") // Establece el tipo de contenido esperado.
                    .setHeader("User-Agent", "Moxilla/5.0") // Establece el User-Agent para simular un navegador.
                    .build();
            
            // Envía la petición HTTP y guarda la respuesta en un archivo en el camino especificado.
            HttpResponse<Path> response = httpClient.send(request, 
            		HttpResponse.BodyHandlers.ofFile(Path.of(path)));
            // Imprime el camino del archivo donde se guardó la respuesta.
            System.out.println(response.body());

            // Devuelve el código de estado de la respuesta HTTP.
            return response.statusCode();
        } catch (Exception e) {
            e.printStackTrace();
            // Devuelve -1 en caso de excepción para indicar un error.
            return -1;
        }
    }

    // Método principal que se usa para probar la clase GestorPeticionesHTTPJava11.
    public static void main(String[] args) {
        GestorPeticionesHTTPJava11 gestor = new GestorPeticionesHTTPJava11();
        // Realiza una petición a dle.rae.es buscando la palabra "tiburón" y almacena el resultado en 'resultado.html'.
        int estado = gestor.almacenarPagina("https://", "dle.rae.es/", "tiburón", "resultado.html");
        // Imprime el código de estado HTTP para verificar si la petición fue exitosa.
        System.out.println("Código de estado HTTP: " + estado);
    }
}