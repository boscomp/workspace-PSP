package sockets.multihilo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCPSocket {
	InputStream is;
	Socket socket;
	String serverIP;
	int serverPort;
	
	public ClientTCPSocket(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.printf("[Cliente] Estableciendo conexión socket ...%n");
		socket = new Socket(serverIP, serverPort);
		System.out.printf("[Cliente %s:%d] Conexión socket establecida ...%n", serverIP, serverPort);
		is = socket.getInputStream();
	}
	
	public void stop() throws IOException {
		System.out.printf("[Cliente %s:%d] Cerrando conexión socket ...%n", serverIP, serverPort);
		is.close();
		socket.close();
		System.out.printf("[Cliente %s:%d] Conexión socket cerrada.%n", serverIP, serverPort);
	}
	
	public static void main(String[] args) {
		ClientTCPSocket client = new ClientTCPSocket("localhost", 49171);
		
		try {
			client.start();
			
			int datoRecibido = client.is.read();
			System.out.printf("[Cliente %s:%d] Mensaje recibido: %d%n", 
					client.serverIP, client.serverPort, datoRecibido);		
			client.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}