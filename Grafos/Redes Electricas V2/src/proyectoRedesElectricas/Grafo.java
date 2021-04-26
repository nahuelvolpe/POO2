package proyectoRedesElectricas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Grafo {
	
	final int MAX = 1005;
	int[][] matrizAdyacencia;
	int[] nodos;
	int tamaño;
	int cantAristas;
	ArrayList<Integer> vertices= new ArrayList<Integer>();//ArrayList de integers para el uso de Prim
	//Map<Integer, String> ciudades = new HashMap<Integer, String>();
	ArrayList<Ciudad> ciudades= new ArrayList<Ciudad>();
	
	
	public Grafo(String ruta){
		int x,y,cantAristas,longitud,seccion;
		int distancia;
		String origen,destino,co,cd;
		int pos=0;
        try{
        	Scanner sc1 = new Scanner(new File(ruta));
        	tamaño=sc1.nextInt();
        	cantAristas=sc1.nextInt();
        	origen=sc1.next();
        	destino=sc1.next();
    
        	//GRAFO
        	matrizAdyacencia = new int[tamaño][tamaño];
        	for(int i=0; i<tamaño; i++){
        		for(int j=0; j<tamaño; j++){
        		matrizAdyacencia[i][j]=0;
        		}
        	}
        	
        	
        	for(int i=0; i<cantAristas; i++){
        		co=sc1.next();
        		agregarCiudad(co);
        		cd=sc1.next();
        		agregarCiudad(cd);
        		longitud=sc1.nextInt();
        		seccion=sc1.nextInt();
        		distancia=(17*longitud)/seccion;
        	}
        	
        	for(int i=0; i<ciudades.size(); i++){
        		System.out.println(ciudades.get(i));
        	}
        	
        	sc1.close();
        	
        	Scanner sc2 = new Scanner(new File(ruta));
        	tamaño=sc2.nextInt();
        	cantAristas=sc2.nextInt();
        	origen=sc2.next();
        	destino=sc2.next();
        	
        	for(int i=0; i<cantAristas; i++){
        		co=sc2.next();
        		cd=sc2.next();
        		longitud=sc2.nextInt();
        		seccion=sc2.nextInt();
        		distancia=(17*longitud)/seccion;
        		corresponderCiudad(co,cd,distancia);
        	}
        	
        	for(int i=0; i<tamaño; i++){
        		for(int j=0; j<tamaño; j++){
        		System.out.print(matrizAdyacencia[i][j]+" ");
        		}
        		System.out.println();
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
        	
        	sc2.close();
        	}catch(IOException e){
        	e.printStackTrace();
        	}
       
        
	}
	
	public void corresponderCiudad(String co, String cd, int distancia){
		int x=0,y=0;
		for(int i=0; i<ciudades.size(); i++){
			if(ciudades.get(i).getNombre().equals(co)){
				x=ciudades.get(i).getPosicion();
			}
			if(ciudades.get(i).getNombre().equals(cd)){
				y=ciudades.get(i).getPosicion();
			}
		}
		matrizAdyacencia[x][y]=distancia;
		matrizAdyacencia[y][x]=distancia;
	}
	
	public void agregarCiudad(String c){
		boolean condicion=false;
		if(ciudades.size()==0){
			ciudades.add(new Ciudad(0,c));
		}else{
			for(int i=0; i<ciudades.size(); i++){
				if(ciudades.get(i).getNombre().equals(c)){
					condicion=true;
				}
			}
			if(condicion==false){
				ciudades.add(new Ciudad(ciudades.size(), c));
			}
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

	public int getCantAristas() {
		return cantAristas;
	}

	public static void main (String[] args){
		Grafo g1 = new Grafo("redes.in");
	
		Dijkstra ejemploDijkstra = new Dijkstra (g1.getMatrizAdyacencia(), g1.getNodos());
		System.out.println(ejemploDijkstra.encontrarRutaMinimaDijkstra(0,2));
		
		
		
	}

}
