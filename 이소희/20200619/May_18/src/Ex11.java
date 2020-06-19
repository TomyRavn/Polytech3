import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		// 원하는 구구단 구하기를 반복한다.
		// 음수를 입력하면 빠져나온다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 구구단을 입력하세요.(종료:음수 입력)");
		
		int a = sc.nextInt();
		int i;

		while(true) {
			for(i=1; i<= 9; i++) 
				System.out.printf("%d * %d = %d\n" , a, i, a*i );
				
				System.out.println("원하시는 구구단을 입력하세요.(종료:음수 입력)");			
				 a = sc.nextInt();
				 
					if( a < 0)
						break;

		}


	}
	}


