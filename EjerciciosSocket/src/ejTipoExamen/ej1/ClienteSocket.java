package ejTipoExamen.ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class ClienteSocket {
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private InputStream is;
	private OutputStream os;

	// añadiendo las elementos necesarios para transferir cadenas de caracteres
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public ClienteSocket(String serverIP, int serverPort) throws UnknownHostException, IOException {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		socket=new Socket(serverIP, serverPort);
		os= socket.getOutputStream();
		is = socket.getInputStream();
		pw = new PrintWriter(os, true); //true para que haga autoflush (que te mande la linea y no se la guarde)
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("(Cliente) Estableciendo conexión ...");
		socket = new Socket(serverIP, serverPort);
		os = socket.getOutputStream();
		is = socket.getInputStream();
		System.out.println("(Cliente) Conexión establecida.");
	}

	public void stop() throws IOException {
		System.out.println("(Cliente) Estableciendo conexión ...");
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
		ClienteSocket cliente;
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			cliente = new ClienteSocket("localhost", 8001);
			while (true) {
				System.out.println("(Cliente) Escriba un mensaje para enviar al servidor: ");
				String mensajeParaEnviar = consoleReader.readLine();
				if (mensajeParaEnviar.substring(0, 3).equals("#0#")) {
					break;
				}
				

				cliente.enviarMensajeTexto(mensajeParaEnviar);
				String mensajeRecibido = cliente.leerMensajeTexto();
				System.out.println("(Cliente) Mensaje recibido: " + mensajeRecibido);
			}
			cliente.pw.close();
			cliente.br.close();
			cliente.isr.close();
			cliente.os.close();
			cliente.is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				consoleReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
