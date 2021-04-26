package proyectoPelicula;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;



public class Grafo {
	
	int[][] matrizAdyacencia;
	int[] nodos;
	int tama�o;
	int tamCinta;
	ArrayList<Segmento> segmentos= new ArrayList<Segmento>();
	static ArrayList<Segmento> finales= new ArrayList<Segmento>();
	
	public Grafo(String ruta){
		int comienzo, termino, costo;
		int pos=0;
        try{
        	Scanner sc = new Scanner(new File(ruta));
        	tama�o=sc.nextInt();
        	tamCinta=sc.nextInt();
    
        	//GRAFO
        	matrizAdyacencia = new int[tama�o][tama�o];
        	for(int i=0; i<tama�o; i++){
        		for(int j=0; j<tama�o; j++){
        		matrizAdyacencia[i][j]=-1;
        		}
        	}
        	
        	for(int i=0; i<tama�o; i++){
        		pos=sc.nextInt();
        		comienzo=sc.nextInt();
        		termino=sc.nextInt();
        		segmentos.add(new Segmento(pos, comienzo, termino));
        	}
        	
        	for(int i=0; i<tama�o; i++){
        		System.out.println(i+" "+segmentos.get(i).getPrincipio()+" "+segmentos.get(i).getTermino());
        	}
        	
        	System.out.println();
        	
        	for(int i=0; i<tama�o; i++){
        		for(int j=i+1; j<tama�o; j++){
        			if(segmentos.get(i).getTermino()==tamCinta){
        				break;
        			}
        			if(segmentos.get(i).getTermino()>=segmentos.get(j).getPrincipio()){
        				costo=(segmentos.get(i).getTermino()-segmentos.get(j).getPrincipio())+1;
        				matrizAdyacencia[i][j]=costo;
        				matrizAdyacencia[j][i]=costo;
        				costo=0;
        			}
        			if((segmentos.get(i).getTermino()+1)==segmentos.get(j).getPrincipio()){
        				costo=0;
        				matrizAdyacencia[i][j]=costo;
        				matrizAdyacencia[j][i]=costo;
        			}
        		}
        	}
        	
        	for(int i=0; i<tama�o; i++){
        		for(int j=0; j<tama�o; j++){
        		System.out.print(matrizAdyacencia[i][j] + " ");
        		}
        		System.out.println();
        	}
        	System.out.println();
        	
        	//NODOS
        	nodos = new int[tama�o];
        	for(int i=0; i<tama�o; i++){
        		nodos[i]=i;
        	}
        	
        
        	for(int i=0; i<tama�o; i++){
        		if(segmentos.get(i).getTermino()==tamCinta){
        			finales.add(segmentos.get(i));
        		}
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
	
	public int getTamCinta() {
		return tamCinta;
	}

	public static void main (String[] args){
		
		int cantNodos=0;
		String ruta = "";
		Grafo g1 = new Grafo("pelicula.in");
		int distancia = g1.getTamCinta();
		
		Dijkstra ejemploDijkstra = new Dijkstra (g1.getMatrizAdyacencia(), g1.getNodos());
	
		
		
		for(int i=0; i<finales.size(); i++){
			CaminoOptimo mejor = ejemploDijkstra.encontrarRutaMinimaDijkstra(0, finales.get(i).getPosicion());
			if(finales.get(i).getPrincipio()==1){
				distancia=0;
				ruta= "La cinta esta completa";
				break;
			}
			if(mejor.getDistancia()<distancia){
				distancia=mejor.getDistancia();
				ruta=mejor.getRuta();
				cantNodos=mejor.getCantidadNodos();
			}
			if(mejor.getDistancia()==distancia){
				if(mejor.getCantidadNodos()<cantNodos){
					distancia=mejor.getDistancia();
					ruta=mejor.getRuta();
					cantNodos=mejor.getCantidadNodos();
				}
			}
		}
		
		
		System.out.println("Costo: "+distancia+" | "+"Ruta: "+ruta);
		
	}

}
