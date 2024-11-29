package concesionario;
/**
 * Clase que será el recurso crítico
 */
public class Vehiculo {
	private String name;
	
	public Vehiculo(String nombre) {
		this.name = nombre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
