package ej3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanzadorProcesosEj3 {

	public static void main(String[] args) {
//		try {
//		File directorioBin = new File ("bin");
//		if (!directorioBin.exists()||!directorioBin.isDirectory() ) {
//			System.err.println("El directorio 'bin' no existe");
//			return;
//		}
//		
//		String programaJava="Eclipse IDE for Java Developers - 2023-06";
//		String rutaProgramaJava = "C:\\Users\\jmolina1094\\Desktop\\GIT\\PSP-23-24\\workspace-PSP\\Tema1\\bin\\ej2";
//		String comando ="java -cp "+directorioBin.getAbsolutePath()+" "+rutaProgramaJava;
//	
//			Process proceso =Runtime.getRuntime().exec(comando);
//			InputStream inputStream = proceso.getInputStream();
//			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//
//			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//			
//			int caracter;
//
//			while ((caracter = bufferedReader.read()) != -1) {
//
//				System.out.print((char) caracter);
//
//			}
//
//			bufferedReader.close();
//
//			inputStreamReader.close();
//
//			inputStream.close();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		} 
//		try {
//			File directorioBin = new File ("C:\\\\Users\\\\jmolina1094\\\\Desktop\\\\GIT\\\\PSP-23-24\\\\workspace-PSP\\\\Tema1\\\\bin\\\\ej2");
//			Process proceso = Runtime.getRuntime().exec("C:\\Users\\jmolina1094\\Desktop\\GIT\\PSP-23-24\\workspace-PSP\\Tema1\\bin\\ej2");
//
//			InputStream inputStream = proceso.getInputStream();
//
//			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//
//			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//			int caracter;
//
//			while ((caracter = bufferedReader.read()) != -1) {
//
//				System.out.print((char) caracter);
//
//			}
//
//			bufferedReader.close();
//
//			inputStreamReader.close();
//
//			inputStream.close();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		}
		try {
			Process p = new ProcessBuilder("cmd","/c","start","dir").start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
