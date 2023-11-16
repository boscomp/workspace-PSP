package parking;

public class PuertaSalida extends Puerta  {

	public PuertaSalida(Parking parking, String nombre) {
		super(parking, nombre);
	}
	
	public void trabajar() {
		while(true) {
			System.out.println("hola");
			Integer cochesQuePermitimosSalir = calcularNumCochesPermitidos();
			System.out.println("1");
			parking.salir(nombre, cochesQuePermitimosSalir);
			System.out.println("2");
			esperarProximaApertura();
		}
	}

	@Override
	public void run() {
		trabajar();
		
	}

	
	
}