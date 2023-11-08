package buzon;

public class Buzon {
	private static final Integer CAPACIDAD_MAXIMA = 1;
	private Integer capacidad;
	private String mensaje;
	
	public Buzon() {
		capacidad= 0;
	}
	public synchronized boolean estaLleno() {
		if (capacidad < CAPACIDAD_MAXIMA)  {
			System.out.println("El buzón está vacío");
			return false;
		}
		return true;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public void entraMensaje() {
		capacidad++;
		
		System.out.println("El emisor mete un mensaje");
	}
	public void saleMensaje() {
		capacidad--;
		System.out.println("El lector saca un mensaje");
	}
}
