package buzon;

import java.util.Random;

public class Receptor implements Runnable{
	private Buzon buzon;

	public Receptor(Buzon buzon) {
		this.buzon=buzon;
	}
	
	
	

	
	public void leer () {
		Random random = new Random();

		while (true) {
		if (buzon.estaLleno()) {
			buzon.saleMensaje();
		
			System.err.println("Mensaje: "+buzon.getMensaje());
			System.out.println();
			
			
		}
		else {
			try {
				System.out.println("No hay mensaje para mí");
				Thread.sleep(random.nextInt(3000)+1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	}
	
	@Override
	public void run() {
		leer();
		
	}
}
