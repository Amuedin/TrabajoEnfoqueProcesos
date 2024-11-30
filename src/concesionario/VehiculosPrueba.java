package concesionario;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Clase monitor, que contendrá el recurso crítico, en este caso las intancias de la clase Vehiculo, contenidos en
 * el ArrayList parqueV, y los métodos necesarios que usaremos para manipular dicho recurso.
 */
public class VehiculosPrueba {
	//Creamos una colección de tipo TreeMap para que guarde la asoción: cliente-vehículo, y que de este modo
	//devuelvan el mismo vehiculo que retiraron.
	private TreeMap<String, Vehiculo> clienteauto;
	private ArrayList<Vehiculo> parqueVeh = new ArrayList<>();
	
	/**
	 * 
	 */
	public VehiculosPrueba() {
		
		clienteauto = new TreeMap<>();
		//Añadimos al ArrayList los cuatro vehículos que estarán disponibles.
		for(int i = 0; i <4 ; i++) {
			Vehiculo vehPrueba = new Vehiculo("" +(i+1));
			parqueVeh.add(i, vehPrueba);	
		}
	}
	
	/**
	 * Método al que llamaremos cuando el cliente va a sacar un vehículo del concesionario,
	 * modificando la cantidad disponible de estos
	 */
	public  void probarVehiculo() {	
	
		//asociamos el hilo en ejecución(cliente) con el coche que eliminamos del Array
		clienteauto.put(Thread.currentThread().getName(), parqueVeh.removeFirst());
		
		System.out.println(Thread.currentThread().getName() + " probando vehiculo " 
		+ clienteauto.get(Thread.currentThread().getName()).getName());
	}
	 /**
	  * Método al que llamaremos cuando el cliente(hilo en ejecución) vaya a devolver 
	  * un vehículo al concesionario
	  */
	public  void devolverVehiculo() {
		
		System.out.println(Thread.currentThread().getName() + " terminó de probar el vehículo " 
		+ clienteauto.get(Thread.currentThread().getName()).getName());
		
		//Devolvemos al array el vehiculo asociado al hilo actual
		parqueVeh.addFirst(clienteauto.get(Thread.currentThread().getName()));
		
	}
}
