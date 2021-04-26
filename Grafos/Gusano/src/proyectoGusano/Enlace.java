package proyectoGusano;

public class Enlace {
	public int distancia;
	public int origen;
	public int destino;
	
	public Enlace(int origin, int destination, int weight){
		this.origen=origin;
		this.destino=destination;
		this.distancia=weight;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}
	
	

}
