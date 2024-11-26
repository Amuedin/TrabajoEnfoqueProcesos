package concesionario;

import java.util.concurrent.Semaphore;
/**
 * Esta clase provee de los hilos que simularán el acceso de los clientes a 
 * los vehículos del concesionario
 */
public class PruebaVehiculo extends Thread {
	
	private Vehiculos Vehprueba;
	private Semaphore semaforo;
	
	//private int clientes;
	/**
	 * EL constructor recibe el nombre del hilo y el recurso vehiculo
	 * por parámetro
	 * @param nombre
	 * @param v
	 */
	public PruebaVehiculo(String nombre, Semaphore semaforo, Vehiculos v) {
		this.setName(nombre);
		this.Vehprueba = v;
		this.semaforo = semaforo;
	}
	
	/**
	 * Contiene la sección crítica
	 */
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " está esperando para probar un vehiculo");
			this.semaforo.acquire(); //da permiso al hilo para acceder a la sección crítica
			
			
			Vehprueba.probarVehiculo();
			
			
			Thread.sleep((int)(Math.random() * 10000)); 
			
			
			Vehprueba.devolverVehiculo();
			
			this.semaforo.release();//libera un espacio para un nuevo hilo en la sección crítica
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
