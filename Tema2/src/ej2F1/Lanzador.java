package ej2F1;



public class Lanzador {
public static void main(String[] args) {
	Carrera eeuu = new Carrera(3005);
	Coche alo14 = new Coche("ALONSO", 100, eeuu);
	Coche ham44 = new Coche("HAMILTON", 101, eeuu);
	Coche sai55 = new Coche("SAINZ", 99, eeuu);
	
	Thread hiloAlonso = new Thread(alo14);
	hiloAlonso.start();
	Thread hiloHamilton = new Thread(ham44);
	hiloHamilton.start();
	Thread hiloSainz = new Thread(sai55);
	hiloSainz.start();
	
	try {
		hiloAlonso.join();
		hiloHamilton.join();
		hiloSainz.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
