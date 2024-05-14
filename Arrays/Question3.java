/**
 * 
 */
package Arrays;

/**
 * Write a Generic method that computes the Second minimum and Second maximum
 * elements of an array of type T and returns a pair containing the minimum and
 * maximum value.
 */
class Pair<T, U> {
	private T first;
	private U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}
}

public class Question3<T extends Comparable<T>> {

	public Pair<T, T> findSecondMinMax(T[] arr) {

		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Array must contain at least two elements");
		}
		T min = arr[0];
		T max = arr[0];
		T secondMin = null;
		T secondMax = null;

		// Second Minimum;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(min) < 0) {
				secondMin = min;
				min = arr[i];
			} else if (secondMin == null || arr[i].compareTo(secondMin) < 0) {
				secondMin = min;
			}
		}

		// Second Maximum;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(max) > 0) {
				secondMax = max;
				max = arr[i];
			} else if (secondMax == null || arr[i].compareTo(secondMax) > 0) {
				secondMax = max;
			}
		}

		return new Pair<>(secondMin, secondMax);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = { 5, 3, 8, 2, 7, 1, 9, 4, 6 };
		Question3<Integer> intSecondMinMax = new Question3<>();
		Pair<Integer, Integer> result = intSecondMinMax.findSecondMinMax(intArray);
		System.out.println("Second minimum: " + result.getFirst());
		System.out.println("Second maximum: " + result.getSecond());
	}

}
/*
 * Output:
Second minimum: 2
Second maximum: 8

 */