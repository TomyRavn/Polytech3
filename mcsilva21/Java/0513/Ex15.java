import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		//A,a,1,��Ÿ����> �Է��� ���ڸ� �״�� �ް� �ٸ� ���� ��Ÿ �����Դϴ�.
		
		System.out.println("�Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);

		
		if(ch>='A' && ch <='Z') {
			System.out.println("�빮���Դϴ�:" + ch);		
		}else if(ch>='a' && ch<='z') {
			System.out.println("�ҹ����Դϴ�:" + ch);
		}else if(ch>='0' && ch<='9') {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("��Ÿ���� �Դϴ�.");
		
	
		}
	}
	
}

