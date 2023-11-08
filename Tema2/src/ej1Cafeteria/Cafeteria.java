package ej1Cafeteria;

public class Cafeteria {
	
	private static final Integer AFORO_MAXIMO = 50;
	
	private Integer aforoActual;
	
	public Cafeteria() {
		aforoActual = 0;
	}
	
	public synchronized boolean haySitioYEntra() {
		if(aforoActual < AFORO_MAXIMO) {
			aforoActual++;
			System.out.println("Entra persona. Aforo actual = " + aforoActual);
			return true;
		}
		return false;
	}
	
	public  void salePersona() {
		aforoActual--;
		System.out.println("Sale persona. Aforo actual = " + aforoActual);
	}
	
	
}

