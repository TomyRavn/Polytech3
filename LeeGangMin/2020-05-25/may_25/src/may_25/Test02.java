package may_25;

import java.util.Scanner;

//cf. �ڵ� �ۼ� �� �����丵(�ߺ� �ּ�ȭ, �ڵ� ����ȭ) �ʿ�

public class Test02 {
	//���α׷� �����ϴ� ���� �޼ҵ�
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int result = 0;

		while(true) {
			//��� �޼ҵ� menu
			menu();
			
			System.out.print("\n�޴� ����>>");
			int input = sc.nextInt();
			int x = 0;
			int y = 0;
			
			//5�Է� �� �ٷ� ����
			if(input == 5) {
				System.out.println("���α׷� ����");
				return;
			}
			
			//�ٸ� �� �Է� �� �����Է� ���� �ʰ� ����
			if(input >= 1 && input <= 4) {
				System.out.println("����1 �Է�>>");
				x = sc.nextInt();
				System.out.println("����2 �Է�>>");
				y = sc.nextInt();
			}
			
			//�� �Է½� ����(add, sub, mul, div �޼ҵ� ����)
			//�ٸ� �� �Է½� �ٽ� �Է��ϵ��� ��¹� ����ϰ� �Ʒ� �ڵ带 �������� �ʰ� �ٽ� �ݺ��� ó������ ���ư�
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
				System.out.println("������ ���� ���Դϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
			
			//�ٸ� ���� �Է¹ްų� 5�Է½� ��µ��� ����
			System.out.printf("��� ��� : %d\n", result);
		}
	}

	///////////////////////////////////////////////////////////////////
	//== ���� �޼ҵ� �� �ٸ� �޼ҵ� ���� ==//
	//������ ��� ���� �޼ҵ�
	public static void menu() {
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ������");
		System.out.println("5. ����");
	}
	
	//��Ģ���� �޼ҵ�
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