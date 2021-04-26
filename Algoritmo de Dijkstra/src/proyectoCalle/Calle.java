package proyectoCalle;

public class Calle {
	int origen;
	int destino;
	int posicion;
	
	public Calle(int origin, int destination, int pos){
		this.origen=origin;
		this.destino=destination;
		this.posicion=pos;
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

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
	

}
