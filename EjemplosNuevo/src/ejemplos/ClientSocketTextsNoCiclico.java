package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ClientSocketTextsNoCiclico {
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	
	public ClientSocketTextsNoCiclico (String serverIP, int serverPort) {
		super();
		this.serverIP=serverIP;
		this.serverPort=serverPort;
	}
	
	
	public void start() throws IOException {
		System.out.println("(Cliente) Estableciendo conexión...");
		socket = new Socket(serverIP, serverPort);
		os = socket.getOutputStream();
		is= socket.getInputStream();
		System.out.println("(Cliente) Conexión establecida.");
		
	}
	
	public void stop() throws IOException {
		System.out.println("(Cliente) Cerrando conexión...");
		is.close();
		os.close();
		socket.close();
		System.out.println("(Cliente) Conexiones cerradas.");
	}
	
	public void abrirCanalesDeTexto() {
		System.out.println("(Cliente) Abriendo canales de texto ...");
		// lectura
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		// escritura
		pw = new PrintWriter(os, true); // flush automático
		System.out.println("(Cliente) Canales de texto abiertos.");

	}

	public void cerrarCanalesDeTexto() throws IOException {
		System.out.println("(Cliente) Cerrando canales de texto ...");
		// canal de lectura
		br.close();
		isr.close();
		// canal de escritura
		pw.close();
		System.out.println("(Cliente) Canales de texto cerrados.");

	}
	

	public String leerMensajeTexto() throws IOException {
		System.out.println("(Cliente) Leyendo mensaje ...");
		String mensaje = br.readLine();
		System.out.println("(Cliente) Mensaje leído.");
		return mensaje;
	}

	public void enviarMensajeTexto(String mensaje) {
		System.out.println("(Cliente) Enviando mensaje ...");
		pw.println(mensaje);
		System.out.println("(Cliente) Mensaje enviado.");
	}
	public static void main(String[] args) {
		
		ClientSocketTextsNoCiclico cliente = new ClientSocketTextsNoCiclico("localhost", 8080);
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

		try {

		cliente.start();
		System.out.println("(Cliente) Escriba un mensaje para enviar al servidor (o 'FIN' para terminar): ");
		String mensajeParaEnviar = consoleReader.readLine();
		cliente.enviarMensajeTexto(mensajeParaEnviar);
		
		System.out.printf("(Cliente-%s:%d) Enviado: %d%n", cliente.serverIP, cliente.serverPort, mensajeParaEnviar);
	
		System.out.printf("(Cliente-%s:%d) Recibido: %d%n", cliente.serverIP, cliente.serverPort, cliente.is.read());
		cliente.cerrarCanalesDeTexto();
		cliente.stop();
			
		
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
	

