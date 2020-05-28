package may_25;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.println(">>MENU");
			System.out.print("(1) 약수 출력  (2) 소수 판단  (3) 종료  [ 메뉴 선택 ]: ");
			int input = sc.nextInt();
			
			if(input == 3) {
				System.out.println("프로그램 종료");
				return;
			}
			
			if(!(input >= 1 && input <= 3)) {
				System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
				continue;
			}
			
			System.out.println("임의의 정수 입력 : ");
			int num = sc.nextInt();
			
			switch(input) {
			case 1:
				printDivisor(num);
				break;
			case 2:
				printPrimeNumber(num);
				break;
			}
			System.out.println();
		}

	}
	///////////////////////////////////////////////////////////////
	public static void printDivisor(int x) {
		
		for(int i = 1; i <= x; i++) {
			if(x % i == 0) {
				System.out.printf("%4d", i);
			}
		}
		
	}
	
	public static void printPrimeNumber(int x) {
		int count = 0;
		
		for(int i = 1; i <= x; i++) {
			if(x % i == 0) {
				count++;
			}
		}
		
		if(count == 2) {
			System.out.printf("%d는 소수입니다", x);
		}
		else {
			System.out.printf("%d는 소수가 아닙니다!!", x);
		}
		
		//2.
//		int i;
//		for(i = 2; i < x; i++) {	//1과 자기자신을 제외한 조건
//			if(x % i == 0) break;
//		}							//for loop가 break되지 않을 시 i == x 가 되어서 for loop를 빠져나옴 -> 이 때 x는 소수
//		
//		if(i == x) {
//			System.out.printf("%d는 소수입니다", x);
//		}
//		else {
//			System.out.printf("%d는 소수가 아닙니다!!", x);
//		}
	}
}