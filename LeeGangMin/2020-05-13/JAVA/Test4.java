import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		//����, ����, ö�� ������ �Է¹޾�
		//�� ������ 70�� �̻��̸� '���'
		//�ƴϸ� '���� ��ȸ��' ���ڿ��� ��µǴ� ���α׷� �ۼ�(��, ���ǿ����ڸ� �̿��Ͽ� ����)
		
		int physics;
		int historic;
		int philosophy;
		String pass;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ������ �Է��Ͻÿ� > ");
		physics = sc.nextInt();
		System.out.print("���� ������ �Է��Ͻÿ� > ");
		historic = sc.nextInt();
		System.out.print("ö�� ������ �Է��Ͻÿ� > ");
		philosophy = sc.nextInt();
		
		pass = (physics>=70 && historic>=70 && philosophy>=70) ? "���":"���� ��ȸ��";
		System.out.println(pass);
		
		//=== ��� 2 ===//
//		boolean bool_pass;
//		bool_pass = physics>=70 && historic>=70 && philosophy>=70;
		//��� ��� ��
//		System.out.println(bool_pass? "���":"���� ��ȸ��");
		//��� ��� ��
//		if(bool_pass) {
//			System.out.println("���");
//		}
//		else {
//			System.out.println("���� ��ȸ��");
//		}
		
		//=== ���� ===//
//		���� 70�� �̻��̸� ���, �׷��� ���� ���� ����� ö�� ���� ��� 80�� �̻��̾�� ���
//		pass = physics>=70 ? "���":(historic>=80 && philosophy>=80)? "���" : "���� ��ȸ��";
//		System.out.println(pass);		//pass�� ������ pass�� �����ϴ� ���� �״�� ����ϴ� ���� �־ ��
										//pass ���� �� : (physics>=70 && historic>=70 && philosophy>=70) ? "���":"���� ��ȸ��"
	}
}