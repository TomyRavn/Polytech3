import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		//���ڸ��� �̷���� ������ ���� ���� ���� �Է� ���� �Ŀ� ������ �ڸ����� �и�
		//�ϰ� �� �ڸ����� ����ϴ� ���α׷��� �ۼ��ϼ���

		Scanner scan = new Scanner(System.in); 	
		System.out.println("������ �Է��Ͻÿ�");
		int A = scan.nextInt();		
		System.out.println("���� �ڸ���:"+ A/100);
		System.out.println("���� �ڸ���:"+ A/100%10);
		System.out.println("���� �ڸ���:"+ A/1%10);
	
			
	}

}


