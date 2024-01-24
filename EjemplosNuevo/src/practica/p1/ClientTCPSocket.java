package practica.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ClientTCPSocket {
	InputStream is;
	Socket socket;
	String serverIP;
	int serverPort;
	private OutputStream os;
	
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	
	public ClientTCPSocket(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.printf("[Cliente] Estableciendo conexión socket ...%n");
		socket = new Socket(serverIP, serverPort);
		System.out.printf("[Cliente %s:%d] Conexión socket establecida ...%n", serverIP, serverPort);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}
	
	public void stop() throws IOException {
		System.out.printf("[Cliente %s:%d] Cerrando conexión socket ...%n", serverIP, serverPort);
		is.close();
		socket.close();
		System.out.printf("[Cliente %s:%d] Conexión socket cerrada.%n", serverIP, serverPort);
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
	
	public static void main(String[] args) {
		ClientTCPSocket client = new ClientTCPSocket("localhost", 49171);
		
		try {
			client.start();
			client.abrirCanalesDeTexto();
			int numeroAleatorio = new Random().nextInt(10)+1;
			System.out.println(numeroAleatorio);
			for (int i=0; i<10;i++) {
			client.os.write(numeroAleatorio);
			String mensaje=client.leerMensajeTexto();
//			int datoRecibido = client.is.read();
//			System.out.printf("[Cliente %s:%d] Mensaje recibido: %d%n", 
//					client.serverIP, client.serverPort, datoRecibido);		
			System.out.println("CLIENTE:::: MENSAJE: "+i+" vez: "+mensaje);
			}
			client.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

