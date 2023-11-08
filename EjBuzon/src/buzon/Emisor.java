package buzon;

import java.util.Random;

public class Emisor implements Runnable{
	private Buzon buzon;

	public Emisor(Buzon buzon) {
		this.buzon=buzon;
	}
	
	
	
	public void mandarMensaje () {
		Random random = new Random();
		int cont=0;
		while (cont<1) {
		if (!buzon.estaLleno()) {
			buzon.entraMensaje();
			cont++;
			buzon.setMensaje("Hola");
		}
		else {
			try {
				System.out.println("El aforo está completo");
				Thread.sleep(random.nextInt(3)+1);
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
