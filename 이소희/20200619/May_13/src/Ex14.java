import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		//Q3> 키와 몸무게를 입력 받아, 정상인지 비만인지 출력하는 프로그램을 작성하시오.
		// 키에 따른 표준 체중을 구하는 방법은 신장(키)에서 100을 빼고, 그 값에  0.9를 곱하여 표준 체중을 구하면 된다.
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("키를 입력 하시오.");
//		int a = sc.nextInt();
//		System.out.println("몸무게를 입력 하시오.");
//		int b = sc.nextInt();
//		
//		double result = (a-100)*0.9;
//		
//		if(b <= result) System.out.println("정상 체중입니다.");
//		else System.out.println("비만입니다.");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("키를 입력 하시오.");
		double a = sc.nextDouble();
		System.out.println("몸무게를 입력 하시오.");
		double w = sc.nextDouble();
		
		double result = (a-100)*0.9;
		
		if(result < w) 
			System.out.println("비만입니다.");
		else if 
			(w >= result - 5 && w <= result + 5) System.out.println("표준 체중입니다.");
		else 
			System.out.println("저체중입니다.");
		

	}

}
