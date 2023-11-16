package impresora;



public class Lanzador {

	public static void main(String[] args) {
		Impresora impresora = new Impresora(); // �nica y compartida

		
		Usuario escritor1 = new Usuario("Blas", impresora);
		Thread hiloBlas = new Thread (escritor1);
		hiloBlas.start();
		Usuario escritor2 = new Usuario("Laura", impresora);
		Thread hiloLaura = new Thread (escritor2);
		hiloLaura.start();
		Usuario escritor3 = new Usuario("Epi", impresora);
		Thread hiloEpi = new Thread (escritor3);
		hiloEpi.start();


	}
}