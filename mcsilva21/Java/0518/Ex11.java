import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			System.out.println("원하는 단 >>");
			int n = scan.nextInt();
			
			int i =1;
			
			while(true) {
			for(i=1; i<9; i++)
				System.out.println(n+"x"+i+"="+ (n*i));
			
			System.out.println("원하는 단 >>");
			n = scan.nextInt();
			
			if(n<0)
				break;
			}
			

	}

}
