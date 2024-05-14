/**
 * 
 */
package Arrays;

/**
 * Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the
	matrix.	
 */
public class Question6 {

	public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
		int m1Rows = matrix1.length;
		int m1Cols = matrix1[0].length;
		int m2Cols = matrix2[0].length;

		double[][] result = new double[m1Rows][m2Cols];

		for (int i = 0; i < m1Rows; i++) {
			for (int j = 0; j < m2Cols; j++) {
				for (int k = 0; k < m1Cols; k++) {
					result[i][j] += (matrix1[i][k] * matrix2[k][j]);
				}
			}
		}
		return result;
	}

	public static double[][] transpose(double[][] matrix) {
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		double[][] result = new double[numCols][numRows];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				result[j][i] = matrix[i][j];
			}
		}
		return result;
	}

	public static boolean isIdentityMatrix(double[][] matrix) {
		int numRows = matrix.length;
		int numCols = matrix[0].length;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isOrthogonal(double matrix[][]) {
		double[][] product = multiplyMatrix(transpose(matrix), matrix);
		return isIdentityMatrix(product);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] matrix = { 
				{ 0, 1}, 
				{ 1, 0} 
		};

		System.out.println("Matrix is orthogonal: " + isOrthogonal(matrix));
	}

}
/*
 * Output:
Matrix is orthogonal: true

 */