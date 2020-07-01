package ex02;

import java.util.Scanner;

public class GoodClac extends Calculator{

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int substract(int a, int b) {
		return a - b;
	}

	@Override
	public double average(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum/a.length;
	}
	
	
	public static void menu() {
		System.out.println("1.덧셈 2.뺄셈 3.평균 4.종료 >> ");

	}

	
	public static void main(String[] args) {
		Calculator g = new GoodClac() ;
		Scanner s = new Scanner(System.in);
		
		while(true) {
			menu();
			
			int n = s.nextInt();
			if (n == 4) {
				System.out.println("프로그램 종료합니다.");
				return;
			}
			
			if (n < 1 || n > 4) {
				System.out.println("존재하지 않는 항목입니다. 다시 입력하세요.");
				continue;
			}
			
			System.out.println("첫 번째 숫자를 입력하시오.");
			int a = s.nextInt();
			System.out.println("두 번째 숫자를 입력하시오.");
			int b = s.nextInt();
			int result = 0;
			
			
			switch(n) {
			case 1: System.out.println("결과: " + g.add(a, b)); break;
			case 2: System.out.println("결과: " + g.substract(a, b)); break;
			case 3: System.out.println("처리할 항목의 개수: ");
			int m = s.nextInt();
			int[] arr = new int[m];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}
				
			System.out.println("결과: " + g.average(arr)); break;
			}
			
		}
			
	}

}
