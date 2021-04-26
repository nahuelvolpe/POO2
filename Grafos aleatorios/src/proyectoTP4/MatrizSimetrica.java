package proyectoTP4;

public class MatrizSimetrica {
	
	private boolean[] matriz;
	private int tam;
	private int cantNodos;
	
	public MatrizSimetrica(int size, int nodos){
		this.matriz = new boolean[size];
		this.tam = size;
		this.cantNodos=nodos;
	}
	
	public void inicializarMatriz(){
		for(int i=0; i<this.getTam(); i++){
			this.matriz[i]=false;
		}
	}
	
	private boolean aBoolean(int dato){

		return (dato==1)?true:false;
	}
	
	public void setMatriz(int i, int j, int data){
		this.matriz[(i<j)?(i*this.cantNodos+j-(i*i+3*i+2)/2):(j*this.cantNodos+i-(j*j+3*j+2)/2)] = this.aBoolean(data);
	}
	
	
	private int aInt(boolean matriz2){

		return (matriz2)?1:0;
	}
	
	public int getValor(int i, int j){
		return (i<j)?this.aInt(matriz[(i*this.cantNodos+j-(i*i+3*i+2)/2)]):this.aInt(matriz[(j*this.cantNodos+i-(j*j+3*j+2)/2)]);
		/*int pos=-1;
		int aux=0;
		if(i<j){
			pos=i*this.getCantNodos()+j-((i*i) + 3 * i + 2)/2;
		}
		if(i>j){
			aux=i;
			i=j;
			j=aux;
			pos=i*this.getCantNodos()+j-((i*i) + 3 * i + 2)/2;
		}
		if(j==i){
			return '-';
		}
		return matriz[pos];*/
	}
	
	

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	public int getCantNodos() {
		return cantNodos;
	}

	public void mostrar(){
		for(int i=0; i<this.getTam(); i++){
			System.out.print(matriz[i]+" ");
		}
		System.out.println();
	}
	
	

}
