package proyectoIslas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Grafo {
	
	final int MAX = 1005;
	int[][] matrizAdyacencia;
	int[] nodos;
	int tamaño;
	ArrayList<Arista> aristas = new ArrayList<Arista>(); //ArrayList de aristas para el uso en kKruskal
	int cantAristas;
	ArrayList<Integer> vertices= new ArrayList<Integer>();//ArrayList de integers para el uso de Prim
	
	
	public Grafo(String ruta){
		int x,y,distancia,cantPuentes,cantTuneles;
		int pos=0;
        try{
        	Scanner sc = new Scanner(new File(ruta));
        	tamaño=sc.nextInt();
        	cantPuentes=sc.nextInt();
        	cantTuneles=sc.nextInt();
        	//GRAFO
        	matrizAdyacencia = new int[tamaño][tamaño];
        	for(int i=0; i<tamaño; i++){
        		for(int j=0; j<tamaño; j++){
        		matrizAdyacencia[i][j]=-1;
        		}
        	}
        	
        	for(int i=0; i<cantPuentes; i++){
        		x=sc.nextInt();
        		y=sc.nextInt();
    	    	aristas.add(new Arista(x,y,1));
        		matrizAdyacencia[x][y]=1;
        		matrizAdyacencia[y][x]=1;
        	}
        	
        	for(int i=0; i<cantTuneles; i++){
        		x=sc.nextInt();
        		y=sc.nextInt();
    	    	aristas.add(new Arista(x,y,0));
        		matrizAdyacencia[x][y]=0;
        		matrizAdyacencia[y][x]=0;
        	}
        	
        	
        	//NODOS
        	nodos = new int[tamaño];
        	for(int i=0; i<tamaño; i++){
        		nodos[i]=i;
        	}
        
        	//VERTICES (NODOS)
        	for(int i=0; i<tamaño; i++){
        		vertices.add(nodos[i]);
        	}
        	
        	for(int i=0; i<tamaño; i++){
        		for(int j=0; j<tamaño; j++){
        			System.out.print(matrizAdyacencia[i][j]+" ");
        		}
        		System.out.println();
        	}
        	System.out.println();
        	
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
		Grafo g1 = new Grafo("islas.in");
		Prim ejemploPrim = new Prim(g1.getMatrizAdyacencia(), g1.getVertices());
		int[][] matriz = new int[g1.getTamaño()][g1.getTamaño()];
		matriz=ejemploPrim.AlgPrim();
		System.out.println("Final desde MAIN: ");
		for(int i=0; i<g1.getTamaño(); i++){
    		for(int j=0; j<g1.getTamaño(); j++){
    		System.out.print(matriz[i][j]+"  ");
    		}
    		System.out.println();
    	}
		
		/*Kruskal ejemploKrustal = new Kruskal(g1.getAristas(), g1.getNodos(), g1.getCantAristas(), g1.getTamaño());
		ejemploKrustal.resolver();*/
		
		
	}

}
