import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class F {

	public static String name = "F.txt";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(name));

		while (in.hasNextInt()) {
			int numboxes = in.nextInt();

			int[][] boxes = new int[numboxes][4];
			// int[] products = new int[numboxes];

			for (int i = 0; i < numboxes; i++) {
				// products[i] = 1;
				for (int j = 0; j < 4; j++) {
					boxes[i][j] = in.nextInt();
					// products[i] *= boxes[i][j];
				}
				Arrays.sort(boxes[i]);
				// System.out.println(products[i]);
			}

			// build a map of new position to original/old
			/*
			 * int[] prev_products = new int[products.length];
			 * System.arraycopy(products, 0, prev_products, 0, products.length);
			 * HashMap<Integer,Integer> new2orig = new
			 * HashMap<>(products.length); Arrays.sort(products); for(int i = 0;
			 * i < products.length; i++) { new2orig.put(i,
			 * Arrays.binarySearch(prev_products, key) }
			 */

			// construct fitting matrix
			boolean[][] fits = new boolean[numboxes][numboxes];
			ArrayList<int[]> combos = new ArrayList<int[]>();
			for (int i = 0; i < numboxes; i++) {
				for (int j = 0; j < numboxes; j++) {
					fits[i][j] = fits(boxes[i], boxes[j]);
					// System.out.print((fits[i][j] ? 1 : 0) + " ");
					if (fits[i][j]) {
						combos.add(new int[] { i, j });
					}
				}
				// System.out.println();
			}

			ArrayList<String> ren = new ArrayList<>();
			for (int[] first : combos) {

				ArrayList<int[]> len = new ArrayList<>();

				for (int i = 0; i < combos.size(); i++) {
					int[] ref = combos.get(i);
					if (first != ref)
						len.add(ref);
				}

				ren.add(first[0] + (miku(first, len)));
				// System.out.println(ren.get(ren.size() - 1));
			}

			String longest = "";
			for (String bot : ren) {
				if (longest.length() < bot.length()) {
					longest = bot;
				} else if (longest.length() == bot.length()) {
					int a = Integer.parseInt(longest.replace(" ", ""));
					int b = Integer.parseInt(bot.replace(" ", ""));
					longest = a < b ? longest : bot;
				}
			}
			
			
			String[] list = longest.split(" ");
			int[] nums = new int[list.length];
			for

			System.out.println(longest.split(" ").length);

			System.out.println(longest);
			// printArray(combos);
		}

		in.close();
	}

	// checks if a[] fits into b[]
	public static boolean fits(int[] a, int[] b) {
		for (int i = 0; i < 4; i++) {
			if (a[i] >= b[i])
				return false;
		}
		return true;
	}

	public static void printArray(ArrayList<int[]> list) {
		for (int[] i : list) {
			System.out.println("[" + i[0] + "," + i[1] + "]");
		}
	}

	public static String miku(int[] hat, ArrayList<int[]> sune) {
		if (sune.size() == 1) {
			if (hat[1] == sune.get(0)[0]) {
				return " " + sune.get(1);
			} else
				return "";
		} else {
			// Combo
			ArrayList<String> ren = new ArrayList<>();
			for (int[] test : sune) {
				if (hat[1] == test[0]) {
					ArrayList<int[]> len = new ArrayList<>();
					for (int[] test2 : sune) {
						if (test != test2) {
							len.add(test2);
						}
					}
					ren.add(" " + hat[1] + " " + test[1] + miku(test, len));
				}
			}
			String longest = "";
			for (String bot : ren) {
				if (longest.length() < bot.length()) {
					longest = bot;
				} else if (longest.length() == bot.length()) {
					int a = Integer.parseInt(longest.replace(" ", ""));
					int b = Integer.parseInt(bot.replace(" ", ""));
					longest = a < b ? longest : bot;
				}
			}
			return longest;
		}
	}
}
