package proyectoPelicula;

public class Segmento {
	public int principio;
	public int termino;
	public int posicion;
	
	public Segmento(int position, int begin, int end){
		this.posicion=position;
		this.principio=begin;
		this.termino=end;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getPrincipio() {
		return principio;
	}

	public void setPrincipio(int principio) {
		this.principio = principio;
	}

	public int getTermino() {
		return termino;
	}

	public void setTermino(int termino) {
		this.termino = termino;
	}

	@Override
	public String toString() {
		return "Segmento [principio=" + principio + ", termino=" + termino + ", posicion=" + posicion + "]";
	}
	
	

}
