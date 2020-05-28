import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		/*Q4> 사용자로부터 물리, 역사, 철학 점수를 입력받아 세 점수가 70점 이상이면 '통과',
		 그렇지 않으면 '다음 기회에'라는 문자열이 출력되는 프로그램을 작성하시오.
		  단, (조건 연산자를 이용하여 구한다.)*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("물리 점수를 입력하세요.");
		int a = sc.nextInt();
		System.out.println("역사 점수를 입력하세요.");
		int b = sc.nextInt();
		System.out.println("철학 점수를 입력하세요.");
		int c = sc.nextInt();
		
//		if ( (a+b+c)/3 >= 70){ System.out.println("통과");}
//		if ( (a+b+c)/3 < 70){ System.out.println("다음 기회에");}
		
		System.out.println (a >=70 && b >=70 && c >=70? "통과":"다음기회에");



	}
	}
