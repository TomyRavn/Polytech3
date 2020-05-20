import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		//세자리로 이루어진 십진수 양의 정수 값을 입력 받은 후에 각각의 자릿수를 분리
		//하고 이 자릿수를 출력하는 프로그램을 작성하세요

		Scanner scan = new Scanner(System.in); 	
		System.out.println("정수를 입력하시오");
		int A = scan.nextInt();		
		System.out.println("백의 자리수:"+ A/100);
		System.out.println("십의 자리수:"+ A/100%10);
		System.out.println("일의 자리수:"+ A/1%10);
	
			
	}

}


