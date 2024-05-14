package Arrays;
/**
 *  Create a Class Search within that implement two Generic method LinearSearch(),
	BinarySearch(). Test your program for different data.
 */

class Search<T extends Comparable<T>>{
	public int LinearSearch(T arr[], T key) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public int BinarySearch(T arr[], T key) {
		int firstPosition = 0;
		int lastPosition = arr.length-1;
		int mid = (firstPosition + lastPosition)/2;
		
		while(firstPosition <= lastPosition ) {
			int cmp = arr[mid].compareTo(key);
			
			if(cmp < 0) {
				firstPosition = mid+1;
			}else if(cmp == 0) {
				return mid;
			}else {
				lastPosition = mid-1;
			}
			mid = (firstPosition + lastPosition)/2;
			
		}
		
		return -1;
	}
}

public class Question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] intArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
	        String[] strArray = {"apple", "banana", "cherry", "date", "grape", "kiwi", "orange", "peach", "pear", "watermelon"};

	        Search<Integer> intSearch = new Search<>();
	        Search<String> strSearch = new Search<>();

	        int intTarget = 11;
	        String strTarget = "kiwi";

	        System.out.println("Linear Search:");
	        System.out.println("Index of " + intTarget + " in intArray: " + intSearch.LinearSearch(intArray, intTarget));
	        System.out.println("Index of " + strTarget + " in strArray: " + strSearch.LinearSearch(strArray, strTarget));

	        System.out.println("\nBinary Search:");
	        System.out.println("Index of " + intTarget + " in intArray: " + intSearch.BinarySearch(intArray, intTarget));
	        System.out.println("Index of " + strTarget + " in strArray: " + strSearch.BinarySearch(strArray, strTarget));
		
		
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
