import java.util.Scanner;

public class MyExp {

//	클래스 MyExp를 작성하라.
//	
//	MyExp는 지수값을 표현하는 클래스로서
//	두 개의 정수형 멤버 필드 base와 exp를 가진다.
//	
//	2의 3승의 경우 base는 2이며, exp는 3이다.
//	base와 exp는 양의 정수만을 가지는 것으로 가정한다.
//	 
//	또한 MyExp는 정수값을 리턴하는 
//	getValue()라는 메소드를 제공한다.
//	
//	getValue()는 base와 exp 값으로부터 지수를 계산하여
//	정수 값으로 리턴한다.

	int base, exp;

	public MyExp(int x, int y) {
		base = x;
		exp = y;
	}

	public int getValue() {
		int f = 1;
		for (int i = 0; i < exp; i++)
			f *= base;

		return f;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("밑의 값은?");
		int a = sc.nextInt();

		System.out.println("지수의 값은?");
		int b = sc.nextInt();

		MyExp ok = new MyExp(a, b);

		System.out.printf("%d의 %d승은 %d입니다.\n", a, b, ok.getValue());

	}

}
