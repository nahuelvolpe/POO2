package proyectoCalle;

public class Camino {
	int inicio;
	int fin;
	
	public Camino(int begin, int end){
		this.inicio=begin;
		this.fin=end;
	}

	@Override
	public String toString() {
		return "Camino [inicio=" + inicio + ", fin=" + fin + "]";
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	

	
	
}
