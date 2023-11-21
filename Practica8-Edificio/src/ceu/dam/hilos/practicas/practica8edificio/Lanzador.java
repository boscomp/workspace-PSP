package ceu.dam.hilos.practicas.practica8edificio;

import java.util.Random;

public class Lanzador {

	private static final int ALTURA_EDIFICIO = 1000;

	public static void main(String[] args) {
		System.out.println("Simulando construcci�n de edificio...");
		System.out.println("Se lanzar�n los siguientes hilos concurrentes:");
		System.out.println("\t 100 hilos de trabajadores NO cualificados. Construyen un aleatorio entre 0 y 5 metros (ambos inclusive) por cada 100ms");
		System.out.println("\t 100 hilos de trabajadores cualificados. Construyen un aleatorio entre 5 y 10 metros (ambos inclusive) por cada 200ms");
		
		Edificio edificio = new Edificio(ALTURA_EDIFICIO);
	
		// Implementar y lanzar los hilos....
		 long startTime = System.currentTimeMillis();
		 
			for (int i=1; i<=300; i++) {

				TrabajadorCualificado trabajadorC= new TrabajadorCualificado(edificio);

				Thread hiloC = new Thread(trabajadorC);

				hiloC.start();
				try {

					hiloC.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			
			}
		for (int i=1; i<=50; i++) {

			TrabajadorNoCualificado trabajadorNoC= new TrabajadorNoCualificado(edificio);
		
			Thread hiloNoC = new Thread(trabajadorNoC);

			hiloNoC.start();

			try {
				hiloNoC.join();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		
		}
	
		
		long finishTime = System.currentTimeMillis();
		long totalTime = finishTime- startTime;

		System.out.println("Tiempo: "+(totalTime/1000)+" segundos");
		
		
	}
}
