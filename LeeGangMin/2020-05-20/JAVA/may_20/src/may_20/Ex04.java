package may_20;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		//������ ���� ������ �ݺ� �Է¹޾�
		//�� �߿� ��ü ¦���� ������ ����ϰ�
		//���� �Է½� �ݺ��� ���������� ���α׷�
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int countEven = 0;
		
		
		while(true) {
			System.out.print("�Է��Ͻÿ� [������('�����Է�')] > ");
			num = sc.nextInt();
			
			if(num < 0) break;
			if(num != 0 && num % 2 == 0) countEven++;
		}
		System.out.printf("¦�� ���� : %d", countEven);
	}
}