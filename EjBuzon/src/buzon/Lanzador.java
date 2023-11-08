package buzon;

public class Lanzador {
public static void main(String[] args) {
	Buzon buzon = new Buzon (); //recurso compartido
	
	Emisor emi = new Emisor (buzon); 
	Thread hiloEmi = new Thread(emi);
	hiloEmi.start();
	
	for (int i = 0; i < 4; i++) {
	Receptor rec = new Receptor (buzon);
	Thread hiloRec = new Thread (rec);
	hiloRec.start();
	}
	// join porque no es infinito 1 por hilo
	
	
	
		
	
}
}
