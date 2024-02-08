package ejTipoExamen.ej1;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


public class ServidorSocket {
	private ServerSocket serverSocket;
	private int port;
//	private static long socketAceptados=0;

	public ServidorSocket(int puerto) throws IOException {
		this.port = puerto;
		serverSocket = new ServerSocket(puerto);
	}


	public static void main(String[] args) {
		ServidorSocket servidor=null;
		try {
		
			servidor = new ServidorSocket(8080);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			Socket miSocket=null;
			try {
				miSocket=servidor.serverSocket.accept();
				new Thread(new GestorProcesos(miSocket)).start();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
