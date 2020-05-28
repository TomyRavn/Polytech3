import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("과세 표준을 입력하세요."); 
		int num1 = scan.nextInt();
		// double tax; // 변수를 선언해서 출력하기.
		
		if(num1<=1000)
			System.out.printf("소득세 :%.0f만원입니다.\n", num1*0.08);
		if(num1>1000 && num1<= 4000)
			System.out.printf("소득세 :%.0f만원입니다.\n", num1*0.17);
		if(num1>4000 && num1<= 8000)
			System.out.printf("소득세 :%.0f만원입니다.\n", num1*0.26);
		if(num1>8000)
			System.out.printf("소득세 :%.0f만원입니다.\n", num1*0.35);

	}

}
