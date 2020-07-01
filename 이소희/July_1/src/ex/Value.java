package ex;

import java.util.Scanner;

public class Value {
	public static void menu() {
		System.out.println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.종료 >> ");

	}

	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			menu();
			int n = sc.nextInt();

			if (n == 5) {
				System.out.println("프로그램 종료합니다.");
				return;
			}

			if (n < 1 || n > 5) {
				System.out.println("존재하지 않는 항목입니다. 다시 입력하세요.");
				continue;
			}

			System.out.println("첫 번째 숫자를 입력하시오.");
			int a = sc.nextInt();
			System.out.println("두 번째 숫자를 입력하시오.");
			int b = sc.nextInt();
			int result = 0;

			Calc c = null;

			switch (n) {
			case 1:
				c = new Add();
				break;
			case 2:
				c = new Sub();
				break;
			case 3:
				c = new Mul();
				break;
			case 4:
				c = new Div();
				break;
			}

			c.setValue(a, b);
			result = c.calculate();
			System.out.println("결과: " + result);

		}
	}
}
