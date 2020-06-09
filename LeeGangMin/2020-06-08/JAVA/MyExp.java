import java.util.Scanner;

public class MyExp {
	int base;
	int exp;

	public MyExp() {
		
	}
	
	public MyExp(int x, int y) {
		base = x;
		exp = y;
	}


	public int getValue() {
		int n = 1;

		for(int i = 0; i < exp; i++) {
			n *= base;
		}

		return n;
	}
	
	public static void main(String[] args) {
		//1.
//		MyExp myExp = new MyExp();
//		myExp.base = 2;
//		myExp.exp = 5;
		
		//2.
//		MyExp myExp = new MyExp(2, 5);
		
		//3.
		Scanner sc = new Scanner(System.in);
		System.out.print("아래 정수 값은 ? ");
		int num = sc.nextInt();
		System.out.print("지수 값은? ");
		int exp = sc.nextInt();
		
		MyExp myExp = new MyExp(num, exp);
		
		System.out.printf("%d^%d = %d ", num, exp, myExp.getValue());
	}
}