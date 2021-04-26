package proyectoGrafo;


public class Arista{
	int origen;
	int destino;
	int peso;
	
	public Arista(int origin, int destination, int weight){
		origen=origin;
		destino=destination;
		peso=weight;
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	

	/*@Override
	public int compare(Arista a1, Arista a2) {
		return a1.getPeso() - a2.getPeso();
	}*/
}
