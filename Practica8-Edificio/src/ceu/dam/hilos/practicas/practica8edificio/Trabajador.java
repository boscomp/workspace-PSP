package ceu.dam.hilos.practicas.practica8edificio;

import java.util.Random;

public abstract class Trabajador implements Runnable {

	protected Edificio edificio;

	public Trabajador(Edificio edificio) {
		this.edificio = edificio;
	}

	public void esperar(String trabajador) {
		if (trabajador == "cualificado") {
			try {

				Thread.sleep(200);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		else {
			try {

				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		}

	

	public Integer getMetros(String trabajador) {
		Random random = new Random();
		if (trabajador == "cualificado") {
			return random.nextInt((6)+5);
		} else {
			return random.nextInt((6));
		}


	}

}
