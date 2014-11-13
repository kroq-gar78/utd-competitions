import java.io.File;
import java.util.*;

public class B {

	public static String name = "B.txt";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(name));

		int runs = in.nextInt();

		for (int r = 0; r < runs; r++) {
			int[] dims = new int[2];
			dims[0] = in.nextInt();
			dims[1] = in.nextInt();
			
			int numblocks = in.nextInt();
			ArrayList<int[]> blocks = new ArrayList<int[]>();
			for(int i = 0; i < numblocks; i++)
			{
				Scanner blockscan = new Scanner(in.next());
				blockscan.useDelimiter(":");
				int y = blockscan.next().charAt(0)-'A' + 1;
				int x = blockscan.nextInt();
				//System.out.println(x + "," + y);
				blocks.add(new int[]{x,y});
			}
			
			System.out.println(shortestPaths(1, 1, dims, blocks));
		}

		in.close();
	}
	
	public static int shortestPaths(int x, int y, int[] dims, ArrayList<int[]> blocked)
	{
		if(contains(x,y,blocked)) return 0;
		if (x > dims[0] || y > dims[1]) return 0;
		if (x == dims[0] && y == dims[1]) return 1;
		
		return shortestPaths(x+1, y, dims, blocked) + shortestPaths(x, y+1, dims, blocked);
	}
	
	public static boolean contains(int x, int y, ArrayList<int[]> points)
	{
		for(int[] i : points)
		{
			if(x == i[0] && y == i[1]) return true;
		}
		return false;
	}
}
