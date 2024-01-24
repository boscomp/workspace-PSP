package practica.p1;


import java.io.IOException;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


public class ServerTCPSocket {
	private ServerSocket serverSocket;

	public static final Integer NUM_ALEATORIO = new Random().nextInt(10)+1;
	public ServerTCPSocket(int puerto) throws IOException {
		serverSocket = new ServerSocket(puerto);
		Socket socket = serverSocket.accept();

		for (int i=0; i<10; i++) {

			System.out.println("(Servidor) Conexión establecida.");
			new GestorProcesos(socket).start();			
		}
	}
	
	public void stop() throws IOException {
		serverSocket.close();
	}
	
	
	public static void main(String[] args) {
		try {
			
			ServerTCPSocket servidor = new ServerTCPSocket(49171);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	private ServerSocket serverSocket;
//	public static final Integer NUM_ALEATORIO = new Random().nextInt(10)+1;
//	
//	public ServerTCPSocket(int puerto) throws IOException {
//		serverSocket = new ServerSocket(puerto);
//		for (int i=0; i<10; i++) {
//		Socket socket = serverSocket.accept();
//		
//
////		while(true) {
//			System.out.println("(Servidor) Conexión establecida.");
//			new GestorProcesos(socket).start();			
//		
//	}
//	}
}
