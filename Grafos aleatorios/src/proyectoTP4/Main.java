package proyectoTP4;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		GrafoAleatorio g1 = new GrafoAleatorio();
		g1.grafoAleatorioAdyacencia(600, 40);
		GrafoNDNP g2 = new GrafoNDNP("grafo.in");

		//ANALISIS
//		long time_start=0, time_end=0;
//		time_start = System.currentTimeMillis();
//		g2.analsis(10000);
//		time_end = System.currentTimeMillis();
//		System.out.println("El analisis se hizo en " + (time_end-time_start)+" Milisegundos");
		
		//TEST
		long time_comienzo=0, time_final =0;
		time_comienzo = System.currentTimeMillis();
		g2.coloreoSecuencial();
		//g2.coloreoWelshPowell();
		//g2.coloreoMatula();
		time_final = System.currentTimeMillis();
		System.out.println("El analisis se hizo en " + (time_final-time_comienzo)+" Milisegundos");
		ProgramaProbador.testear();
	}

}
