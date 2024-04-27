package DynamicProgramming;

public class FibonacciNumber {
	
	public static int fiboUsingTabulation(int n) {
		int[] tab = new int[n+2];
		if (n<=1) {
			return 0;
		}
		tab[0]=0;
		tab[1]=1;
		
		for(int i=2; i<=n; i++) {
			tab[i] = tab[i-1]+tab[i-2];
		}
		return tab[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=9;
		System.out.println(fiboUsingTabulation(num));;
	}

}
