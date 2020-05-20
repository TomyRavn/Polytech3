package may_20;
import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		//사용자가 입력한 모든 정수 값들에 대해
		//1부터 그 정수까지의 누적 승을 출력하는 프로그램(팩토리얼)
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true)
		{
			int result = 1;
			String inputRetry = "";
			
			System.out.print("임의의 정수를 입력해주세요 > ");
			int num = sc.nextInt();
		
			System.out.println("================================");
			System.out.println("  n \t1부터 n까지의 곱        ");				//"%5s%30s\n", "n", "1부터 n까지의 곱"
			System.out.println("================================");
			
		
			for(int i = 1; i <= num; i++) {
				result *= i;
				System.out.printf("  %d \t%d\n", i, result);
			}
			
			//계속할지 여부
			while(true) {
				//계속할지 여부 입력
				System.out.println("계속 하시겠습니까? (Y/N)");
				sc.nextLine();
				inputRetry = sc.nextLine();
				//Y,N,y,n(대소문자) 입력 시 루프를 빠져나감
				if(inputRetry.equals("N")||inputRetry.equals("Y")||inputRetry.equals("n")||inputRetry.equals("y")) break;
				//아닐 시 다시 입력
				else {System.out.println("잘못된 입력입니다. 다시 입력해주세요.");}
			}
			
			//제대로 된 입력시 조건에 맞는 실행
			if(inputRetry.equals("N")||inputRetry.equals("n")) {
				System.out.println("종료합니다.");break;
			}
		}
	}
}