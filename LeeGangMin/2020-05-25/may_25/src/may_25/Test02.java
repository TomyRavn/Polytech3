package may_25;

import java.util.Scanner;

//cf. 코드 작성 시 리팩토링(중복 최소화, 코드 간결화) 필요

public class Test02 {
	//프로그램 구동하는 메인 메소드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int result = 0;

		while(true) {
			//출력 메소드 menu
			menu();
			
			System.out.print("\n메뉴 선택>>");
			int input = sc.nextInt();
			int x = 0;
			int y = 0;
			
			//5입력 시 바로 종료
			if(input == 5) {
				System.out.println("프로그램 종료");
				return;
			}
			
			//다른 값 입력 시 정수입력 받지 않게 설정
			if(input >= 1 && input <= 4) {
				System.out.println("정수1 입력>>");
				x = sc.nextInt();
				System.out.println("정수2 입력>>");
				y = sc.nextInt();
			}
			
			//값 입력시 연산(add, sub, mul, div 메소드 실행)
			//다른 값 입력시 다시 입력하도록 출력문 출력하고 아래 코드를 실행하지 않고 다시 반복문 처음으로 돌아감
			switch(input) {
			case 1: result = add(x,y);
			break;
			case 2: result = sub(x,y);
			break;
			case 3: result = mul(x,y);
			break;
			case 4: result = div(x,y);
			break;
			default:
				System.out.println("허용되지 않은 값입니다. 다시 입력하세요");
				continue;
			}
			
			//다른 값을 입력받거나 5입력시 출력되지 않음
			System.out.printf("계산 결과 : %d\n", result);
		}
	}

	///////////////////////////////////////////////////////////////////
	//== 메인 메소드 밖 다른 메소드 선언 ==//
	//간단한 출력 위한 메소드
	public static void menu() {
		System.out.println("1. 덧셈");
		System.out.println("2. 뺄셈");
		System.out.println("3. 곱셈");
		System.out.println("4. 나눗셈");
		System.out.println("5. 종료");
	}
	
	//사칙연산 메소드
	public static int add(int x, int y) {
		return x + y;
	}
	public static int sub(int x, int y) {
		return x - y;
	}
	public static int mul(int x, int y) {
		return x * y;
	}
	public static int div(int x, int y) {
		return x / y;
	}
}