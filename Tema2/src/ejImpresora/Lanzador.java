package ejImpresora;



public class Lanzador {

	public static void main(String[] args) {
		Impresora impresora = new Impresora(); // �nica y compartida

		
		Usuario escritor1 = new Usuario("Blas", impresora);
		escritor1.escribir();

	}
}
