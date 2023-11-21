package ceu.dam.hilos.practicas.practica8edificio;

public class Edificio {

	private Integer construido;
	private Integer metrosTotales;
	public boolean terminado;

	public Edificio(Integer metrosTotales) {
		construido = 0;
		this.metrosTotales = metrosTotales;
		terminado = false;

	}

	// Se invoca a este m�todo para construir los metros indicados en el edificio.
	// Cuando haya terminado de construirse, devolver� true.
	// En caso contrario, devolver� false
	public synchronized boolean construir(Integer metros) {
		if (terminado) {
			return true;
		}
		if (metrosTotales + metros > 0) {
			construido += metros;
			System.out.println("Se construyen " + metros + " metros >> Altura alcanzada: " + construido);
			if (construido >= metrosTotales) {
				System.out.println("EDIFICIO TERMINADO!!");
				terminado = true;
			}
			
		}
		return terminado;
	}
	public Boolean construirEdificio() {
		if (terminado) {
			return false;
		}
		
		return true;
	}

}
