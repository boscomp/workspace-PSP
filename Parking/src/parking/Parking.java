package parking;

public class Parking {

	private static final Integer MAX_PLAZAS = 40;
	private Integer plazasOcupadas;

	public Parking() {
		plazasOcupadas = 0;
	}

	public synchronized void entrar(String puerta, Integer cochesQueQuierenEntrar) {
		if (cochesQueQuierenEntrar == 0) {
			return;
		}
		if (plazasOcupadas+cochesQueQuierenEntrar>MAX_PLAZAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		plazasOcupadas += cochesQueQuierenEntrar;
		imprimirMensajeEntrada(puerta, cochesQueQuierenEntrar);
	}

	public void salir(String puerta, Integer cochesQuePuedenSalir) {
		if (cochesQuePuedenSalir == 0) {
			return;
		}
		else {
			mover(puerta, -cochesQuePuedenSalir);
		}
		plazasOcupadas -= cochesQuePuedenSalir;
		imprimirMensajeSalida(puerta, cochesQuePuedenSalir);
	}

	public synchronized void mover(String puerta, Integer cochesQueSeMueven) {
		if (cochesQueSeMueven == 0) {
			return;
		}
		if (plazasOcupadas+cochesQueSeMueven>MAX_PLAZAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (plazasOcupadas+cochesQueSeMueven<0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (plazasOcupadas<MAX_PLAZAS) {
			notify();
		}
		
		plazasOcupadas -= cochesQueSeMueven;
		imprimirMensajeSalida(puerta, cochesQueSeMueven);
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
