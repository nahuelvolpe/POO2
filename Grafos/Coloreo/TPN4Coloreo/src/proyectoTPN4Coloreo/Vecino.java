package proyectoTPN4Coloreo;

import java.util.ArrayList;

public class Vecino {

	int nodo;
	ArrayList<Integer> vecinos = new ArrayList<Integer>();
	
	public Vecino(int edge, ArrayList<Integer> neighbors){
		this.nodo=edge;
		this.vecinos=neighbors;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public ArrayList<Integer> getVecinos() {
		return vecinos;
	}

	public void setVecinos(ArrayList<Integer> vecinos) {
		this.vecinos = vecinos;
	}

}
