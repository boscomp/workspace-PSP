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
//		else {
//			while (plazasOcupadas + cochesQueQuierenEntrar > MAX_PLAZAS) {
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (plazasOcupadas + cochesQueQuierenEntrar <= MAX_PLAZAS) {
//				plazasOcupadas += cochesQueQuierenEntrar;
//				imprimirMensajeEntrada(puerta, cochesQueQuierenEntrar);
//				notify();
//			}
//		}
	}

	public void salir(String puerta, Integer cochesQuePuedenSalir) {
		if (cochesQuePuedenSalir == 0) {
			return;
		}
		else {
			usarPuerta(puerta, -cochesQuePuedenSalir);
			imprimirMensajeSalida(puerta, cochesQuePuedenSalir);
		}
//		while (plazasOcupadas - cochesQuePuedenSalir < 0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (plazasOcupadas - cochesQuePuedenSalir >= 0) {
//			plazasOcupadas -= cochesQuePuedenSalir;
//			imprimirMensajeSalida(puerta, cochesQuePuedenSalir);
//			notify();
//		}
//
//	}

//	public synchronized void mover(String puerta, Integer cochesQueSeMueven) {
//		if (cochesQueSeMueven == 0) {
//			return;
//		}
//		if (plazasOcupadas+cochesQueSeMueven>MAX_PLAZAS) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (plazasOcupadas+cochesQueSeMueven<0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (plazasOcupadas<MAX_PLAZAS) {
//			notify();
//		}
//		
//		plazasOcupadas -= cochesQueSeMueven;
//		imprimirMensajeSalida(puerta, cochesQueSeMueven);
//	}
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
