package concesionario;

import java.util.concurrent.Semaphore;

public class DevuelveVehiculo extends Thread{
	private Vehiculos Vprueba;
	private Semaphore semaforo;
	//private int clientes;
	/**
	 * EL constructor recibe el nombre del cliente y el recurso vehiculo
	 * @param nombre
	 * @param v
	 */
	public DevuelveVehiculo(String nombre,Semaphore semaforo, Vehiculos v) {
		this.setName(nombre); //atributo heredado de la clase Thread, el nombre del hilo
		this.Vprueba = v;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " devuelve el vehiculo");
		this.semaforo.release();
		Vprueba.devolverVehiculo();
	}
}
