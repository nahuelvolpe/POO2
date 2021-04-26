package matriz;

public class Matriz {
	double[][] matrizAux=null;
	double[][] matriz=null;
	double cantFilas;
	double cantColumnas;

	public Matriz(double[][] valores){
		this.matriz=valores;
		cantFilas=matriz.length;
		cantColumnas=matriz[0].length;
	}
	
	public void sumar(Matriz m2){
		matrizAux= new double[(int) this.cantFilas][(int) this.cantColumnas];
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j<matriz[i].length; j++){
				matrizAux[i][j]=(int) (this.matriz[i][j]+m2.matriz[i][j]);
			}
		}
	}

	public void restar(Matriz m2){
		matrizAux= new double[(int) this.cantFilas][(int) this.cantColumnas];
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j<matriz[0].length; j++){
				matrizAux[i][j]=this.matriz[i][j]-m2.matriz[i][j];
			}
		}
	}
	
	
	public void multiplicar (Matriz m2){
		if(this.cantColumnas != m2.cantFilas){
			throw new RuntimeException("No se puede multiplicar");
		}
		matrizAux=new double[(int) this.cantFilas][(int) m2.cantColumnas];
		for(int x=0; x<matrizAux.length; x++){
			for(int y=0; y<matrizAux[x].length; y++){
				for(int z=0; z<this.cantColumnas; z++){
					matrizAux[x][y] += this.matriz[x][z]*m2.matriz[z][y];
				}
			}
		}
		
		for(int i=0; i<matrizAux.length; i++){
	    	System.out.print("|");
			for(int j=0; j<matrizAux[i].length; j++){
				System.out.print(matrizAux[i][j]);
				if (j!=matrizAux[i].length-1){
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
		
	}
	

	public double[][] matrizInversa(double[][] matriz) {
	    double det=1/determinante(matriz);
	    double[][] nmatriz=matrizAdjunta(matriz);
	    multiplicarMatriz(det,nmatriz);
	    
	    for(int i=0; i<nmatriz.length; i++){
	    	System.out.print("|");
			for(int j=0; j<nmatriz[i].length; j++){
				System.out.print(nmatriz[i][j]);
				if (j!=nmatriz[i].length-1){
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
	    
	    return nmatriz;
	    }
	 
	public void multiplicarMatriz(double n, double[][] matriz) {
	    for(int i=0;i<matriz.length;i++)
	        for(int j=0;j<matriz.length;j++)
	            matriz[i][j]*=n;
	}

	public static double[][] matrizAdjunta(double [][] matriz){
	    return matrizTranspuesta(matrizCofactores(matriz));
	}

	public static double[][] matrizCofactores(double[][] matriz){
	    double[][] nm=new double[matriz.length][matriz.length];
	    for(int i=0;i<matriz.length;i++) {
	        for(int j=0;j<matriz.length;j++) {
	            double[][] det=new double[matriz.length-1][matriz.length-1];
	            double detValor;
	            for(int k=0;k<matriz.length;k++) {
	                if(k!=i) {
	                    for(int l=0;l<matriz.length;l++) {
	                        if(l!=j) {
	                        int indice1=k<i ? k : k-1 ;
	                        int indice2=l<j ? l : l-1 ;
	                        det[indice1][indice2]=matriz[k][l];
	                        }
	                    }
	                }
	            }
	            detValor=determinante(det);
	            nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
	        }
	    }
	    return nm;
	}

	public static double[][] matrizTranspuesta(double [][] matriz){
	    double[][]nuevam=new double[matriz[0].length][matriz.length];
	    for(int i=0; i<matriz.length; i++){
	        for(int j=0; j<matriz.length; j++)
	            nuevam[i][j]=matriz[j][i];
	    }
	    return nuevam;
	}
	
	public static double determinante(double[][] matriz)
	{
	    double det;
	    if(matriz.length==2){
	        det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
	        return det;
	    }
	    double suma=0;
	    for(int i=0; i<matriz.length; i++){
	    double[][] nm=new double[matriz.length-1][matriz.length-1];
	        for(int j=0; j<matriz.length; j++){
	            if(j!=i){
	                for(int k=1; k<matriz.length; k++){
	                int indice=-1;
	                if(j<i)
	                indice=j;
	                else if(j>i)
	                indice=j-1;
	                nm[indice][k-1]=matriz[j][k];
	                }
	            }
	        }
	        if(i%2==0)
	        suma+=matriz[i][0] * determinante(nm);
	        else
	        suma-=matriz[i][0] * determinante(nm);
	    }
	    
	return suma;
	}
	
	public void verificarIdentidad (){
		Matriz mI = new Matriz(this.matrizInversa(this.matriz));
		matrizAux=new double[(int) this.cantFilas][(int) mI.cantColumnas];
		for(int x=0; x<matrizAux.length; x++){
			for(int y=0; y<matrizAux[x].length; y++){
				for(int z=0; z<this.cantColumnas; z++){
					matrizAux[x][y] += this.matriz[x][z]*mI.matriz[z][y];
				}
			}
		}
		for(int i=0; i<matrizAux.length; i++){
	    	System.out.print("|");
			for(int j=0; j<matrizAux[i].length; j++){
				System.out.print(matrizAux[i][j]);
				if (j!=matrizAux[i].length-1){
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
	}
}

	
