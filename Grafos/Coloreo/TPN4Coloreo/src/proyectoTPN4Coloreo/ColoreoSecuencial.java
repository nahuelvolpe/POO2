package proyectoTPN4Coloreo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



public class ColoreoSecuencial {
	
	public int[][] grafo;
	int tamaño;
	ArrayList<Vecino> vertices = new ArrayList<Vecino>();
	Map<Integer, Integer> indice_nodo_color = new HashMap<Integer, Integer>();
	public ColoreoSecuencial(int[][] matrizAdyacencia){
		this.grafo=matrizAdyacencia;
		this.tamaño=grafo.length;
	}

	public void coloreo(){
		int[] colores = new int[tamaño];
		colores[0]=1;
		
		
		for(int i=0; i<tamaño; i++){
			ArrayList<Integer> neighbours = new ArrayList<Integer>();
			for(int j=0; j<tamaño; j++){
				if(grafo[i][j]==1){
					neighbours.add(j);
				}
			}
			vertices.add(new Vecino(i, new ArrayList<Integer>(neighbours)));
		}
		
		/*/
		//MATULA
		Collections.sort(vertices, new Comparator<Vecino>() {
			@Override
			public int compare(Vecino v1, Vecino v2) {
				return new Integer(v1.getVecinos().size()).compareTo(new Integer(v2.getVecinos().size()));
			}
		});
		
		//WELLSH-POWELL
		Collections.sort(vertices, new Comparator<Vecino>() {
			@Override
			public int compare(Vecino v1, Vecino v2) {
				return new Integer(v2.getVecinos().size()).compareTo(new Integer(v1.getVecinos().size()));
			}
		});
		*/
		
		for(int i=0; i<tamaño; i++){
			if((indice_nodo_color.containsKey(vertices.get(i).getNodo()))){
				continue;
			}else{
				indice_nodo_color.put(vertices.get(i).getNodo(), i);
				for(int j=i+1; j<vertices.size(); j++){
					if(!(vertices.get(i).getVecinos().contains(vertices.get(j).getNodo())) && !(indice_nodo_color.containsKey(vertices.get(j).getNodo())) && !verificarAdyacencia(j,i)){
						indice_nodo_color.put(vertices.get(j).getNodo(), i);
					}else{
						continue;
					}
				}
			}
			
		}
		for (Entry<Integer, Integer> entry : indice_nodo_color.entrySet()) {
		    System.out.println("nodo=" + entry.getKey() + ", color=" + entry.getValue());
		} 
		
	}
	
	public boolean verificarAdyacencia(int nodo, int color){
		boolean condicion=false;
		
		/*for(int i=0; i<vertices.get(nodo).getVecinos().size(); i++){
			System.out.println(indice_nodo_color.get(vertices.get(nodo).getVecinos().get(i)));
			if(indice_nodo_color.get(vertices.get(nodo).getVecinos().get(i))==color){
				condicion=true;
			}
		}*/
		
		for (Entry<Integer, Integer> entry : indice_nodo_color.entrySet()) {
			if(vertices.get(nodo).getVecinos().contains(entry.getKey())){
				if(entry.getValue()==color){
					condicion=true;
				}
			}
		} 
	return condicion;
	}
}
