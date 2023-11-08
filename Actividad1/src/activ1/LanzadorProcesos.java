package activ1;

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
}
