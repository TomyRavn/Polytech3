package may_25;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//����ڷκ��� 1~50������ ���� 10���� �Է¹޾� ���ڸ�ŭ�� ��ǥ�� ����ϴ� ���α׷�
		//1~50�̿��� ���ڴ� �ٽ� �Է�

		Scanner sc = new Scanner(System.in);

//		for(int i = 1; i <= 10; i ++) {
//
//			//System.out.println("1 ~ 50������ ���ڸ� �Է��ϼ���.");
//			System.out.printf("����%d�� ���� : ", i);
//			int num = Integer.parseInt(sc.nextLine());
//
//			if(num >= 1 && num <= 50)
//			{
//				
//				for(int j = 0; j < num; j++) {	
//					System.out.print("*");
//				}
//			}
//			else {
//				System.out.printf("\n������ �ʴ� �����Դϴ�.\n�ٽ� �Է��ϼ���!\n");
//				i--;
//			}
//			System.out.println();
//		}


		//================== ������ �ڵ� =====================//
		for(int j = 1; j <= 10; j++) {
			System.out.printf("���� %d�� ����: ", j);
			int n = sc.nextInt();
			
			if(!(n>=1 && n<=50)) {
				System.out.printf("������ �ʴ� ���Դϴ�.\n�ٽ� �Է��ϼ���.\n");
				j--;
				continue;	//else ��� ������ ������ �Ű� ����
			}
			for(int i = 1; i <= n; i++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}