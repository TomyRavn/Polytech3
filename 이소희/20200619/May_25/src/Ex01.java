import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		//사용자로부터 1부터 50 사이의 숫자 10개를 입력 받아서 숫자만큼의 별표를 출력하는 프로그램을 작성하시오.
		//단, 1~50 사이의 숫자가 아닐 때에는 다시 입력 받도록 한다.
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("숫자를 입력하시오.");
		
	
		for(int i=1; i<=10; i++) {
			System.out.printf("막대 %d의 길이 :" , i);
			int num = sc.nextInt();	

		
			if(num < 0 || num > 51) {
			System.out.println("잘못된 숫자입니다 다시 입력하세요.");
			i--;
			continue;
			}
			
			for(int j=1; j<=num; j++)
			System.out.print("#");
			System.out.println();
			
			
				
		
		}
	}
}

	




		
	

