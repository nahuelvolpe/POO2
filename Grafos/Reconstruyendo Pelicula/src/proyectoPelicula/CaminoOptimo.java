package proyectoPelicula;

public class CaminoOptimo {
	int distancia;
	String ruta;
	int cantidadNodos;
	
	public CaminoOptimo(int weight, int edges, String camino){
		this.distancia=weight;
		this.ruta=camino;
		this.cantidadNodos=edges;
	}
	

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}


	public void setCantidadNodos(int cantidadNodos) {
		this.cantidadNodos = cantidadNodos;
	}
	
	
}
