import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		//��.while ������ �̿��� 5ȸ �ݺ� ���
//		int i = 1;
//		while(i <= 5){
//			System.out.println("HELLO");
//			i++;
//		}
		
		//��.while ������ �̿��� 7�� ���
//		int i = 1;
//		while(i <= 9) {
//			System.out.printf("%d * %d = %d\n", 7, i, 7*i);
//			i++;
//		}
		
		//��.while ������ �̿��� ���ϴ� ������ ���
//		Scanner sc = new Scanner(System.in);

//		System.out.print("���ϴ� �������� �Է��ϼ��� > ");
//		int input = sc.nextInt();
//		int i = 1;
		
//		while(i <= 9) {
//			System.out.printf("%d * %d = %d\n", input, i, input*i);
//			i++;
//		}
		
		//��.while ������ �̿��� 1���� n���� �� ���
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("���ڸ� �Է����ּ��� > ");
//		int number = sc.nextInt();
//		int i = 1;
//		int sum = 0;
//		
//		while(i <= number) {
//			sum += i;
//			i++;
//		}
//		
//		System.out.printf("��ü �� : %d\n", sum);
		
		//��. while(true) ==> ���� ���� ����
//		int i = 1;
//		int sum = 0;
//		
//		while(true) {
//			System.out.println("HELLO");
//			if(i >= 5) break;
//			i++;
//			
//			//== if(i > 5) break;
//			//System.out.println("HELLO");
//			//i++;
//		}
		
		//��. ö�� ������ �߰� ��� ������ ��ü ��� ������ ���Ͻÿ�.
		//�л��ο��� �Է¹޴� ��
		//�� �̻� �Է��� �л��� ������ ������ �Է��� ���� ������ ��������
//		Scanner sc = new Scanner(System.in);
//		
//		int sum = 0;
//		int studentCount = 0;
//		
//		while(true) {
//			System.out.printf("%d��° �л��� ö�� ������ �Է����ּ��� > ", studentCount+1);
//			int philosopy = sc.nextInt();
//			
//			if(philosopy < 0) break;	//���� �Է� �� ���� ���� ��������(��ġ�� ����)
//			
//			sum += philosopy;			//�Էµ� ������ �հ迡 ����
//			studentCount++;				//�л� ���� ������Ŵ(��� �� ��� �� ��¿� ���)
//		}
//		double average = (double)sum / studentCount;
//		System.out.println("=========================================");
//		System.out.printf("ö�� ������ ��ü ��� ������ %.1f��\n�л����� %d���Դϴ�.", average, studentCount);
		
		//��. for ������ �̿��� Hello 5�� ���
//		for(int i = 1; i <= 5; i++) {
//			System.out.println("HELLO");
//		}
		
		//��. for ������ �̿��� 9�� ���
//		for (int i = 1; i <=9; i++) {
//			System.out.printf("%d * %d = %d\n", 9, i, 9*i);
//		}
		
		//��. 1���� n���� ���� ��
//		Scanner sc = new Scanner(System.in);
//		//�Է¹���
//		System.out.print("�հ踦 ���� ���� �Է����ּ��� > ");
//		int number = sc.nextInt();
//		//�հ� ����
//		int sum = 0;
//		//�ݺ���(n���� �հ�)
//		for (int i = 1; i <= number; i++) {
//			sum += i;
//		}
//		//�հ� ���
//		System.out.println(sum);
		
		//��. ���� �ݺ��Ǵ� ������ ���
		//���� �� �� �ݺ��� ����
		Scanner sc = new Scanner(System.in);
		
		for(;;) {	//== while(true)
			System.out.print("�������� ����� ���ڸ� �Է����ּ��� > ");
			int number = sc.nextInt();
			
			if(number < 0) {
				System.out.println("���α׷� ���� ");
				break;
			}
			
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", number, i, number * i);
			}
			
			System.out.println("=================================");
		}
	}
}