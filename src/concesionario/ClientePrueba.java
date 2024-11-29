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
			
			this.semaforo.acquire(); //da permiso al hilo para acceder a la sección crítica, según el límite que hayamos definido
			
			
			Vehprueba.probarVehiculo();
			
			
			Thread.sleep((int)(Math.random() * 10000)); 
			
			
			Vehprueba.devolverVehiculo();
			
			
			this.semaforo.release();	//libera un permiso para un nuevo hilo en la sección crítica
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
