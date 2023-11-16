package ejImpresora;


public class Impresora {

	private String usuarioActual = null;
	private Integer numCopias = 1;
	
	
	public synchronized boolean imprimir(String usuario, String texto) {
	
		System.out.println(usuario + " - (copia " + numCopias + ") - " + texto);
	
		// Despu�s de imprimir, incremento el n�mero de copias que llevo
		numCopias++;
		usuarioActual=usuario;

		if (numCopias > 5) {
			numCopias = 1;
		}
		if (numCopias<6) {
			return false;
		}
		return true;
	}
	
	public boolean isOcupada() {
		return usuarioActual != null;
	}

	public boolean isOcupadaPorUsuario(String usuario) {
		return isOcupada() && usuarioActual.equals(usuario);
	}
	
	public void liberarImpresora() {
		usuarioActual = null;
	}
	
	public void ocuparImpresora(String usuario) {
		usuarioActual = usuario;
	}
	
}

