package parking;

public class PuertaEntrada extends Puerta {

	public PuertaEntrada(Parking parking, String nombre) {
		super(parking, nombre);
	}
	
	public void trabajar() {
		while(true) {
			Integer cochesQuePermitimosEntrar = calcularNumCochesPermitidos();
			parking.entrar(nombre, cochesQuePermitimosEntrar);
			esperarProximaApertura();
		}
	}

	@Override
	public void run() {
		trabajar();
		
	}

	
}
