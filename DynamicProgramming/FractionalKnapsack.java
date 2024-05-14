package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

class Item {
	int value, weight;

	// Constructor
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}

public class FractionalKnapsack {
	// Function to get the maximum value with the given capacity of the knapsack
	public static double getMaxValue(int[] wt, int[] val, int capacity) {
		Item[] items = new Item[wt.length];

		// Create items from given weight and value arrays
		for (int i = 0; i < wt.length; i++) {
			items[i] = new Item(val[i], wt[i]);
		}

		// Sort items by value per weight in descending order
		Arrays.sort(items, new Comparator<Item>() {
			public int compare(Item a, Item b) {
				double valuePerWeightA = (double) a.value / a.weight;
				double valuePerWeightB = (double) b.value / b.weight;
				return Double.compare(valuePerWeightB, valuePerWeightA);
			}
		});

		double totalValue = 0d;
		int currentWeight = 0;

		// Iterate through sorted items and add them to the knapsack until its capacity
		// is reached
		for (Item item : items) {
			if (currentWeight + item.weight <= capacity) {
				// Add the entire item if it fits in the knapsack
				currentWeight += item.weight;
				totalValue += item.value;
			} else {
				// Add a fraction of the item if it doesn't fit entirely
				int remainingCapacity = capacity - currentWeight;
				double fraction = (double) remainingCapacity / item.weight;
				totalValue += item.value * fraction;
				break; // Knapsack is full
			}
		}

		return totalValue;
	}

	public static void main(String[] args) {
		int[] val = { 60, 100, 120 };
		int[] wt = { 10, 20, 30 };
		int capacity = 50;

		double maxValue = getMaxValue(wt, val, capacity);
		System.out.println("Maximum value that can be obtained = " + maxValue);
	}
}
