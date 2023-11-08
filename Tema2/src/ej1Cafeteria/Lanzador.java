package ej1Cafeteria;

public class Lanzador {

	public static void main(String[] args) {
		Cafeteria cafeteria = new Cafeteria();
		
		for (int i = 0; i < 100; i++) {
			Alumno alumno = new Alumno(cafeteria);
			Thread hiloAlumno = new Thread(alumno);
			hiloAlumno.start();
		}
		
		for (int i = 0; i < 20; i++) {
			Profesor profesor = new Profesor(cafeteria);
			Thread hiloProfesor = new Thread(profesor);
			hiloProfesor.start();
		}
		
		
		
	}

}
