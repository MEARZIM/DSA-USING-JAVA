/**
 * 
 */
package Sorting;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
			printArray(arr, i);
		}
	}

	public static void printArray(int[] arr, int iteration) {
		System.out.print("Iteration " + iteration + ": ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 64, 25, 12, 22, 11 };
		System.out.print("Original array: ");
		printArray(arr, 0);
		insertionSort(arr);
		System.out.print("Sorted array: ");
		printArray(arr, 0);
	}

}

/*
 * OutPut->
Original array: Iteration 0: 64 25 12 22 11 
Iteration 1: 25 64 12 22 11 
Iteration 2: 12 25 64 22 11 
Iteration 3: 12 22 25 64 11 
Iteration 4: 11 12 22 25 64 
Sorted array: Iteration 0: 11 12 22 25 64 
 */