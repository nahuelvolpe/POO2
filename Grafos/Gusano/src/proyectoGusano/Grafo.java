package proyectoGusano;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Grafo {
	
	final int MAX = 1005;
	int[][] matrizAdyacencia;
	int[] nodos;
	int tamaño;
	ArrayList<PcInfectada> PcInfectadas = new ArrayList<PcInfectada>();
	ArrayList<Enlace> enlaces = new ArrayList<Enlace>();
	
	
	public Grafo(String ruta){
		int origen, destino ,distancia, CantPcInfectadas;
		int pc, hora;
		int pos=0;
        try{
        	Scanner sc = new Scanner(new File(ruta));
        	tamaño=sc.nextInt();
    
        	//GRAFO
        	matrizAdyacencia = new int[tamaño][tamaño];
        	for(int i=0; i<tamaño; i++){
        		for(int j=0; j<tamaño; j++){
        		matrizAdyacencia[i][j]=0;
        		}
        	}
        	
        	for(int i=0; i<tamaño; i++){
        		origen=sc.nextInt();
        		distancia=sc.nextInt();
        		destino=sc.nextInt();
        		enlaces.add(new Enlace(origen,destino,distancia));
        	}
        	
        	CantPcInfectadas=sc.nextInt();
        	for(int i=0; i<CantPcInfectadas; i++){
        		pc=sc.nextInt();
        		hora=sc.nextInt();
        	}
        	
    
        	//NODOS
        	nodos = new int[tamaño];
        	for(int i=0; i<tamaño; i++){
        		nodos[i]=i;
        	}
        	
        	sc.close();
        	}catch(IOException e){
        	e.printStackTrace();
        	}
       
        
	}
	
	public int getTamaño() {
		return tamaño;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public int[] getNodos() {
		return nodos;
	}


	public static void main (String[] args){
		Grafo g1 = new Grafo("grafo.in");
		/*Prim ejemploPrim = new Prim(g1.getMatrizAdyacencia(), g1.getVertices());
		int[][] matriz = new int[ejemplo.getTamaño()][ejemplo.getTamaño()];
		matriz=ejemploPrim.AlgPrim();
		System.out.println("Final desde MAIN: ");
		for(int i=0; i<ejemplo.getTamaño(); i++){
    		for(int j=0; j<ejemplo.getTamaño(); j++){
    		System.out.print(matriz[i][j]+"  ");
    		}
    		System.out.println();
    	}
		*/
		/*Kruskal ejemploKrustal = new Kruskal(g1.getAristas(), g1.getNodos(), g1.getCantAristas(), g1.getTamaño());
		ejemploKrustal.resolver();
		*/
		Dijkstra ejemploDijkstra = new Dijkstra (g1.getMatrizAdyacencia(), g1.getNodos());
		System.out.println(ejemploDijkstra.encontrarRutaMinimaDijkstra(0,5));
		
		
	}

}
