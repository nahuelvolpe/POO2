package proyectoRedesElectricas;

public class Ciudad {

	int posicion;
	String nombre;
	
	public Ciudad(int position, String name){
		this.posicion=position;
		this.nombre=name;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ciudad [posicion=" + posicion + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
