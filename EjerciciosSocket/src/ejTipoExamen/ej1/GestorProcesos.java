package ejTipoExamen.ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;

public class GestorProcesos implements Runnable{
	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private PrintWriter pw;
	private InputStreamReader isr;
	private BufferedReader br;

	public GestorProcesos(Socket socket) throws IOException {
		this.socket = socket;
		os= socket.getOutputStream();
		is = socket.getInputStream();
		pw = new PrintWriter(os, true); //true para que haga autoflush (que te mande la linea y no se la guarde)
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}

	public String codificar(String mensaje) throws IOException {
	
		String encodedString = Base64.getEncoder().encodeToString(mensaje.getBytes());
		return encodedString;
	}
	
	public String decodificar(String mensaje) throws IOException {
		byte[] decodedBytes = Base64.getDecoder().decode(mensaje);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}


	@Override
	public void run() {
		try {

			// Recepción del mensaje del cliente y respuesta
			while (true) {
				
				String mensajeRecibido = br.readLine();
				if (mensajeRecibido.substring(0, 3).equals("#0#")) {
					pw.println(mensajeRecibido.substring(0,3));
					break;
				}
				else if (mensajeRecibido.substring(0, 3).equals("#1#")) {
					String codigo=codificar(mensajeRecibido.substring(3));
					pw.println(codigo);
				}
				else if (mensajeRecibido.substring(0, 3).equals("#2#")) {
					String decodificado=decodificar(mensajeRecibido.substring(3));
					pw.println(decodificado);
				}
				else {
					pw.println("#99#");
				}
			}

	
			pw.close();
			br.close();
			isr.close();
			os.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
