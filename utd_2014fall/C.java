import java.io.File;
import java.util.Scanner;

public class C {

	public static String name = "C.txt";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(name));

		//int runs = in.nextInt();

		while(in.hasNextInt()){
			int a = in.nextInt();
			if(a==0){
				break;
			}
			else if(a>=10){
				System.out.print(a+" " );
				sumDigits(a);
				System.out.println();
			}
			else{
				System.out.println(a);
			}
		}

		in.close();
	}
	
	public static void sumDigits(int num){
		
			
		if(num>=10){
			String str = num+"";
			int sum=1;
			for(int x=0;x<str.length();x++)
				sum*=Integer.parseInt(str.charAt(x)+"");
			if(sum>9){
				System.out.print(sum+" ");
				sumDigits(sum);
			}
			else{
				System.out.print(sum);
			}
		}
		
			
			
		
	}

}
