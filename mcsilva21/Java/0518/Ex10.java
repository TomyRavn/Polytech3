import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		for(;;) {
			System.out.println("원하는 단 >>");
			int n = scan.nextInt();
			
			if(n<0) {
				System.out.println("종료합니다.");
				break;
			}

			for(int i =1; i<=9; i++)
				System.out.printf("%d x %d = %d\n",n,i,n*i);
		}
	
}
}