import java.util.Scanner;

public class Ex08_팩토리얼 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sum=1;
		int i;
		
		while(true) {	
			int fact=1;		
		System.out.println("임의의 정수를 입력하세요");
			int n =s.nextInt();
		
		System.out.println("=================================");
		System.out.printf("%5s%30s\n","n","1부터 n까지의 곱");
		System.out.println("=================================");
		
				
		for(i=1; i<=n; i++) {
			System.out.printf("%d%30d\n",i,sum=sum*i);}
			
			System.out.println("y/n");
			s.nextLine();
			char ans = s.nextLine().charAt(0);
			
			if(ans == 'n') {
				System.out.println("종료");
				break;
			}
			
	
	}

}
}
	

