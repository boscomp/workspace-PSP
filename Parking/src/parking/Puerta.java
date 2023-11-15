package parking;

import java.util.Random;

public abstract class Puerta implements Runnable{

	protected Parking parking;
	protected String nombre;
	
	public Puerta(Parking parking, String nombre) {
		this.parking = parking;
		this.nombre = nombre;
	}
	
	protected Integer calcularNumCochesPermitidos() {
		Random random = new Random();
		return random.nextInt(11);
	}
	
	protected void esperarProximaApertura() {
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(3000)+1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
