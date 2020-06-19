import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		//사용자가 입력한 모든 정수 값들에 대하여 1부터 그 정수까지의 누적 승을 출력하는 프로그램을 작성하시오.
		//y를 입력하면 계속, n을 입력하면 종료
		
		Scanner sc = new Scanner(System.in);
		
		int num;	
		
		while (true) {
				int fact = 1;
				System.out.println("누적 승을 구할 정수를 입력하시오.");
				num = sc.nextInt();
				System.out.println("================================");
				System.out.printf("%5s%25s\n","num", "1부터 num까지의 곱");
				System.out.println("================================");
				
				for(int i = 1; i<=num; i++) {

				System.out.printf("%5s%20s\n", i, fact = fact*i);}

				System.out.println("계속 하시겠습니까?(y/n)");
				sc.nextLine();
				
				char ans = sc.nextLine().charAt(0);
					
				
				if (ans == 'n') {
				System.out.println("종료합니다.");
				break;
		}

}
	}
}