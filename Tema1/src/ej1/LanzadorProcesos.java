package ej1;

import java.io.IOException;

public class LanzadorProcesos {
	public void ejecuar(String ruta) {
		
		ProcessBuilder pb = new ProcessBuilder(ruta);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
		String ruta="\"C:\\Program Files\\Notepad++\\notepad++.exe\"";
		LanzadorProcesos lp = new LanzadorProcesos();
		lp.ejecuar(ruta);
	}
}
