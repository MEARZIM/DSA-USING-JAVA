/**
 * 
 */
package Sorting;

/**
 * 
 */
public class HeapSort {
	public static void heapSort(int[] arr) {
		int n = arr.length;

		// Build max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// Heap sort
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 64, 25, 12, 22, 11 };
		System.out.print("Original array: ");
		printArray(arr);
		heapSort(arr);
		System.out.print("Sorted array: ");
		printArray(arr);
	}
}



/*
 * OutPut->
Original array: 64 25 12 22 11 
Sorted array: 11 12 22 25 64  
 */