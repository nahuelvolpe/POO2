package vector;

public class Vector {
	private int[] vec=null;
	private int dimension;
	private int[] vecsuma=null;
	
	
	public Vector(int[] valores){
		this.vec=valores;
		dimension=vec.length;
	}
	
	
	public void mostrarVector(){
		System.out.println("Vector: ");
		for(int i=0; i<vec.length; i++){
			System.out.println(vec[i]);
		}
	}
	
	public void sumaryMostrar(Vector v2){
		vecsuma=new int[dimension];
		for (int i=0; i<dimension; i++){
			vecsuma[i]=this.vec[i]+v2.vec[i];
		}
		
		System.out.println("Resultado de la suma: ");
		for (int i=0; i<dimension; i++){
			System.out.println(vecsuma[i]);
		}
	}
	
	public void restaryMostrar(Vector v2){
		vecsuma=new int[dimension];
		for (int i=0; i<dimension; i++){
			vecsuma[i]=this.vec[i]-v2.vec[i];
		}
		
		System.out.println("Resultado de la resta: ");
		for (int i=0; i<dimension; i++){
			System.out.println(vecsuma[i]);
		}
	}
	
	public void productoEscalar(Vector v2){
		vecsuma=new int[dimension];
		int producto=0;
		for (int i=0; i<dimension; i++){
			vecsuma[i]=this.vec[i]*v2.vec[i];
			producto=producto+vecsuma[i];
		}
		
		//for (int i=0; i<dimension; i++){
			//System.out.println(vecsuma[i]);
		//}
		System.out.println("Producto escalar: " + producto);
	}
	
	public void vectorXescalar(int k){
		vecsuma=new int[dimension];
		for (int i=0; i<dimension; i++){
			vecsuma[i]=this.vec[i]*k;
		}
		
		System.out.println("Resultado por un escalar: ");
		for (int i=0; i<dimension; i++){
			System.out.println(vecsuma[i]);
		}
	}
	
	public void productoVectorial(Vector v2){
		int i=0,j=0,k=0;
		if (dimension==2){
			i=0;
			j=0;
			k=(this.vec[0]*v2.vec[1])-(v2.vec[0]*this.vec[1]);
		}
		if (dimension==3){
			i=(this.vec[1]*v2.vec[2])-(v2.vec[1]*this.vec[2]);
			j=(this.vec[0]*v2.vec[2])-(v2.vec[0]*this.vec[2]);
			k=(this.vec[0]*v2.vec[1])-(v2.vec[0]*this.vec[1]);
		}
		System.out.println("v1^v2=("+i+","+j+","+k+")");
	}
	
}
