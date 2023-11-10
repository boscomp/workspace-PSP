package buzon;

import java.util.Random;

public class Emisor implements Runnable{
	private Buzon buzon;

	public Emisor(Buzon buzon) {
		this.buzon=buzon;
	}
	
	
	
	public void mandarMensaje () {
		Random random = new Random();
	
		while (true) {
		if (!buzon.estaLleno()) {
			buzon.entraMensaje();
	
			buzon.setMensaje("Hola");
		}
		else {
			try {
				System.out.println("El aforo está completo");
				Thread.sleep(random.nextInt(3000)+1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	}
	@Override
	public void run() {
		mandarMensaje();
		
	}

}
