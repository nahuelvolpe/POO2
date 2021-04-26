package proyectoTP4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;




public class GrafoNDNP {
	
	private int cantNodos;
	private int cantAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;
	private int tam;
	private int[] orden;
	
	private MatrizSimetrica ms;
	
	public GrafoNDNP(String ruta){
		super();
		
		try{
        	Scanner sc = new Scanner(new File(ruta));
        	this.cantNodos=sc.nextInt();
        	this.cantAristas=sc.nextInt();
        	this.porcentajeAdyacencia=sc.nextInt();
        	this.gradoMax=sc.nextInt();
        	this.gradoMin=sc.nextInt();
        	this.tam=cantNodos*(cantNodos-1)/2;
        	this.ms = new MatrizSimetrica(tam,cantNodos);
   
        	orden = new int[cantNodos];
        	for(int i=0; i<cantNodos; i++){
        		orden[i]=i;
        	}
        	ms.inicializarMatriz();
 
        	int x, y;
        	while(sc.hasNext()){
        		x=sc.nextInt();
        		y=sc.nextInt();
        		ms.setMatriz(x, y, 1);
        	}
        	
        	/*for(int i=0; i<ms.getTam(); i++){
        		System.out.print(ms.getMatriz()[i] + " ");
        	}*/
        	sc.close();
        	}catch(IOException e){
        	e.printStackTrace();
        	}
	}
	
	
	
	public void analsis(int pasadas){
		this.coloreoSecuencial(pasadas);
		//this.coloreoWelshPowell(pasadas);
		//this.coloreoMatula(pasadas);
	}
	

	public void coloreoSecuencial (int pasadas){
		System.out.println("Iniciando analisis Secuencial");
		int cantColores;
		int[] frecuenciaColores = new int [cantNodos];
		int[] orden=this.OrdenamientoAleatorio();
		for(int i=0; i<pasadas; i++){
			cantColores=this.colorear(orden);
			frecuenciaColores[cantColores]++;
			}
		System.out.println("Analisis Secuencial Finalizado");
		System.out.println("Resultado: ");
		for(int i=0; i<cantNodos; i++){
			if(frecuenciaColores[i]>0){
			System.out.println(i+" "+frecuenciaColores[i]);
			}
		}
	}
		
		//Metodo->coloreoWelshPowell
	public void coloreoWelshPowell (int pasadas){
		System.out.println("Iniciando analisis Welsh-Powell");
		int cantColores;
		int[] frecuenciaColores = new int [cantNodos];
		int[] orden=this.OrdenamientoAleatorio();
		orden=this.OrdenamientoMayorAMenorGrado(orden, 0, (this.getCantNodos()-1));
		for(int i=0; i<pasadas; i++){
			cantColores=this.colorear(orden);
			frecuenciaColores[cantColores]++;
			}
		System.out.println("Analisis Welsh Finalizado");
		System.out.println("Resultado: ");
		for(int i=0; i<cantNodos; i++){
			if(frecuenciaColores[i]>0){
			System.out.println(i+" "+frecuenciaColores[i]);
			}
		}
	}
		
		//Metodo->coloreoMatula
	public void coloreoMatula (int pasadas){
		System.out.println("Iniciando analisis Matula");
		int cantColores;
		int[] frecuenciaColores = new int [cantNodos];
		int[] orden=this.OrdenamientoAleatorio();
		orden=this.OrdenamientoMenorAMayorGrado(orden, 0, (this.getCantNodos()-1));
		for(int i=0; i<pasadas; i++){
			cantColores=this.colorear(orden);
			frecuenciaColores[cantColores]++;
			}
		System.out.println("Analisis Maula Finalizado");
		System.out.println("Resultado: ");
		for(int i=0; i<cantNodos; i++){
			if(frecuenciaColores[i]>0){
			System.out.println(i+" "+frecuenciaColores[i]);
			}
		}
	}
	
	public void coloreoSecuencial(){
		int[] orden=this.OrdenamientoAleatorio();
		this.coloreo(orden);
	}
	
	public void coloreoWelshPowell(){
		int[] orden=this.OrdenamientoAleatorio();
		orden=this.OrdenamientoMayorAMenorGrado(orden, 0, (this.getCantNodos()-1));
		this.coloreo(orden);
	}
	public void coloreoMatula(){
		int[] orden=this.OrdenamientoAleatorio();
		orden=this.OrdenamientoMenorAMayorGrado(orden, 0, (this.getCantNodos()-1));
		this.coloreo(orden);
	}
	private int colorear(int[] orden){
		int cantColores=0;
		int[] vectorColores=new int[this.getCantNodos()];
		
		Arrays.fill(vectorColores, -1);
		
		int nodoRandom=(int) (Math.random()*this.getCantNodos());
		vectorColores[nodoRandom]=0;
		for (int i = 0; i < orden.length; i++) {

			int color=0;

			for (int j = 0; j < vectorColores.length; j++) {

				if(orden[i]!=j){

					if(this.sonAdyacentes(orden[i], j)){
						if(vectorColores[j]==color){
							
							color++;
							j=-1;

							if(color>=cantColores){

								cantColores++;
							}
						}
					}
				}
			}

			vectorColores[orden[i]]=color;
		}
		return cantColores;
		
	}
	
