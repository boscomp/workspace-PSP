package ejemplos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ClientSocketNumsNoCiclico {
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	public ClientSocketNumsNoCiclico (String serverIP, int serverPort) {
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
	
//	public static void main(String[] args) {
//		ClientSocketNumsNoCiclico cliente = new ClientSocketNumsNoCiclico("localhost", 8080);
//		try {
//			Random random = new Random();
//			int num = random.nextInt(255);
//			cliente.start();
//			cliente.os.write(num);
//			System.out.println("Mensaje del servidor: "+cliente.is.read());
//			cliente.stop();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		
		ClientSocketNumsNoCiclico cliente = new ClientSocketNumsNoCiclico("localhost", 8080);
		
		try {
			Random random = new Random();
			cliente.start();
			Integer datoEnviado = random.nextInt(255);
			cliente.os.write(datoEnviado);
			System.out.printf("(Cliente-%s:%d) Enviado: %d%n", cliente.serverIP, cliente.serverPort, datoEnviado);
			cliente.os.write(5);
			System.out.printf("(Cliente-%s:%d) Recibido: %d%n", cliente.serverIP, cliente.serverPort, cliente.is.read());
			cliente.stop();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
