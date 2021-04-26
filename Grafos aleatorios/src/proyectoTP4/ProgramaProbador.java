package proyectoTP4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaProbador {
	
	public static void testear(){
		ArrayList<Integer> aux=new ArrayList<>();
		
		try {
			GrafoNDNP grafo = new GrafoNDNP("grafo.in");
			
			Scanner sc = new Scanner(new FileReader("coloreado.out"));		
			sc.useLocale(Locale.ENGLISH);


			int cantNodos=sc.nextInt();
			int cantColores=sc.nextInt();
			int cantAristas=sc.nextInt();
			double porcentajeDeAdyacencia=sc.nextDouble();
			int gradoMax=sc.nextInt();
			int gradoMin=sc.nextInt();
			
			int[] vectorColoreo = new int[cantNodos];

			while(sc.hasNext()){

				boolean ready=false;
				
				int nodo=sc.nextInt();
				int color=sc.nextInt();

				vectorColoreo[nodo]=color;

				for (Integer i : aux) {
					
					if(color==i){
						
						ready=true;
					}
				}
				
				if(!ready){
					
					aux.add(color);
				}
			}

			
			if(cantNodos==grafo.getCantNodos()){

				System.out.println("Cantidad de nodos igual.");
			}else{

				System.out.println("Cantidad de nodos desigual.");
			}
			
			if(cantColores==aux.size()){

				System.out.println("Cantidad de colores igual.");
			}else{

				System.out.println("Cantidad de colores desigual.");
			}

			if(cantAristas==grafo.getCantAristas()){

				System.out.println("Cantidad de aristas igual.");
			}else{

				System.out.println("Cantidad de aristas desigual.");
			}

			if(porcentajeDeAdyacencia==grafo.getPorcentajeAdyacencia()){

				System.out.println("Porcentaje de adyacencia igual.");
			}else{

				System.out.println("Porcentaje de adyacencia desigual.");
			}

			if(gradoMax==grafo.getGradoMax()){

				System.out.println("Grado maximo igual.");
			}else{

				System.out.println("Grado maximo desigual.");
			}

			if(gradoMin==grafo.getGradoMin()){

				System.out.println("Grado minimo igual.");
			}else{

				System.out.println("Grado minimo desigual.");
			}
			/*
			System.out.println("Nodos pintados:");
			boolean condicion1=false;
			for (int i = 0; i < grafo.getCantNodos(); i++) {

				if (vectorColoreo[i] == -1) {
					condicion1=true;
					System.out.println("No se coloreo el nodo: " + i);
				}
			}
			if(condicion1=false)System.out.println("No hay nodos sin pintar");

			System.out.println("Nodos adyacentes con el mismo color:");
			boolean condicion2=false;
			for (int i = 0; i < grafo.getCantNodos(); i++) {
				for (int j = i + 1; j < grafo.getCantNodos(); j++) {

					if (grafo.sonAdyacentes(i, j)) {

						if (vectorColoreo[i] == vectorColoreo[j]) {
							condicion2=true;
							System.out.println("Los nodos " + i + " y " + j + " tienen el mismo color.");
						}
					}
				}
			}
			if(condicion2=false)System.out.println("No hay nodos adyacentes con el mismo color.");
			*/
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		
	}

}
