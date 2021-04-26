package proyectoVagones;

public class Especie {
	String nombre;
	int agresividad;
	int cantidad;
	
	//CONSTRUCTOR
	 public Especie(String nom, int agre, int cant){
		 this.nombre=nom;
		 this.agresividad=agre;
		 this.cantidad=cant;
		 }

	 //GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAgresividad() {
		return agresividad;
	}
	public void setAgresividad(int agresividad) {
		this.agresividad = agresividad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	} 
}
