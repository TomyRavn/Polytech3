import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//������ year�� �Է¹ް�
		//���� ����(4�� ������ �������� 100���� ������ �������� ���� �� Ȥ�� 400���� ������ �������� �⵵�� ����)
		//�����̸� true
		//�������������ڷ�
		Scanner sc = new Scanner(System.in);
		int year;					//����ڿ��� �Է� �޴� ������ ����
		boolean yoonYear = false;	//�������� �ƴ��� �����ϴ� boolean ����
		
		//�⵵ �Է¹޴� �κ�
		System.out.print("�⵵�� �Է��ϼ��� > ");
		year = sc.nextInt();
		
		//���� �������ִ� ���ǽ�
		//1.
		yoonYear = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
		
		//2.
//		if((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
//			yoonYear = true;	//�� 4�� ������ �������� 100���� ������ �������� ���� �� �� �Ǵ� 400���� ������ ������ ��
//		}						//�����̹Ƿ� boolean ������ true�� ����
		
		System.out.println(yoonYear);	//�����̸� true�� ����ϰ�, �ƴϸ� false�� ���
										//�ʱ�ȭ�� false�� �����Ƿ�, ���ǽĿ� �ش����� ������ false�� �⺻ ��µ�
	}
}