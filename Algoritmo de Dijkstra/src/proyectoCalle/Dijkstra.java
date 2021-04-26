package proyectoCalle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;



public class Dijkstra {
	
	int[][] grafo;
	int[] nodos;
	int distancia=0;
	List<Nodo>  listos=null;
	ArrayList<Camino> caminos = new ArrayList<Camino>();
	
	public Dijkstra(int[][] matrizAdyacencia, int[] vertices){
		this.grafo=matrizAdyacencia;
		this.nodos=vertices;
	}
	
	// retorna la posici�n en el arreglo de un nodo espec�fico
    private int posicionNodo(int nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo) return i;
        }
        return -1;
    }
     
    // encuentra la ruta m�s corta desde un nodo origen a un nodo destino
    public ArrayList<Camino> encontrarRutaMinimaDijkstra(int inicio, int fin) {
        // calcula la ruta m�s corta del inicio a los dem�s
        encontrarRutaMinimaDijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if(!listos.contains(tmp)) {
            System.out.println("Error, nodo no alcanzable");
            return new ArrayList<Camino>();
        }
        tmp = listos.get(listos.indexOf(tmp));
        distancia = tmp.distancia;  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Nodo> pila = new Stack<Nodo>();
        while(tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        for(int i=0; i<caminos.size(); i++){
        	System.out.println(caminos.get(i));
        }
        
        int primero,segundo;
        primero=pila.pop().id;
        segundo=pila.pop().id;
        caminos.add(new Camino(primero,segundo));
        while(!pila.isEmpty()) {
        	primero=segundo;
        	segundo=pila.pop().id;
        	caminos.add(new Camino(primero,segundo));
        }
        return caminos;
    }
 
    // encuentra la ruta m�s corta desde el nodo inicial a todos los dem�s
    public void encontrarRutaMinimaDijkstra(int inicio) {
        Queue<Nodo>   cola = new PriorityQueue<Nodo>(); // cola de prioridad
        Nodo            ni = new Nodo(inicio);          // nodo inicial
         
        listos = new LinkedList<Nodo>();// lista de nodos ya revisados
        cola.add(ni);                   // Agregar nodo inicial a la cola de prioridad
        while(!cola.isEmpty()) {        // mientras que la cola no esta vacia
            Nodo tmp = cola.poll();     // saca el primer elemento
            listos.add(tmp);            // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);   
            for(int j=0; j<grafo[p].length; j++) {  // revisa los nodos hijos del nodo tmp
                if(grafo[p][j]==0) continue;        // si no hay conexi�n no lo evalua
                if(estaTerminado(j)) continue;      // si ya fue agregado a la lista de terminados
                Nodo nod = new Nodo(nodos[j],tmp.distancia+grafo[p][j],tmp);
                // si no est� en la cola de prioridad, lo agrega
                if(!cola.contains(nod)) {
                	cola.add(nod);
                    continue;
                }
                // si ya est� en la cola de prioridad actualiza la distancia menor
                for(Nodo x: cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if(x.id==nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
              
            }
        }
    }
 
    // verifica si un nodo ya est� en lista de terminados
    public boolean estaTerminado(int j) {
        Nodo tmp = new Nodo(nodos[j]);
        return listos.contains(tmp);
    }

	public ArrayList<Camino> getCaminos() {
		return caminos;
	}

	public int getDistancia() {
		return distancia;
	}
	
	
 
    

}
