package proyectoVagones;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tren {
	ArrayList<Especie> animales = new ArrayList<Especie>();
	ArrayList<Vagon> vagones = new ArrayList<Vagon>();
	ArrayList<Integer> agresividadxVagon = new ArrayList<Integer>();
	int limiteAgresividad,cantAnimales;
	int agresividadTotal;
	
	//CONSTRUCTOR
	public Tren(String ruta){
		File f = null;
		FileReader fr = null;
		BufferedReader br =null;

        try{
			f = new File(ruta);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			String [] datos;
			String especie;
			int agresividad;
			int cantidad;
		
			linea=br.readLine();
			datos = linea.split(" ");
			cantAnimales = Integer.parseInt(datos[0]);
			limiteAgresividad = Integer.parseInt(datos[1]);
		
			for(int i=0; i<cantAnimales; i++){
				linea=br.readLine();
				datos = linea.split(" ");
				especie=datos[0];
				agresividad=Integer.parseInt(datos[1]);
				cantidad=Integer.parseInt(datos[2]);
				animales.add(new Especie(especie,agresividad,cantidad));
			}
			
		
        	}catch(IOException e){
        	e.printStackTrace();
        	}
	}
	
	
	public void resolver(){
		Collections.sort(animales, new Comparator<Especie>() {
			@Override
			public int compare(Especie a1, Especie a2) {
				return new Double(a2.getAgresividad()).compareTo(new Double(a1.getAgresividad()));
			}
		});
		
		for (int i = 0; i < this.cantAnimales; i++) {
			int cantVagones=agresividadxVagon.size();
			agresividadxVagon.add(0);
			for (int j = i+1; j < this.cantAnimales; j++) {
				if(animales.get(i).getAgresividad()-animales.get(j).getAgresividad()<this.limiteAgresividad){
					agresividadxVagon.set(cantVagones, (animales.get(i).getAgresividad()-animales.get(j).getAgresividad()));
					if(j+1==this.cantAnimales){
						i=j;
						agresividadTotal+=agresividadxVagon.get(cantVagones);
					}
				}else{
					i=j-1;
					agresividadTotal+=agresividadxVagon.get(cantVagones);
					break;
				}
			}
		}
	}

	public void escribir() throws IOException{
		FileWriter fichero = null;
		PrintWriter pw =null;
        try
        {
        	fichero = new FileWriter("vagon.out");
            pw =new PrintWriter(fichero);
            pw.println(agresividadxVagon.size()+" "+agresividadTotal);
            System.out.println(agresividadxVagon.size()+" "+agresividadTotal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
		fichero.close();
        }
	}
	
	//GETTERS AND SETTERS
	public int getLimiteAgresividad() {
		return limiteAgresividad;
	}
	public void setLimiteAgresividad(int limiteAgresividad) {
		this.limiteAgresividad = limiteAgresividad;
	}
	public int getCantAnimales() {
		return cantAnimales;
	}
	public void setCantEAnimales(int cantAnimales) {
		this.cantAnimales = cantAnimales;
	}
}
