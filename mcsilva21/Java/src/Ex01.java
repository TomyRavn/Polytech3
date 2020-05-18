import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //키워드 입력받기
		System.out.println("정수1 를 입력하세요."); 
		int num1 = scan.nextInt();
		
		System.out.println("정수2 를 입력하세요."); 
		int num2 = scan.nextInt();
		
		int result1 = num1 + num2;
		int result2 = num1 - num2;
		
		System.out.println("두 수의 합 :" + result1);
		if(num1<num2)
			System.out.println("두 수의 차 :" +(num2 - num1));
		if(num1>num2)
			System.out.println("두 수의 차 :" +(num1 - num2));
		

		
		
		

	}

}
