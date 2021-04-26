package proyectoGrafo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Grafo {
	
	final int MAX = 1005;
	int[][] matrizAdyacencia;
	int[] nodos;
	int tama�o;
	ArrayList<Arista> aristas = new ArrayList<Arista>(); //ArrayList de aristas para el uso en kKruskal
	int cantAristas;
	ArrayList<Integer> vertices= new ArrayList<Integer>();//ArrayList de integers para el uso de Prim
	
	
	public Grafo(String ruta){
		int x,y,distancia;
		int pos=0;
        try{
        	Scanner sc = new Scanner(new File(ruta));
        	tama�o=sc.nextInt();
    
        	//GRAFO
        	matrizAdyacencia = new int[tama�o][tama�o];
        	for(int i=0; i<tama�o; i++){
        		for(int j=0; j<tama�o; j++){
        		matrizAdyacencia[i][j]=0;
        		}
        	}
        	
        	while(sc.hasNext()){
        		x=sc.nextInt();
        		y=sc.nextInt();
        		distancia=sc.nextInt();
    	    	aristas.add(new Arista(x,y,distancia));
        		matrizAdyacencia[x][y]=distancia;
        		matrizAdyacencia[y][x]=distancia;
        		pos++;
        	}
        	cantAristas=pos;
        	
        	//NODOS
        	nodos = new int[tama�o];
        	for(int i=0; i<tama�o; i++){
        		nodos[i]=i;
        	}
        
        	//VERTICES (NODOS)
        	for(int i=0; i<tama�o; i++){
        		vertices.add(nodos[i]);
        	}
        	
        	sc.close();
        	}catch(IOException e){
        	e.printStackTrace();
        	}
       
        
	}
	
	public int getTama�o() {
		return tama�o;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public int[] getNodos() {
		return nodos;
	}
	
	public ArrayList<Integer> getVertices() {
		return vertices;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public static void main (String[] args){
		Grafo g1 = new Grafo("grafo.in");
		/*Prim ejemploPrim = new Prim(g1.getMatrizAdyacencia(), g1.getVertices());
		int[][] matriz = new int[ejemplo.getTama�o()][ejemplo.getTama�o()];
		matriz=ejemploPrim.AlgPrim();
		System.out.println("Final desde MAIN: ");
		for(int i=0; i<ejemplo.getTama�o(); i++){
    		for(int j=0; j<ejemplo.getTama�o(); j++){
    		System.out.print(matriz[i][j]+"  ");
    		}
    		System.out.println();
    	}
		*/
		/*Kruskal ejemploKrustal = new Kruskal(g1.getAristas(), g1.getNodos(), g1.getCantAristas(), g1.getTama�o());
		ejemploKrustal.resolver();
		*/
		Dijkstra ejemploDijkstra = new Dijkstra (g1.getMatrizAdyacencia(), g1.getNodos());
		System.out.println(ejemploDijkstra.encontrarRutaMinimaDijkstra(0,5));
		
		
	}

}
