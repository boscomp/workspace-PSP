package practica.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GestorProcesos extends Thread {
	private Socket socket;
	private OutputStream os;
	private InputStream is;

	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;
	
	public GestorProcesos(Socket socket) {
		this.socket = socket;
	}

	public void realizarProceso() throws IOException {
		os = socket.getOutputStream();
		
		
	metodo();
	}
	public void metodo() {
		

		try {
			is=socket.getInputStream();
			abrirCanalesDeTexto();
			int num=is.read();

			if (num==ServerTCPSocket.NUM_ALEATORIO) {
				enviarMensajeTexto("EXITO");
				
			}
			else {
			enviarMensajeTexto("ERROR");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void abrirCanalesDeTexto() {
		System.out.println("(Gestor de procesos) Abriendo canales de texto ...");
		// lectura
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		// escritura
		pw = new PrintWriter(os, true); // flush automático
		System.out.println("(Gestor de procesos) Canales de texto abiertos.");

	}

	public void cerrarCanalesDeTexto() throws IOException {
		System.out.println("(Gestor de procesos) Cerrando canales de texto ...");
		// canal de lectura
		br.close();
		isr.close();
		// canal de escritura
		pw.close();
		System.out.println("(Gestor de procesos) Canales de texto cerrados.");

	}


	public void enviarMensajeTexto(String mensaje) {
		System.out.println("(Gestor de procesos) Enviando mensaje ...");
		pw.println(mensaje);
		System.out.println("(Gestor de procesos) Mensaje enviado.");
	}

	@Override
	public void run() {
		try {
			realizarProceso();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

