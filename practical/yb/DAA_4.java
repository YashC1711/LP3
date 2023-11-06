import java.util.Scanner;

public class DAA_4 {

	public static int knapsack(int weights[], int values[], int capacity) {

		int n = weights.length;
		int dp[][] = new int[n][capacity + 1];

		for (int i = weights[0]; i <= capacity; i++) {
			dp[0][i] = values[0];
		}

		for (int ind = 1; ind < n; ind++) {
			for (int wt = 0; wt <= capacity; wt++) {

				int notTake = dp[ind - 1][wt];

				int take = Integer.MIN_VALUE;
				if (weights[ind] <= wt) {
					take = values[ind] + dp[ind - 1][wt - weights[ind]];
				}

				dp[ind][wt] = Math.max(take, notTake);
			}
		}

		return dp[n - 1][capacity];
	}

	public static void main(String[] args) {

//		int values[] = { 60, 100, 120 };
//		int weights[] = { 10, 20, 30 };

		int capacity = 50;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter total no of items: ");
		int n = in.nextInt();
		
		int values[] = new int[n];
		int weights[] = new int[n];

		for(int i = 0;i < n;i++) {
			System.out.println("Enter details of item " + (i + 1) + " : ");
			System.out.println("enter value: ");
			 values[i] = in.nextInt();
			 System.out.println("enter weight: ");
			weights[i] = in.nextInt();			
		}

		int maxValue = knapsack(weights, values, capacity);
		System.out.println("Maximum value that can be obtained = " + maxValue);

	}

}
