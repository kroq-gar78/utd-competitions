import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class A {

	private int a;
	private int b;
	private int c;

	public A(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void rotate() {
		int t = a;
		a = c;
		c = b;
		b = t;
	}

	public String toString() {
		return ("Triangle with sides " + a + ", " + b + ", and " + c + ".");
	}

	public static String name = "A.txt";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(name));

		while (true) {
			ArrayList<A> mikus = new ArrayList<>(5);
			A start = new A(in.nextInt(), in.nextInt(), in.nextInt());
			in.nextLine();
			for (int i = 0; i < 5; i++) {
				mikus.add(new A(in.nextInt(), in.nextInt(), in.nextInt()));
				in.nextLine();
			}
			int c = start.c;
			int s1 = score(start, mikus, start);
			s1 = s1 > 0 ? c + s1 : -1;
			start.rotate();
			c = start.c;
			int s2 = score(start, mikus, start);
			s2 = s2 > 0 ? c + s2 : -1;
			start.rotate();
			c = start.c;
			int s3 = score(start, mikus, start);
			s3 = s3 > 0 ? c + s3 : -1;
			// System.out.println(s1 + ", " + s2 + ", " + s3);
			s1 = s1 > s2 ? s1 : s2;
			s1 = s1 > s3 ? s1 : s3;
			System.out.println(s1 > 0 ? s1 : "none");
			if (in.nextLine().equals("$"))
				System.exit(0);
		}
	}

	public static int score(A start, ArrayList<A> test, A orig) {
		if (test.size() == 1) {
			A b = test.get(0);
			// System.out.println("Testing side " + start.b + " against");
			// System.out.println(b);
			for (int i = 0; i < 3; i++) {
				if (start.b == b.a && orig.a == b.b) {
					// System.out.println("Works!");
					return b.c;
				}
				b.rotate();
			}
			// System.out.println("Failed!");
			return -1;
		} else {
			int max = -1;
			for (A a : test) {
				for (int i = 0; i < 3; i++) {
					if (start.b == a.a) {
						
						ArrayList<A> mikus = new ArrayList<>();
						for (A b : test)
							if (a != b)
								mikus.add(b);
						int s1 = score(a, mikus, orig);
						s1 = s1 > 0 ? s1 + a.c : -1;
						if (max < s1)
							max = s1;
					} else
						a.rotate();
				}
			}
			return max;
		}
		// return -1;
	}

}
