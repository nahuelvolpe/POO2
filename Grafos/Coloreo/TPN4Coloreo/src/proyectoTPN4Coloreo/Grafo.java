package proyectoTPN4Coloreo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Grafo {
	
	int[][] matrizAdyacencia;
	int[] nodos;
	int tamaño;
	
	
	
	public Grafo(String ruta){
		int x,y,distancia;
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
        	
        	while(sc.hasNext()){
        		x=sc.nextInt();
        		y=sc.nextInt();
        		matrizAdyacencia[x][y]=1;
        		matrizAdyacencia[y][x]=1;
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
		Grafo g1 = new Grafo("coloreo.in");
		ColoreoSecuencial c = new ColoreoSecuencial(g1.getMatrizAdyacencia());
		c.coloreo();
	}

}
