/**
 * 
 */
package Arrays;

import java.util.ArrayList;

/**
 * Write class SparseMatrix to give a compressed storage representation of a
 * sparse matrix and also find the transpose of the sparse matrix (from the
 * compressed representation).
 */

class Matrix {
	private int row;
	private int col;
	private int value;

	public Matrix(int row, int column, int value) {
		this.row = row;
		this.col = column;
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getValue() {
		return value;
	}
}

class SparseMatrix {
	private int numberOfRows;
	private int numberOfColumns;
	private ArrayList<Matrix> matrix;

	public SparseMatrix(int numRows, int numCols) {
		this.numberOfRows = numRows;
		this.numberOfColumns = numCols;
		this.matrix = new ArrayList<>();
	}

	public boolean addElements(int row, int col, int value) {
		if (row >= 0 && col >= 0 && row < this.numberOfRows && col < this.numberOfColumns) {
			boolean response = matrix.add(new Matrix(row, col, value));
			return response;
		}
		return false;
	}

	public SparseMatrix transpose() {
		SparseMatrix transposeMatrix = new SparseMatrix(this.numberOfColumns, this.numberOfRows);
		for (Matrix t : matrix) {
			transposeMatrix.addElements(t.getCol(), t.getRow(), t.getValue());
		}
		return transposeMatrix;
	}

	public void printMatrix() {

		for (int i = 0; i < this.numberOfRows; i++) {
			for (int j = 0; j < this.numberOfColumns; j++) {
				boolean found = false;
				for (Matrix m : matrix) {
					if (m.getRow() == i && m.getCol() == j) {
						System.out.print(m.getValue() + " ");
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
}

public class Question4 {

	public static void main(String[] args) {
		SparseMatrix sparseMatrix = new SparseMatrix(3, 3);
		sparseMatrix.addElements(0, 0, 3);
		sparseMatrix.addElements(0, 2, 5);
		sparseMatrix.addElements(1, 1, 8);
		sparseMatrix.addElements(2, 0, 1);
		sparseMatrix.addElements(2, 2, 4);

		System.out.println("Original Sparse Matrix:");
		sparseMatrix.printMatrix();

		SparseMatrix transposedMatrix = sparseMatrix.transpose();
		System.out.println("\nTransposed Sparse Matrix:");
		transposedMatrix.printMatrix();
	}
}
/*
 * Output:
Original Sparse Matrix:
3 0 5 
0 8 0 
1 0 4 

Transposed Sparse Matrix:
3 0 1 
0 8 0 
5 0 4 


 */