import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//
//class Item {
//
//	int weight;
//	int value;
//
//	public Item(int weight, int value) {
//		this.weight = weight;
//		this.value = value;
//	}
//}

public class DAA_3 {

	public static double getMaxValue(List<Item> items, int capacity) {

		Collections.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item item1, Item item2) {

				double ratio1 = (double) item1.value / item1.weight;
				double ratio2 = (double) item2.value / item2.weight;

				return Double.compare(ratio2, ratio1);
			}

		});

		double totalValue = 0.0;
		int currentWeight = 0;

		for (Item item : items) {
			if (currentWeight + item.weight <= capacity) {
//				System.out.println(item.weight);

				currentWeight += item.weight;
				totalValue += item.value;
//				System.out.println("if " + totalValue);
			} else {
				int remainingCapacity = capacity - currentWeight;
//				System.out.println("else" + totalValue);

				totalValue += (double) item.value * remainingCapacity / item.weight;

//				System.out.println("Afelse" + totalValue);

				break;
			}
		}

		return totalValue;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter the number of items: ");
		int n = in.nextInt();

		List<Item> items = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the weight of item " + (i + 1) + ": ");
			int weight = in.nextInt();
			System.out.println("Enter the value of item " + (i + 1) + ": ");
			int value = in.nextInt();
			items.add(new Item(weight, value));
		}
//		 items.add(new Item(10, 60));
//		 items.add(new Item(20, 100));
//		 items.add(new Item(30, 120));
		System.out.println("Enter the capacity of the knapsack: ");
		int capacity = in.nextInt();

		double maxValue = getMaxValue(items, capacity);
		System.out.println("Maximum value that can be obtained = " + maxValue);
	}

}
