import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//���� Ư�� ������ 4�� ������ ��������, 100���δ� ������ �������� �ʴ� ����
		//Ȥ�� 400���� ������ �������� ���� 
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("������ �Է��ϼ���.");
		int year = scan.nextInt();
	
		boolean result1 = (year %  4 == 0) && (year %  100 !=0) || (year%  400 ==0);	
		System.out.println(result1);				
	}
}
