import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {
		//���ڸ� �Է¹ް�
		//���ĺ� �빮��, �ҹ���, ����, ��Ÿ���� �� �Է¹ް�
		//�ش� ���°� �������� �˷��ִ� ���α׷�
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է����ּ��� > ");
		char ch = sc.nextLine().charAt(0);
		
		if(ch >= 'A' && ch <= 'Z') System.out.println("�빮�� �Դϴ�");
		else if(ch >= 'a' && ch <= 'z') System.out.println("�ҹ��� �Դϴ�");
		else if(ch >= '0' && ch <= '9') System.out.println("���� �Դϴ�");
		else System.out.println("��Ÿ���� �Դϴ�");
	}
}