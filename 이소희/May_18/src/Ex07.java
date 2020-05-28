import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		//while 반복문 구구단
		
//		int i = 1;
//		
//		while(i <= 9) {
//			System.out.printf("%d * %d = %d\n" , 7, i, 7*i );
//			i++;
//		}
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 구구단 숫자를 입력하세요>>");
		int a = sc.nextInt();
		int i = 1;
		
		while(i <= 9) {
			System.out.printf("%d * %d = %d\n" , a, i, a*i );
			i++;
			
		}
	}
}

