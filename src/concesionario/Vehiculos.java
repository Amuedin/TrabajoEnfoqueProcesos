package concesionario;
/**
 * Clase monitor, que contendrá el recurso crítico, en este caso la cantidad de vehículos,
 * y los métodos necesarios que usaremos para manipular dicho recurso.
 */
public class Vehiculos {
	private int vDisponible;
	
	/**
	 * 
	 */
	public Vehiculos() {
		this.vDisponible = 4;
	}
	
	/**
	 * Método al que llamaremos cuando vayamos a sacar un vehículo del concesionario,
	 * modificando la cantidad disponible de estos
	 */
	//public synchronized void probarVehiculo() { ¿ES REDUNDANTE USAR SYNCHRONYZED AQUI CUANDO EL ACCESO 
	//ESTA CONTROLADO POR EL SEMAFORO?
	public synchronized void probarVehiculo() {	
		this.vDisponible --;
		System.out.println(Thread.currentThread().getName() + " se monta en el vehiculo\n" + 
		"Vehiculos disponibles: " + this.vDisponible);
	}
	 /**
	  * Método al que llamaremos cuando se vaya a devolver un vehículo al concesionario
	  */
	public synchronized void devolverVehiculo() {
		
		vDisponible ++;
		System.out.println(Thread.currentThread().getName() + " devuelve el vehiculo\n"+
		"Vehiculos disponibles: " + this.vDisponible);
	}
	//metodo synchronyzed que tome una metodo u otro de los de arriba segun
	//el hilo devuelva o entregue un coche.Un boolean por parametro?
}
