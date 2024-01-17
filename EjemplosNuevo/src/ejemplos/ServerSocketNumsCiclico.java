package ejemplos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketNumsCiclico {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	public ServerSocketNumsCiclico(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		
	}
	public void start() throws IOException {
		System.out.println("(Servidor) Servidor esperando conexión...");
		socket= serverSocket.accept();
		is=socket.getInputStream();
		os=socket.getOutputStream();
		System.out.println("(Servidor) Conexión abierta.");
	}
	public void stop() throws IOException{
		System.out.println("(Servidor) Servidor cerrando conexión...");
		is.close();
		os.close();
		serverSocket.close();
		System.out.println("(Servidor) Conexión cerrada.");
	}
	
	public static void main(String[] args) {
		try {
			ServerSocketNumsCiclico servidor = new ServerSocketNumsCiclico(8080);
			servidor.start();
			while (true) {
				int num=servidor.is.read();
				int numAMandar = num+1;
				System.out.println("Mensaje del cliente: "+num);
				
				servidor.os.write(numAMandar);
				if (num==-1) {
				break;
				}
			}
			servidor.stop();
		} catch(IOException e) {
		e.printStackTrace();	
		}
	}
}
