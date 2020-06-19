import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		//세 자리로 이루어진 십진수 양의 정수 값을 입력 받은 후에 각각의 자릿수를 분리하고 이 자릿수를 출력하는 프로그램을 작성하세요.
		//정수를 입력하시오:378 백의 자리 수:3 십의 자리 수:7 일의 자리 수:8
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int a = sc.nextInt();
//		System.out.println("백의 자리 수:" + a/100);
//		System.out.println("십의 자리 수:" + a/10%10);
//		System.out.println("일의 자리 수:" + a%10);
		
		
		System.out.printf("백의 자리 수:%d\n", a/100);
		System.out.printf("십의 자리 수:%d\n", a/10%10);
		System.out.printf("일의 자리 수:%d\n", a%10);

	}

}
