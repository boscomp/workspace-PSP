package parking;

public class Parking {

	private static final Integer MAX_PLAZAS = 40;
	private Integer plazasOcupadas;

	public Parking() {
		plazasOcupadas = 0;
	}
//metodo syncro mover que llame a entrar y salir
	
	public synchronized void usarPuerta(String puerta, Integer cochesQueUsan) {
		if ((plazasOcupadas + cochesQueUsan)> MAX_PLAZAS || (plazasOcupadas + cochesQueUsan)<0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!((plazasOcupadas + cochesQueUsan)> MAX_PLAZAS) && !((plazasOcupadas + cochesQueUsan)<0)) {
		plazasOcupadas += cochesQueUsan;
		notify();
		}
		
	}
	
	public void entrar(String puerta, Integer cochesQueQuierenEntrar) {
		if (cochesQueQuierenEntrar == 0) {
			return;
		} 
		else {
			usarPuerta(puerta, cochesQueQuierenEntrar);
			imprimirMensajeEntrada(puerta, cochesQueQuierenEntrar);
			
		}
	}
	public void salir(String puerta, Integer cochesQuePuedenSalir) {
		if (cochesQuePuedenSalir == 0) {
			return;
		}
		else {
			usarPuerta(puerta, -cochesQuePuedenSalir);
			imprimirMensajeSalida(puerta, cochesQuePuedenSalir);
		}
	}

	// No hay que modificar nada de este m�todo
	private void imprimirMensajeSalida(String puerta, Integer cochesQuePuedenSalir) {
		System.out.println("<<< " + puerta + " <<< Han salido " + cochesQuePuedenSalir + " // OCUPACI�N: "
				+ plazasOcupadas + getMsgAlerta());
	}

	// No hay que modificar nada de este m�todo
	private void imprimirMensajeEntrada(String puerta, Integer cochesQueQuierenEntrar) {
		System.out.println(">>> " + puerta + " >>> Han entrado " + cochesQueQuierenEntrar + " // OCUPACI�N: "
				+ plazasOcupadas + getMsgAlerta());
	}

	// No hay que modificar nada de este m�todo
	private String getMsgAlerta() {
		String alerta = "";
		if (plazasOcupadas < 0 || plazasOcupadas > MAX_PLAZAS) {
			alerta = " !!!";
		}
		return alerta;
	}

}
