import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		//Ư�� ���� �Է¹޾� ������ �� �ϱ��� �ִ��� ó�����ִ� ���α׷�(Switch�� ó��)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ���ΰ���?");
		int year = sc.nextInt();
		System.out.println("������ ����� ���� �Է����ּ���");
		int month = sc.nextInt();
		int days; //��� ����� ���ǿ��� ���� ������ ��� �ʱ�ȭ�� ���ص� ��
		
		switch (month) {
		case 2: if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) days = 29; //���� �϶� 2���� 29��
				else days = 28; break; //����� 28��
				
				//���ǿ�����
				//days = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)? 29:28;
				//break;
				
		case 4: case 6: case 9: case 11: days = 30; break;
		default: if(month <= 12) days = 31;
				 else days = 0;	//�߸��� �� �Է½� 0�Ϸ� ����ó��
		}
		System.out.printf("�Է��� \"%d��\"�� \"%d��\"���� �ֽ��ϴ�.\n", month, days);
	}
}