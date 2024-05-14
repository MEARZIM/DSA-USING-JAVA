/**
 * 
 */
package Arrays;

/**
 *  Create a Class BasicSort within that implement three Generic methods that can implement the
	BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data.
 */

class BasicSort<T extends Comparable<T>>{
	
	public void BuubleSort(T[] arr) {
		/*
		 * Time Complexity: Best: O(n); Worst: O(n^2) 
		 * Space Complexity: O(1)
		 */
		T temp;
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length-i-1; j++) {
				if(arr[j].compareTo(arr[j+1])>0) {
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public void SelectionSort(T[] arr) {
		/*
		 * Time Complexity: Best: O(n^2); Average: O(n^2); Worst: O(n^2) 
		 * Space Complexity: O(1)
		 */
		for (int i=0; i<arr.length-1; i++) {
			int minIndex = i;
			for (int j=i+1; j<arr.length; j++) {
				if(arr[minIndex].compareTo(arr[j])>0) {
					minIndex =j;
				}
			}
			T temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
	
	public void InsertionSort(T[] arr) {
		/*
		 * Insertion is good for small elements only because it requires more time for sorting 
		   large number of elements.
		   * Time Complexity: Best: O(n); Worst: O(n^2) 
		   * Space Complexity: O(1)
		 */
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j > -1 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
	}
}

public class Question2 {
	
	private static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = {5, 3, 8, 2, 7, 1, 9, 4, 6};
		Double[] doubleArray = {1.0, 3.3, 2.9, 2.99, 3.5, 6.2, 2.0, 7.0};
        String[] strArray = {"banana", "apple", "orange", "grape", "kiwi"};

        BasicSort<Integer> intSort = new BasicSort<>();
        BasicSort<Double> dblSort = new BasicSort<>();
        BasicSort<String> strSort = new BasicSort<>();

        System.out.println("Before sorting:");
        printArray(intArray);
        printArray(doubleArray);
        printArray(strArray);

        intSort.BuubleSort(intArray);
        dblSort.InsertionSort(doubleArray);
        strSort.SelectionSort(strArray);

        System.out.println("\nAfter sorting:");
        printArray(intArray);
        printArray(doubleArray);
        printArray(strArray);
	}

}
/*
 * Output: 
Linear Search:
Index of 11 in intArray: 5
Index of kiwi in strArray: 5

Binary Search:
Index of 11 in intArray: 5
Index of kiwi in strArray: 5

*/
