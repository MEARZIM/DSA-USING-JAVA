/**
 * 
 */
package Arrays;

/**
 *  Write a Class CheckTriangular within that implement methods to check whether
  	a matrix is i) Lower triangular ii) Upper triangular iii) Diagonal iv)
  	Identity v) Tridiagonal.
 */
class CheckTriangular {
	public boolean isLowerTriangular(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isUpperTriangular(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matrix[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isDiagonal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i != j && matrix[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isIdentity(int[][] matrix) {
		if (!isDiagonal(matrix)) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][i] != 1) {
				return false;
			}
		}
		return true;
	}

	public boolean isTridiagonal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (Math.abs(i - j) > 1 && matrix[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
}

public class Question5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] lowerTriangular = { { 1, 0, 0 }, { 2, 3, 0 }, { 4, 5, 6 } };

		int[][] upperTriangular = { { 1, 2, 3 }, { 0, 4, 5 }, { 0, 0, 6 } };

		int[][] diagonal = { { 1, 0, 0 }, { 0, 2, 0 }, { 0, 0, 3 } };

		int[][] identity = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

		int[][] tridiagonal = { { 1, 2, 0 }, { 3, 4, 5 }, { 0, 6, 7 } };

		CheckTriangular MatrixTypeChecker = new CheckTriangular();

		System.out.println("Is Lower Triangular: " + MatrixTypeChecker.isLowerTriangular(lowerTriangular));
		System.out.println("Is Upper Triangular: " + MatrixTypeChecker.isUpperTriangular(upperTriangular));
		System.out.println("Is Diagonal: " + MatrixTypeChecker.isDiagonal(diagonal));
		System.out.println("Is Identity: " + MatrixTypeChecker.isIdentity(identity));
		System.out.println("Is Tridiagonal: " + MatrixTypeChecker.isTridiagonal(tridiagonal));
	}

}

/*
 * Output:
Is Lower Triangular: true
Is Upper Triangular: true
Is Diagonal: true
Is Identity: true
Is Tridiagonal: true


*/