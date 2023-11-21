package ceu.dam.hilos.practicas.practica8edificio;

import java.util.Random;

public class TrabajadorCualificado extends Trabajador{

	public TrabajadorCualificado(Edificio edificio) {
		super(edificio);
		
	}
	public void trabajar() {
		
		
		while(edificio.construirEdificio()) {
			
			Integer metrosConstruidos=getMetros("cualificado");
					
			edificio.construir(metrosConstruidos);
			esperar("cualificado");
			
		}
		}
	
	@Override
	public void run() {
		trabajar();
	}

}
