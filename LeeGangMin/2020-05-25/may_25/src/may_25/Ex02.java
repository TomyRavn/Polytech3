package may_25;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.println(">>MENU");
			System.out.print("(1) ��� ���  (2) �Ҽ� �Ǵ�  (3) ����  [ �޴� ���� ]: ");
			int input = sc.nextInt();
			
			if(input == 3) {
				System.out.println("���α׷� ����");
				return;
			}
			
			if(!(input >= 1 && input <= 3)) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
			
			System.out.println("������ ���� �Է� : ");
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
			System.out.printf("%d�� �Ҽ��Դϴ�", x);
		}
		else {
			System.out.printf("%d�� �Ҽ��� �ƴմϴ�!!", x);
		}
		
		//2.
//		int i;
//		for(i = 2; i < x; i++) {	//1�� �ڱ��ڽ��� ������ ����
//			if(x % i == 0) break;
//		}							//for loop�� break���� ���� �� i == x �� �Ǿ for loop�� �������� -> �� �� x�� �Ҽ�
//		
//		if(i == x) {
//			System.out.printf("%d�� �Ҽ��Դϴ�", x);
//		}
//		else {
//			System.out.printf("%d�� �Ҽ��� �ƴմϴ�!!", x);
//		}
	}
}