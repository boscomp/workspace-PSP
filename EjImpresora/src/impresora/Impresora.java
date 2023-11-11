package impresora;

public class Impresora {

	private String usuarioActual = null;
	private Integer numCopias = 1;

	public synchronized void imprimir(String usuario, String texto) {
		
		if (isOcupada()&&!isOcupadaPorUsuario(usuario)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!isOcupada()) {
			ocuparImpresora(usuario);
		}
		if (isOcupadaPorUsuario(usuario)){
			
		System.out.println(usuario + " - (copia " + numCopias + ") - " + texto);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Despu�s de imprimir, incremento el n�mero de copias que llevo
		numCopias++;

		if (numCopias > 5) {
			numCopias = 1;
			liberarImpresora();
			notify();
		}
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
