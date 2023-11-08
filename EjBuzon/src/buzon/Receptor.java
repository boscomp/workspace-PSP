package buzon;

import java.util.Random;

public class Receptor implements Runnable{
	private Buzon buzon;

	public Receptor(Buzon buzon) {
		this.buzon=buzon;
	}
	
	
	

	
	public void leer () {
		Random random = new Random();
		int cont=0;
		while (cont<1) {
		if (buzon.estaLleno()) {
			buzon.saleMensaje();
			cont++;
			System.out.println("Mensaje: "+buzon.getMensaje());
			
			
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