	private void coloreo(int[] orden){
		int cantColores=0;
		int[] vectorColores=new int[this.getCantNodos()];
		
		Arrays.fill(vectorColores, -1);
		
		int nodoRandom=(int) (Math.random()*this.getCantNodos());
		vectorColores[nodoRandom]=0;
		for (int i = 0; i < orden.length; i++) {

			int color=0;

			for (int j = 0; j < vectorColores.length; j++) {

				if(orden[i]!=j){

					if(this.sonAdyacentes(orden[i], j)){
						if(vectorColores[j]==color){
							
							color++;
							j=-1;

							if(color>=cantColores){

								cantColores++;
							}
						}
					}
				}
			}

			vectorColores[orden[i]]=color;
		}
		
		escribir(vectorColores, cantColores);
	}
	
	private void escribir(int[] vectorColoreo, int cantColores){

		FileWriter fichero = null;
		PrintWriter pw = null;

		try
		{
			fichero = new FileWriter("coloreado.out");
			pw = new PrintWriter(fichero);

			pw.println(this.getCantNodos()+" "+cantColores+" "+this.getCantAristas()+" "+this.getPorcentajeAdyacencia()+" "+this.getGradoMax()+" "+this.getGradoMin());

			for (int i = 0; i < this.getCantNodos(); i++) {
				pw.println(i+" "+vectorColoreo[i]);
			}
			System.out.println("coloreo.out creado");
		}catch (Exception e) {
			System.out.println("Error en la escritura del archivo 'coloreado.out'");
			e.printStackTrace();
		} finally {

			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int getVertice(int n)
	{
		return this.orden[n];
	}
	
	public int getCantNodos() {
		return cantNodos;
	}

	public int getTam() {
		return tam;
	}
	
	private int gradoNodo(int nodo){

		int grado = 0;

		for (int i = 0; i< this.cantNodos; i ++){

			if(i!=nodo){

				grado+=this.ms.getValor(nodo, i);
			}
		}

		return grado;
	}

	//Metodo->gradoMaxMi
	public int[] gradoMaxMin() {

		int grado[]={0,this.cantNodos};

		for (int i = 0; i < this.cantNodos; i++){

			int aux;

			aux = gradoNodo(i);

			if (aux > grado[0]) {

				grado[0] = aux;
			}
			
			else if(aux < grado[1]){
				
				grado[1] = aux;
			}
		}

		return grado;
	}
	
	//Metodo->sonAdyacentes
	public boolean sonAdyacentes(int i, int j) {

		return (ms.getValor(i, j) == 1)?true:false; 
	}

	//Metodo->numOrdenamientoAleatorio
	public int[] OrdenamientoAleatorio(){

		int[] orden=new int[this.cantNodos];

		//asigna un numero de ordenamiento aleatorio sin repetir a los nodos
		int rango = this.cantNodos;
		int[] posiciones=new int[this.cantNodos];     

		Random rnd = new Random();
		int res;

		for(int i=0;i<this.cantNodos;i++){
			posiciones[i]=i;
		} 

		for(int i=0;i<this.cantNodos;i++){

			res = rnd.nextInt(rango);           
			orden[i]=posiciones[res];
			rango--;
			posiciones[res]=posiciones[rango];              
		}

		return orden;
	}

	//Metodo->OrdenamientoMayorAMenorGrado
	public int[] OrdenamientoMayorAMenorGrado(int[] orden, int primero, int ultimo){

		int i=primero, j=ultimo;
		int pivote=orden[(primero + ultimo) / 2];
		int auxiliar;

		do{
			while(gradoNodo(orden[i])>gradoNodo(pivote)){ 
				i++;
			}
			while(gradoNodo(orden[j])<gradoNodo(pivote)) {
				j--;
			}
			if (i<=j){

				if (i!=j) {

					auxiliar=orden[j];
					orden[j]=orden[i];
					orden[i]=auxiliar;
				}

				i++;
				j--;
			}
		} while (i<=j);

		if(primero<j) {
			OrdenamientoMayorAMenorGrado(orden,primero, j);
		}

		if(ultimo>i) {
			OrdenamientoMayorAMenorGrado(orden,i, ultimo);
		}

		return orden;
	}

	//Metodo->OrdenamientoMayorAMenorGrado
	public int[] OrdenamientoMenorAMayorGrado(int[] orden, int primero, int ultimo){

		int i=primero, j=ultimo;
		int pivote=orden[(primero + ultimo) / 2];
		int auxiliar;

		do{
			while(gradoNodo(orden[i])<gradoNodo(pivote)){ 
				i++;
			}
			while(gradoNodo(orden[j])>gradoNodo(pivote)) {
				j--;
			}
			if (i<=j){

				if (i!=j) {

					auxiliar=orden[j];
					orden[j]=orden[i];
					orden[i]=auxiliar;
				}

				i++;
				j--;
			}
		} while (i<=j);

		if(primero<j) {
			OrdenamientoMayorAMenorGrado(orden,primero, j);
		}

		if(ultimo>i) {
			OrdenamientoMayorAMenorGrado(orden,i, ultimo);
		}

		return orden;
	}
	
	

	public int getGradoMax() {
		return gradoMax;
	}

	public void setGradoMax(int gradoMax) {
		this.gradoMax = gradoMax;
	}
	
	public int getGradoMin() {
		return gradoMin;
	}
	
	public void setGradoMin(int gradoMin) {
		this.gradoMin = gradoMin;
	}
	
	public int getDatoMatriz(int i, int j) {
		return ms.getValor(i, j);
	}
	
	public void setDatoMatriz(int i, int j, char data) {
		this.ms.setMatriz(i, j, data);
	}
	
	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public int getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}

	public void setPorcentajeAdyacencia(int porcentajeAdyacencia) {
		this.porcentajeAdyacencia = porcentajeAdyacencia;
	}

}
