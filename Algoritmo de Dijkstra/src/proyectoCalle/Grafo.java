package proyectoCalle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Grafo {

	int[][] matrizAdyacencia;
	int[] nodos;
	int cantEsquinas;
	int cantCalles;
	int inicio;
	int fin;
	int costo;
	ArrayList<Calle> calles = new ArrayList<Calle>();
	ArrayList<Camino> caminos = new ArrayList<Camino>();
	ArrayList<Integer> solucion = new ArrayList<Integer>();
	
	public Grafo(String ruta){
		int x,y,distancia,pos=1;
        try{
        	Scanner sc = new Scanner(new File(ruta));
        	cantEsquinas=sc.nextInt();
        	inicio=sc.nextInt();
        	fin=sc.nextInt();
        	cantCalles=sc.nextInt();
    
        	//GRAFO
        	matrizAdyacencia = new int[cantEsquinas+1][cantEsquinas+1];
        	for(int i=0; i<cantEsquinas+1; i++){
        		for(int j=0; j<cantEsquinas+1; j++){
        		matrizAdyacencia[i][j]=0;
        		}
        	}
        	
        	while(sc.hasNext()){
        		x=sc.nextInt();
        		y=sc.nextInt();
        		calles.add(new Calle(x,y,pos));
        		distancia=sc.nextInt();
        		matrizAdyacencia[x][y]=distancia;
        		matrizAdyacencia[y][x]=distancia;
        		pos++;
        	}
        	
        	//NODOS
        	nodos = new int[cantEsquinas+1];
        	for(int i=0; i<cantEsquinas+1; i++){
        		nodos[i]=i;
        	}
        	
        	sc.close();
        
    		
        	}catch(IOException e){
        	e.printStackTrace();
        	}
        
        
	}
	
	public void resolver() throws IOException{
		Dijkstra ejemploDijkstra = new Dijkstra (this.getMatrizAdyacencia(), this.getNodos());
		caminos=ejemploDijkstra.encontrarRutaMinimaDijkstra(this.getInicio(), this.getFin());
		costo=ejemploDijkstra.getDistancia();
		this.cambioMano();
		this.escribir();
	}
	
	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public int[] getNodos() {
		return nodos;
	}
	
	public int getCantEsquinas() {
		return cantEsquinas;
	}

	public int getCantCalles() {
		return cantCalles;
	}

	public int getInicio() {
		return inicio;
	}

	public int getFin() {
		return fin;
	}
	
	public void cambioMano(){
		for(int i=0; i<caminos.size(); i++){
			for(int j=0; j<calles.size(); j++){
			if(caminos.get(i).getInicio()==calles.get(j).getDestino() && caminos.get(i).getFin()==calles.get(j).getOrigen()){
				solucion.add(calles.get(j).getPosicion());
			}
			}
		}
		
		
	}

	public void escribir() throws IOException{
		FileWriter fichero=null;
		PrintWriter pw=null;
		
		try{
			fichero = new FileWriter("cambio.out");
			pw = new PrintWriter(fichero);
			pw.println(getCosto());
			if(solucion.isEmpty()){
				pw.print("Ningun cambio");
			}else{
			for(int i=0; i<solucion.size(); i++){
				pw.print(solucion.get(i)+" ");
			}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			fichero.close();
		}	
		}
	
	public int getCosto() {
		return costo;
	}
	
	public static void main(String[] args) throws IOException{
		Grafo g1 = new Grafo("cambio.in");
		g1.resolver();
	}



}
