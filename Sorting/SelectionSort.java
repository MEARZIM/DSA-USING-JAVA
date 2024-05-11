package Sorting;

public class SelectionSort {
	public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            printArray(arr, i + 1);
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
		// TODO Auto-generated method stub
		int[] arr = {64, 25, 12, 22, 11};
        System.out.print("Original array: ");
        printArray(arr, 0);
        selectionSort(arr);
        System.out.print("Sorted array: ");
        printArray(arr, 0);
	}

}

/*
 * OutPut->
Original array: Iteration 0: 64 25 12 22 11 
Iteration 1: 11 25 12 22 64 
Iteration 2: 11 12 25 22 64 
Iteration 3: 11 12 22 25 64 
Iteration 4: 11 12 22 25 64 
Sorted array: Iteration 0: 11 12 22 25 64 
 */
