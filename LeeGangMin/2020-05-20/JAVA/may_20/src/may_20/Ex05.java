package may_20;
import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		//����ڰ� �Է��� ��� ���� ���鿡 ����
		//1���� �� ���������� ���� ���� ����ϴ� ���α׷�(���丮��)
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true)
		{
			int result = 1;
			String inputRetry = "";
			
			System.out.print("������ ������ �Է����ּ��� > ");
			int num = sc.nextInt();
		
			System.out.println("================================");
			System.out.println("  n \t1���� n������ ��        ");				//"%5s%30s\n", "n", "1���� n������ ��"
			System.out.println("================================");
			
		
			for(int i = 1; i <= num; i++) {
				result *= i;
				System.out.printf("  %d \t%d\n", i, result);
			}
			
			//������� ����
			while(true) {
				//������� ���� �Է�
				System.out.println("��� �Ͻðڽ��ϱ�? (Y/N)");
				sc.nextLine();
				inputRetry = sc.nextLine();
				//Y,N,y,n(��ҹ���) �Է� �� ������ ��������
				if(inputRetry.equals("N")||inputRetry.equals("Y")||inputRetry.equals("n")||inputRetry.equals("y")) break;
				//�ƴ� �� �ٽ� �Է�
				else {System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");}
			}
			
			//����� �� �Է½� ���ǿ� �´� ����
			if(inputRetry.equals("N")||inputRetry.equals("n")) {
				System.out.println("�����մϴ�.");break;
			}
		}
	}
}