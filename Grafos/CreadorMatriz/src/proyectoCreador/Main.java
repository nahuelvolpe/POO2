package proyectoCreador;

import java.util.Random;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
		
		int norma;
		norma=900;
		double[][] matriz = null;
		matriz = new double[norma][norma];
		Random r = new Random();
		System.out.println(r.nextInt());
		for(int i=0; i<norma; i++){
			for(int j=0; j<norma; j++){
				matriz[i][j]=r.nextInt(999);
			}
		}
		
		try{
    		fichero = new FileWriter(norma+"x"+norma+".in");
    		pw = new PrintWriter(fichero);
    		pw.println(norma);
    		for(int i=0; i<norma; i++){
    			for(int j=0; j<norma; j++){
    				pw.println(i+" "+j+" "+matriz[i][j]);
    			}
    		}
    		
    		for(int i=0; i<norma; i++){
    			pw.println(r.nextInt(99));
    		}
    		
    	} catch (Exception e) {
        e.printStackTrace();
    } finally {
       try {
       if (null != fichero)
          fichero.close();
       } catch (Exception e2) {
          e2.getMessage();
       }
    }

	}

}
