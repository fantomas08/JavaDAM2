package prueba;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = matrix.length - 1; j > i; --j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}

}
