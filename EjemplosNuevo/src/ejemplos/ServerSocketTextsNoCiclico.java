package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTextsNoCiclico {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;

	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public ServerSocketTextsNoCiclico(int port) throws IOException {
		serverSocket = new ServerSocket(port);

	}

	public void start() throws IOException {
		System.out.println("(Servidor) Servidor esperando conexión...");
		socket = serverSocket.accept();
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println("(Servidor) Conexión abierta.");
	}

	public void stop() throws IOException {
		System.out.println("(Servidor) Servidor cerrando conexión...");
		is.close();
		os.close();
		serverSocket.close();
		System.out.println("(Servidor) Conexión cerrada.");
	}

	public void abrirCanalesDeTexto() {
		System.out.println("(Servidor) Abriendo canales de texto ...");
		// lectura
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		// escritura
		pw = new PrintWriter(os, true); // flush automático
		System.out.println("(Servidor) Canales de texto abiertos.");

	}

	public void cerrarCanalesDeTexto() throws IOException {
		System.out.println("(Servidor) Cerrando canales de texto ...");
		// canal de lectura
		br.close();
		isr.close();
		// canal de escritura
		pw.close();
		System.out.println("(Servidor) Canales de texto cerrados.");

	}

	public String leerMensajeTexto() throws IOException {
		System.out.println("(Servidor) Leyendo mensaje ...");
		String mensaje = br.readLine();
		System.out.println("(Servidor) Mensaje leído.");
		return mensaje;
	}

	public void enviarMensajeTexto(String mensaje) {
		System.out.println("(Servidor) Enviando mensaje ...");
		pw.println(mensaje);
		System.out.println("(Servidor) Mensaje enviado.");
	}

	public static void main(String[] args) {
		try {
			ServerSocketTextsNoCiclico servidor = new ServerSocketTextsNoCiclico(8080);
			servidor.start();
			servidor.abrirCanalesDeTexto();
			String mensajeRecibido = servidor.leerMensajeTexto();

			System.out.println("(Servidor) Mensaje recibido: " + mensajeRecibido);
			servidor.enviarMensajeTexto("Listo");
			servidor.cerrarCanalesDeTexto();
			servidor.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
