package proyectoRedes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Grafo {
	
	final int MAX = 1005;
	double[][] matrizAdyacencia;
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
        	Scanner sc = new Scanner(new File(ruta));
        	tamaño=sc.nextInt();
        	cantAristas=sc.nextInt();
        	origen=sc.next();
        	destino=sc.next();
    
        	//GRAFO
        	matrizAdyacencia = new double[tamaño][tamaño];
        	for(int i=0; i<tamaño; i++){
        		for(int j=0; j<tamaño; j++){
        		matrizAdyacencia[i][j]=0;
        		}
        	}
        	
        	
        	for(int i=0; i<cantAristas; i++){
        		System.out.println("iteracion " +i);
        		co=sc.next();
        		cd=sc.next();
        		System.out.println("co: "+co+" | cd: "+cd);
        		longitud=sc.nextInt();
        		seccion=sc.nextInt();
        		distancia=(17*longitud)/seccion;
        		verificarCiudad(co,cd,i,distancia);
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
        	
        	sc.close();
        	}catch(IOException e){
        	e.printStackTrace();
        	}
       
        
	}
	
	public void verificarCiudad(String co, String cd, int pos, int distancia){
		boolean origen=false;
		boolean	destino=false;
		boolean estanLasDos=false;
		if(ciudades.size()==0){
			System.out.println("primera carga");
			ciudades.add(new Ciudad(pos, co));
			ciudades.add(new Ciudad(pos+1, cd));
			matrizAdyacencia[pos][pos+1]=distancia;
			matrizAdyacencia[pos+1][pos]=distancia;
			origen=true;
			destino=true;
			System.out.println(pos);
		}else{
			for(int i=0; i<ciudades.size(); i++){
				System.out.println("for"+pos);
				System.out.println("ciudad"+i+": "+ciudades.get(i).getNombre()+" | "+co );
				
				if(ciudades.get(i).getNombre().equals(co)){
					for(int j=0; j<ciudades.size(); i++){
						if(ciudades.get(j).getNombre().equals(cd)){
							estanLasDos=true;
							matrizAdyacencia[ciudades.get(i).getPosicion()][ciudades.get(j).getPosicion()]=distancia;
							matrizAdyacencia[ciudades.get(j).getPosicion()][ciudades.get(i).getPosicion()]=distancia;
						}
						if(estanLasDos)break;
					}
				}
				if(estanLasDos)break;
				
				if(ciudades.get(i).getNombre().equals(cd)){
					for(int j=0; j<ciudades.size(); i++){
						if(ciudades.get(j).getNombre().equals(co)){					
							matrizAdyacencia[ciudades.get(i).getPosicion()][ciudades.get(j).getPosicion()]=distancia;
							matrizAdyacencia[ciudades.get(j).getPosicion()][ciudades.get(i).getPosicion()]=distancia;
						}
						if(estanLasDos)break;
					}
				}
				if(estanLasDos)break;
				
				if(ciudades.get(i).getNombre().equals(co)){
					System.out.println("co"+ pos);
					origen=true;
					destino=false;
					break;
				}
				if(ciudades.get(i).getNombre().equals(cd)){
					System.out.println("cd"+pos);
					origen=false;
					destino=true;
					break;
				}
			}
			
			if(origen==true && destino==false){
				System.out.println("origen true "+pos);
				for(int i=0; i<ciudades.size(); i++){
					if(ciudades.get(i).getNombre().equals(co)){
						System.out.println("WIN");
						ciudades.add(new Ciudad((ciudades.size()+1),cd));
						matrizAdyacencia[ciudades.size()-1][ciudades.get(i).getPosicion()]=distancia;
						matrizAdyacencia[ciudades.get(i).getPosicion()][ciudades.size()-1]=distancia;
					}
				}
			}
			if(origen==false && destino==true){
				System.out.println("destino true "+pos);
				for(int i=0; i<ciudades.size(); i++){
					if(ciudades.get(i).getNombre().equals(cd)){
						ciudades.add(new Ciudad((ciudades.size()+1), co));
						matrizAdyacencia[ciudades.size()-1][ciudades.get(i).getPosicion()]=distancia;
						matrizAdyacencia[ciudades.get(i).getPosicion()][ciudades.size()-1]=distancia;
					}
				}
			}
			if(origen==false && destino ==false){
				System.out.println("false"+pos);
				ciudades.add(new Ciudad((ciudades.size()+1), co));
				ciudades.add(new Ciudad((ciudades.size()+1), cd));
						matrizAdyacencia[ciudades.size()-2][ciudades.size()-1]=distancia;
						matrizAdyacencia[ciudades.size()-1][ciudades.size()-2]=distancia;
			}
		}
	}
	
	
	
	public int getTamaño() {
		return tamaño;
	}

	public double[][] getMatrizAdyacencia() {
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
	
		/*Dijkstra ejemploDijkstra = new Dijkstra (g1.getMatrizAdyacencia(), g1.getNodos());
		System.out.println(ejemploDijkstra.encontrarRutaMinimaDijkstra(0,5));
		*/
		
		
	}

}
