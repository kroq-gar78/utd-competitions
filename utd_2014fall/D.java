import java.io.File;
import java.util.*;
//import java.awt.geom.*;

public class D {

	public static String name = "D.txt";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(name));

		int runs = in.nextInt();

		for (int i = 0; i < runs; i++) {
			long a0 = in.nextLong();
			ArrayList<Long> list = new ArrayList<Long>();
			list.add(a0);
			while(list.get(list.size()-1)!=1){
				long a = list.get(list.size()-1);
				if(a%2==0)
					list.add((long)Math.pow(a, .5));
				else
					list.add((long)Math.pow(a, 1.5));
			}
			Collections.sort(list);
			System.out.println(list.size()+" "+list.get(list.size()-1));
		}

		in.close();
	}
	
	

}
