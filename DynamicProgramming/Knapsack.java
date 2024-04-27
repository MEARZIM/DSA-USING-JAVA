/**
 * 
 */
package DynamicProgramming;

public class Knapsack {

	public static int findMax(int a, int b) {
		return a > b ? a : b;
	}

	public static int knapsack(int profit[], int weight[], int maxSize) {
		int tab[][] = new int[profit.length + 1][maxSize + 1];

		for (int i = 0; i < profit.length + 1; i++) {
			for (int j = 0; j < maxSize + 1; j++) {
				if (i == 0 || j == 0) {
					tab[i][j] = 0;
				} else if (weight[i - 1] <= j) {
					tab[i][j] = findMax(tab[i - 1][j], profit[i - 1] + tab[i - 1][j - weight[i - 1]]);
				} else {
					tab[i][j] = tab[i - 1][j];
				}
			}

		}

//		for (int i = 0; i < profit.length + 1; i++) {
//			for (int j = 0; j < maxSize + 1; j++) {
//				System.out.print(tab[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		return tab[profit.length][maxSize];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int profit[] = { 2, 3, 4, 1 };
		int weight[] = { 3, 4, 5, 6 };
		int maxSize = 8;

		System.out.println("MaxProfit is : "+knapsack(profit, weight, maxSize));
	}

}
