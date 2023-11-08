package ej1Cafeteria;

import java.util.Random;

public class Profesor implements Runnable {

	private Cafeteria cafeteria;

	public Profesor(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public void consumir() {
		Random random = new Random();
		while (true) {
			try {

				Thread.sleep((random.nextInt(3)+1)*1000);
				if (cafeteria.haySitioYEntra()) {
					Thread.sleep((random.nextInt(4)+2)*1000); 
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
