package vector;

public class Testeo {
	public static void main(String[] args) {
		
		//Vector 1
		int[] valoresv1={4,5};
		Vector v1 = new Vector(valoresv1);
		
		//Vector 2
		int[] valoresv2={6,5};
		Vector v2 = new Vector(valoresv2);
		
		
		v1.mostrarVector();
		v2.mostrarVector();
		v1.sumaryMostrar(v2);
		v1.restaryMostrar(v2);
		v1.productoEscalar(v2);
		v1.vectorXescalar(2);
		v1.productoVectorial(v2);
	}
}
