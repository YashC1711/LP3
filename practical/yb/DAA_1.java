import java.util.Arrays;
import java.util.Scanner;

public class DAA_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a number : ");
		int n = in.nextInt();

		while (true) {
			System.out.println("Enter your choice: ");
			System.out.println("   1. Recursive approach.");
			System.out.println("   2. Non-recursive approach.");
			System.out.println("   3. Exit.");
			int ch = in.nextInt();
			switch (ch) {
			case 1:
				System.out.println(fiboRec(n));
				break;

			case 2:
				System.out.println(fiboNRec(n));
				break;
			case 3:
				System.out.println("Thank you!");
				return;

			}
		}

	}

	public static long fiboRec(int n) {

		if (n <= 1) {
			return n;
		} else {
			return fiboRec(n - 1) + fiboRec(n - 2);
		}
	}

	public static long fiboNRec(int n) {

		int prev2 = 0;
		int prev1 = 1;

		for (int i = 2; i <= n; i++) {
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}

		return prev1;
	}

//	Time complexity :
	// recursive - O(2^n) and space -O(n).
	// Non recursive - O(n) & space -O(1).

}
