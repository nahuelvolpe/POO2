package proyectoGrafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Kruskal {
	
	public Arista[] arbol;
	public int cantAristas;
	public int cantNodos;
	public int[] padre;  //Este arreglo contiene el padre del i-esimo nodo
	ArrayList<Arista> aristasList = new ArrayList<Arista>();
	
	public Kruskal(ArrayList<Arista> aristas,int[] nodos, int cantEdges, int cantVertices){
		cantAristas=cantEdges;
		cantNodos=cantVertices;
		this.arbol= new Arista[cantAristas];
		this.padre = new int[cantNodos];
		this.padre=nodos;
		this.aristasList=aristas;
	}
	
	public void resolver(){
		 int origen , destino , peso;
		 int total = 0;          //Peso total del Arbol
		 int numAristas = 0;     //Numero de Aristas del Arbol
		  
		 //Arrays.sort(arista, 0, this.getCantAristas(), new Arista());
		 Collections.sort(aristasList, new Comparator<Arista>() {
				@Override
				public int compare(Arista a1, Arista a2) {
					return new Integer(a1.getPeso()).compareTo(new Integer(a2.getPeso()));
				}
			});
		    
		 for( int i = 0 ; i < this.getCantAristas() ; ++i ){   //Recorremos las aristas ya ordenadas por peso
			    origen = aristasList.get(i).getOrigen();    //Vértice origen de la arista actual
		        destino = aristasList.get(i).getDestino();  //Vértice destino de la arista actual
		        peso = aristasList.get(i).getPeso();        //Peso de la arista actual

		        //Verificamos si estan o no en la misma componente conexa
		        if( !sameComponent( origen , destino ) ){  //Evito ciclos
		            total += peso;              //Incremento el peso total del MST
		            arbol[ numAristas++ ] = aristasList.get(i);  //Agrego al MST la arista actual
		            Union( origen , destino );  //Union de ambas componentes en una sola
		        }
		    }

		    //Si el MST encontrado no posee todos los vértices mostramos mensaje de error
		    //Para saber si contiene o no todos los vértices basta con que el numero
		    //de aristas sea igual al numero de vertices - 1
		    if( this.getCantNodos() - 1 != numAristas ){
		        System.out.println("No existe Arbol valido para el grafo ingresado, el grafo debe ser conexo.");
		        return;
		    }
		    System.out.println( "-----El Arbol encontrado contiene las siguientes aristas-----");
		    for( int i = 0 ; i < numAristas ; ++i )
		        System.out.printf("( %d , %d ) : %d\n" , arbol[ i ].origen ,arbol[ i ].destino , arbol[ i ].peso ); //( vertice u , vertice v ) : peso

		    System.out.printf( "El costo minimo de todas las aristas del Arbol es : %d\n" , total );
	}
	
	///UNION-FIND

		//Método de inicialización
		public void MakeSet( int n ){
		    for( int i = 0 ; i < n ; ++i ) padre[ i ] = i;
		}

		//Método para encontrar la raiz del vértice actual X
		public int Find( int x ){
		    return ( x == padre[ x ] ) ? x : ( padre[ x ] = Find( padre[ x ] ) );
		}

		//Método para unir 2 componentes conexas
		public void Union( int x , int y ){
		    padre[ Find( x ) ] = Find( y );
		}

		//Método que me determina si 2 vértices estan o no en la misma componente conexa
		public boolean sameComponent( int x , int y ){
		    if( Find( x ) == Find( y ) ) return true;
		    return false;
		}
		///FIN UNION-FIND

		public int getCantAristas() {
			return cantAristas;
		}

		public void setCantAristas(int cantAristas) {
			this.cantAristas = cantAristas;
		}

		public int getCantNodos() {
			return cantNodos;
		}

		public void setCantNodos(int cantNodos) {
			this.cantNodos = cantNodos;
		}
		
		
}
