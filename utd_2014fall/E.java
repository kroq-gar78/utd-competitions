import java.io.File;
import java.util.Scanner;

public class E {

	public static String name = "E.txt";

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File(name));

		while (in.hasNextLine()) {
			String k = in.nextLine();
			String[] nums = k.split("[+-/]");
			if (nums.length == 1) {
				int reg = k.indexOf("*");
				nums = new String[2];
				nums[0] = k.substring(0, reg);
				nums[1] = k.substring(reg + 1, k.length());
			}
			int one = dec(nums[0]);
			int two = dec(nums[1]);
			k = k.replace(nums[0], "").replace(nums[1], "");
			switch (k) {
			case "+":
				System.out.println(enc(one + two));
				break;
			case "-":
				System.out.println(enc(one - two));
				break;
			case "*":
				System.out.println(enc(one * two));
				break;
			case "/":
				System.out.println(enc(one / two));
				break;
			}
		}

		in.close();
	}

	public static String[] code = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
			"X", "IX", "V", "IV", "I" };
	public static int[] vald = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,
			5, 4, 1 };

	public static int dec(String rom) {
		rom = rom.toUpperCase();
		int sum = 0;
		for (int i = 0; i < vald.length; i++) {
			while (rom.indexOf(code[i]) == 0) {
				sum += vald[i];
				rom = rom.substring(code[i].length());
			}
		}
		return sum;
	}

	public static String enc(int x) {
		String rec = "";
		for (int i = 0; i < vald.length; i++) {
			while (x >= vald[i]) {
				x -= vald[i];
				rec += code[i];
			}
		}
		return rec;
	}

}
