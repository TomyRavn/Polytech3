import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// 윤년은 4로 나누어 떨어지고, 100으로 나누어 떨어지지 않음.
		// 혹은 400으로 나누어 떨어지는 연도가 윤년이 된다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("연도 입력>>");
		int year = sc.nextInt();
			
		//산술 > 관계 > 논리 연산자 순으로 실행된다.
		//왼쪽에서 오른쪽 순서로 실행된다.
		//boolean bool = ((year % 4 == 0) && (year % 100 !=0)) || (year % 400 == 0;)
		boolean bool = year % 4 == 0 && year % 100 !=0 || year % 400 == 0;
		System.out.println(bool);
		
		
//		boolean result = (year % 4) == 0;
//		boolean result2 = (year % 100) != 0;
//		boolean result3 = (year % 400) == 0;
//		boolean result4 = result && result2 || result3;
//		
//		System.out.println(result4);

	}

}
