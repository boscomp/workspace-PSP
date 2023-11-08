package ejImpresora;


public class Impresora {

	private String usuarioActual = null;
	private Integer numCopias = 1;
	
	
	public void imprimir(String usuario, String texto) {
	
		System.out.println(usuario + " - (copia " + numCopias + ") - " + texto);
	
		// Despu�s de imprimir, incremento el n�mero de copias que llevo
		numCopias++;

		if (numCopias > 5) {
			numCopias = 1;
		}
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

