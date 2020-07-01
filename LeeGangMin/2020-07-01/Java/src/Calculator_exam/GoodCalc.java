package Calculator_exam;

import java.util.Scanner;

public class GoodCalc extends Calculator{
	
	public static void menu() {
		System.out.println("=========================");
		System.out.println("    1. ADD      [+]");
		System.out.println("    2. SUBTRACT [-]");
		System.out.println("    3. AVERAGE");
		System.out.println("    4. EXIT");
		System.out.println("=========================");
	}
	
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
		return ((double)sum) / a.length;
	};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Calculator cal = new GoodCalc();
		
		while (true) {
			int result = 0;
			double dResult = 0;
			int x = 0;
			int y = 0;
			int num = 0;
			int[] su = null;
			
			menu();
			int input = sc.nextInt();
			
			
			if(input == 4)
			{
				System.out.println("���α׷� ����");
				break;
			}
			
			if(input > 4 || input < 1) {
				System.out.println("�߸��� �Է�, �ٽ� �Է�");
				continue;
			}
			
			//////////
			
			if (input == 1 || input == 2) {
				
				System.out.print("�ǿ�����1 > ");
				x = sc.nextInt();
				System.out.print("�ǿ�����2 > ");
				y = sc.nextInt();
				
			}else if(input == 3){
				
				System.out.println("ó���� �׸��� ���� > ");
				num = sc.nextInt();
				su = new int[num];
				
				for (int i = 0; i < su.length; i++) {
					System.out.printf("���� %d:", i+1);
					su[i] = sc.nextInt();
				}
				
			}
			
			
			System.out.println("-------------------------");
			
			switch (input) {
			case 1: result = cal.add(x, y); System.out.printf("��� : %d\n", result); break;
			case 2: result = cal.substract(x, y); System.out.printf("��� : %d\n", result); break;
			case 3: dResult = cal.average(su); System.out.printf("��� : %.1f\n", dResult); break;
			}
			
			
		}
	}
	
}