package Calc;

import java.util.Scanner;

public class CalcMain {

	public static void menu() {
		System.out.println("=========================");
		System.out.println("    1. ADD      [+]");
		System.out.println("    2. SUBTRACT [-]");
		System.out.println("    3. MULTIPLY [*]");
		System.out.println("    4. DIVIDE   [/]");
		System.out.println("    5. END");
		System.out.println("=========================");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		while (flag) {

			Calc cal = null;
			int result = 0;
			int x = 0;
			int y = 0;

			menu();
			String op = sc.next();
			
			switch(op) {
			case "1": op = "+"; break;
			case "2": op = "-"; break;
			case "3": op = "*"; break;
			case "4": op = "/"; break;
			case "����" : op = "5"; break;
			}
			
			if(!op.equals("+")&&!op.equals("-")&&!op.equals("*")&&!op.equals("/")&&!op.equals("5"))
			{
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
			
			if (!op.equals("5")) {
				System.out.print("�ǿ�����1 > ");
				x = sc.nextInt();
				System.out.print("�ǿ�����2 > ");
				y = sc.nextInt();
			}
			
			switch (op) {
			case "+": cal = new Add(); break;
			case "-": cal = new Sub(); break;
			case "*": cal = new Mul(); break;
			case "/": cal = new Div(); break;
			case "5":
				flag = false;
				System.out.println("���α׷� ����");
			}
			
			System.out.println("-------------------------");
			
			if (!op.equals("5")) {
				cal.setValue(x, y);
				result = cal.calculate();
				System.out.printf("- ��� : %d %s %d = %d\n", x, op, y, result);
			}
		}
	}

}