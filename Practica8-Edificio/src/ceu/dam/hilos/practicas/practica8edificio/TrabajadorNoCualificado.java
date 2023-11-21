package ceu.dam.hilos.practicas.practica8edificio;

import java.util.Random;

public class TrabajadorNoCualificado  extends Trabajador{


	public TrabajadorNoCualificado(Edificio edificio) {
		super(edificio);
		
	}
	public void trabajar() {
	
		
		while(edificio.construirEdificio()) {
			Integer metrosConstruidos=getMetros("no cualificado");
			edificio.construir(metrosConstruidos);
			esperar("no cualificado");
			
		}
	}
	@Override
	public void run() {
	
		trabajar();
		
	}

}
