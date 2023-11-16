package ejImpresora;



public class Lanzador {

	public static void main(String[] args) {
		Impresora impresora = new Impresora(); // �nica y compartida

		
		Usuario blas = new Usuario("Blas", impresora);
		Thread hiloBlas = new Thread (blas);
		hiloBlas.start();		
		Usuario laura = new Usuario("Laura", impresora);
		Thread hiloLaura = new Thread (laura);
		hiloLaura.start();		
		Usuario epi = new Usuario("Epi", impresora);
		Thread hiloEpi = new Thread (epi);
		hiloEpi.start();
		
		try {
			hiloBlas.join();
			hiloLaura.join();
			hiloEpi.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
