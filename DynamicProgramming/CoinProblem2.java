/**
 * 
 */
package DynamicProgramming;

/**
 * 
 */
public class CoinProblem2 {
	public static int findMin(int a, int b) {
		return a<b? a:b;
	}
	
	public static int solution (int coins[], int amount) {
		final int MAX=1000;
		int tab[][] = new int[coins.length+1][amount+1];
		
		for(int i=0; i<=coins.length; i++) {
			tab[i][0] = 0;
		}
		
		for (int j = 1; j <= amount; j++) {
            tab[0][j] = MAX;
        }
		
		for(int i=1; i<=coins.length; i++) {
			for (int j=1; j<= amount; j++) {
				if (coins[i-1]>j) {
					tab[i][j] = tab[i-1][j];
				} else {
					tab[i][j] = findMin(tab[i-1][j], tab[i][j-coins[i-1]]+1);
				}
			}
		}
		
//		for(int i=0; i<=coins.length; i++) {
//			for (int j=0; j<= amount; j++) {
//				System.out.print(tab[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		
		return tab[coins.length][amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 1, 5, 6, 9 }; // Example denominations
		int amount = 10; // Example amount
		System.out.println("MINIMUM Number of ways to make " + amount + " using given coins: " + solution(coins, amount));
		
	}

}
