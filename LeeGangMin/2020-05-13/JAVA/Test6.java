import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		//� ���� �Է¹޾Ƽ� ¦������ Ȧ������ �����Ͽ� ����س��� if�� �ۼ�
		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.println("������ ���� �Է�>> ");
		int x = sc.nextInt();
		
		if(x % 2 == 0) {
		System.out.println("¦��");					//�ش� ���� �̸� ���
		} else {
			System.out.println("Ȧ��");				//������ �������� �ʴ� ��� ���
		}
		System.out.printf("�Է¹��� ���� %d�Դϴ�.", x);	//������ ���
		
	}
}