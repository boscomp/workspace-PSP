package parking;



public class Lanzador {
	public static void main(String[] args) {
		Parking parking = new Parking();
		PuertaSalida salida = new PuertaSalida(parking, "Salida 1");
		Thread hiloSal = new Thread(salida);
		PuertaEntrada entrada = new PuertaEntrada(parking, "Entrada 1");
		Thread hiloEnt = new Thread(entrada);
		PuertaSalida salida2 = new PuertaSalida(parking, "Salida 2");
		Thread hiloSal2 = new Thread(salida2);
		PuertaEntrada entrada2 = new PuertaEntrada(parking, "Entrada 2");
		Thread hiloEnt2 = new Thread(entrada2);
		hiloSal.start();
		hiloEnt.start();
		hiloSal2.start();
		hiloEnt2.start();
	}
}
