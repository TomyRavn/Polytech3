package may_20;
import java.util.Scanner;

public class ExtraSample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		char ans;
		
		while(true) {
			System.out.println("1. ����������");
			System.out.println("2. ��Ʈ����");
			System.out.print("\n���� ����>> ");
			n = sc.nextInt();
			
			System.out.print("\n������ ����Ͻðڽ��ϱ�(y/n)?");
			sc.nextLine();	//���۸� ����ִ� �뵵(scanner Ÿ���� �޶��� �� enter�Է��� �������� �����("���Ͱ� �Էµ� ���� �����"))
			ans = sc.nextLine().charAt(0);
			
			if(ans == 'n') {
				System.out.println("������ �����մϴ�.\n");
				break;
			}
			
		}
	}
}