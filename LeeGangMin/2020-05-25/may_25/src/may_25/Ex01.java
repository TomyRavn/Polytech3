package may_25;

import java.util.Scanner;

public class Ex01 {
	
	//프로그램의 구동(실행)을 위해서 존재하는 메소드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//메소드 : 하나의 기능을 수행하는 하나의 독립된 프로그램
		//만들어놓고 사용할 때 호출

		//1.
//		test(5);
//		
//		System.out.println("프로그램 끝!!");
		
		//2.
		int add = sum(10, 80);
		System.out.printf("합의 결과 : %d\n", add);
	}
	
	///////////////////////////////////////////////////////
	public static void test(int num) {
		
		for(int i = 0 ; i < num; i++) {
			System.out.println("Hello Test~~");	
		}
		
	}
	//////////////////////////////////////////////////////
						//int x, int y는 매개변수
	public static int sum(int x, int y) {
		return x + y;
	}
}