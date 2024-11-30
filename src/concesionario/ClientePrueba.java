package concesionario;

import java.util.concurrent.Semaphore;
/**
 * Esta clase provee de los hilos que simularán el acceso de los clientes a 
 * los vehículos del concesionario
 */
public class ClientePrueba extends Thread {
	
	private VehiculosPrueba Vehprueba;
	private Semaphore semaforo;
	
	
	/**
	 * 
	 * @param nombre
	 * @param v
	 */
	public ClientePrueba(String nombre, Semaphore semaforo, VehiculosPrueba v) {
		this.setName(nombre);
		this.Vehprueba = v;
		this.semaforo = semaforo;
	}
	
	/**
	 * Contiene la sección crítica, el semáforo gestionará si el bloque de código está disponible o no
	 */
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " está esperando para probar un vehiculo");
			//da permiso al hilo para acceder a la sección crítica, según el límite que hayamos definido
			this.semaforo.acquire(); 
			
			Vehprueba.probarVehiculo();
			
			Thread.sleep((int)(Math.random() * 10000)); 
			
			Vehprueba.devolverVehiculo();
			//libera un permiso para que un nuevo hilo acceda a la sección crítica
			this.semaforo.release();	
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
