package proyectoTP4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class GrafoAleatorio {
	int[][] grafo;
	int tam;
	public GrafoAleatorio(){
		super();
	}

	public void grafoAleatorioAdyacencia(int nodos, int porcentaje) throws IOException{
		tam=nodos;
		int cantAristasMaximas=nodos*(nodos-1)/2;
		System.out.println("tam "+tam);
		int cont=0;
		int cantAristas = (porcentaje*cantAristasMaximas)/100;
		System.out.println("cantAristas "+cantAristas);
		grafo = new int[tam][tam];
		
		
		for(int i=0; i<tam; i++)
			for(int j=0; j<tam; j++){
				grafo[i][j]='0';
			}

		while(cantAristas!=cont){
			cont=0;
			for(int i=0; i<tam; i++){
				for(int j=0; j<tam; j++)
					grafo[i][j]='0';
			}
			for(int i=0; i<tam; i++){
				for(int j=0; j<tam; j++){
					if(Math.random()*100<porcentaje && i<j){
						grafo[i][j]='1';
						grafo[j][i]='1';
						cont++;
					}
				}
			}
		}
		
		/*
		for(int i=0; i<this.getTam(); i++){
			for(int j=0; j<this.getTam(); j++){
    		System.out.print(this.getGrafo()[i][j]+" ");
			}
			System.out.println();
		}
		*/
		int gradoMax=this.gradoMax();
		int gradoMin=this.gradoMin();
		
		FileWriter fichero = null;
		PrintWriter pw =null;
	    try{
	        fichero = new FileWriter("grafo.in");
	        pw =new PrintWriter(fichero);
	        pw.println(nodos+" "+cantAristas+" "+porcentaje+" "+gradoMax+" "+gradoMin);
	        
	        
	        for(int i=0; i<nodos; i++){
	        	for(int j=0; j<nodos; j++){
	        		if(grafo[i][j]=='1' && i<j){
	        			pw.println(i+" "+j);
	        		}
	        	}
	        }
	        
	        System.out.println("grafo.in creado");
	        
	    } catch (Exception e) {
	    	e.printStackTrace(); 
	    } finally {  
			fichero.close();
	    }
		
		
	}

	public int gradoMax(){
		int retorno=0;

		
		for(int i=0; i<this.getTam(); i++){
			int aux=0;
			aux=this.getGradoVertice(i);
			if(aux>retorno){
				retorno=aux;
			}
		}
		return retorno;
	}
	
	public int gradoMin(){
		int retorno=this.getTam();

		for(int i=0; i<this.getTam(); i++){
			int aux=0;
			aux=this.getGradoVertice(i);
			if(aux<retorno){
				retorno=aux;
			}
		}
		return retorno;
	}
	
	public int getGradoVertice(int vertice){
		int grado=0;
		for(int i=0; i<this.getTam(); i++){
			if(this.grafo[vertice][i]=='1')grado++;
		}
		return grado;
	}
	
	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
}
