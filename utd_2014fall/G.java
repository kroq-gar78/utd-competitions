import java.io.File;
import java.util.Scanner;

public class G {

	public static String name = "G.txt";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(name));

		int runs = in.nextInt();

		for (int i = 0; i < runs; i++) {
			
		}

		in.close();
	}

}
