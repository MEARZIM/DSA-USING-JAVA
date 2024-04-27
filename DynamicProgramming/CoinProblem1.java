/**
 * 
 */
package DynamicProgramming;

/**
 * Given infinite supply of coins of different denominations and certain amount.
 * How many ways these coins can be combined to get the given amount.
 */
public class CoinProblem1 {

	public static int solution(int coin[], int amount) {
		int tab[][] = new int[coin.length + 1][amount + 1];

		for (int i = 0; i <= coin.length; i++) {
			tab[i][0] = 1;
		}

		for (int i = 1; i <= coin.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coin[i-1] > j) {
					tab[i][j] = tab[i - 1][j];
				} else {
					tab[i][j] = tab[i - 1][j] + tab[i][j - coin[i - 1]];
				}
			}
		}

//		for (int i = 0; i <= coin.length; i++) {
//			for (int j = 0; j <= amount; j++) {
//				System.out.print(tab[i][j] + " ");
//			}
//			System.out.println();
//		}
		return tab[coin.length][amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 2, 3, 5, 10 }; // Example denominations
		int amount = 15; // Example amount
		System.out.println("Number of ways to make " + amount + " using given coins: " + solution(coins, amount));
	}

}
