import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 	
		
		System.out.println("���ڸ� �Է��ϼ���");
		int x = scan.nextInt();
		
		System.out.println("���ڸ� �Է��ϼ���");
		int y = scan.nextInt();
		
		int result = x/y;
		
		if(y == 0) {
			System.out.println("�Է¿���");
			System.out.println("0�� �и� ���Ұ�!!");
			
		} else {
				System.out.println("�������� �����ϼ���");
				System.out.print(result);
		
	}

}
}
