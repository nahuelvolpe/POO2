package proyectoVagones;

public class Vagon {
	double nivelAgresividad;
	int cantAnimales;
	
	//CONSTRUCTOR
	public Vagon(double nivelAgresividad, int cantAnimales){
		this.nivelAgresividad = nivelAgresividad;
		this.cantAnimales = cantAnimales;
	}

	//GETTERS
	public double getAgresividad(){
		return this.nivelAgresividad;
	}
	public int getCantidadAnimales(){
		return this.cantAnimales;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Vagon [getAgresividadVagon()=" + getAgresividad() + ", getCantidadAnimales()="
				+ getCantidadAnimales() + "]";
	}

}
