package concesionario;


import java.util.concurrent.Semaphore;
/**
 * Proceso principal
 */
public class Concesionario {

	public static void main(String[] args) {
		
		//Creamos las instancias que necesitaremos pasar por parámetro a los hilos
		VehiculosPrueba vehiculoPr = new VehiculosPrueba();
		
		Semaphore vehDisponibles = new Semaphore(4);
			
		//Arrancamos los hilos 
		for(int i = 0; i < 9;i++) {
			ClientePrueba pv = new ClientePrueba("Cliente " + i, vehDisponibles, vehiculoPr);
			
			pv.start();
			
		}

	}

}
