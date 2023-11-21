package parking;

public class PuertaSalida extends Puerta  {

	public PuertaSalida(Parking parking, String nombre) {
		super(parking, nombre);
	}
	
	public void trabajar() {
		while(true) {

			Integer cochesQuePermitimosSalir = calcularNumCochesPermitidos();

			parking.salir(nombre, cochesQuePermitimosSalir);

			esperarProximaApertura();
		}
	}

	@Override
	public void run() {
		trabajar();
		
	}

	
	
}