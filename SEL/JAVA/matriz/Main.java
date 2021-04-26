package matriz;

public class Main {

	public static void main(String[] args) {
		double[][] valores1={{1,1,0},{1,0,1},{0,1,0}};
		Matriz m1 = new Matriz(valores1);
		
		double[][] valores2={{2,1,1},{0,1,1},{0,1,1}};
		Matriz m2 = new Matriz(valores2);
		

		System.out.println();
		//m1.multiplicar(mI);
		m1.verificarIdentidad();
	}

}
