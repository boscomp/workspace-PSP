package ej1Cafeteria;

import java.util.Random;

public class Alumno implements Runnable {

	private Cafeteria cafeteria;
	
	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep((random.nextInt(4))*1000);

				if (cafeteria.haySitioYEntra()) {
					Thread.sleep((random.nextInt(8))*1000); // de 0 a 7
					cafeteria.salePersona();
				} else {
					System.out.println("No puedo entrar. La cafeter�a est� llena");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		consumir();
	}
}