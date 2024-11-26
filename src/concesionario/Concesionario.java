package concesionario;

import java.util.concurrent.Semaphore;
/**
 * Proceso principal
 */
public class Concesionario {

	public static void main(String[] args) {
		
		Vehiculos vehiculoPr = new Vehiculos();
		
		Semaphore disponibilidad = new Semaphore(4);
		
		//Arrancamos los hilos 
		for(int i = 0; i < 9;i++) {
			PruebaVehiculo pv = new PruebaVehiculo("Cliente " + i,disponibilidad, vehiculoPr);
			pv.start();
			
		}

	}

}
