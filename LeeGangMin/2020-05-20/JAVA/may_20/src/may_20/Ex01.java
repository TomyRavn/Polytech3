package may_20;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
//		int i = 1;
//		
//		//1.
//		do {
//			System.out.println("HELLO");
//			i++;
//		}while(i<=5);						//do while ���������� while ���� ���ǽ� �ڿ� �����ݷ� �ʿ�
		
		
		//2.
//		int sum = 0;
//		
//		do {
//			sum += i;
//			i++;
//		}while(i<=10);
//		
//		System.out.printf("���� %d�Դϴ�.", sum);
		
		//3. ���� ������ �Է¹޴ٰ� ���� �Է¹����� ���ѷ��� ����
		Scanner sc = new Scanner(System.in);
//		int history;
//		double average;
//		int sum = 0;
//		int count = 0;
//		//do while�� ������ 1ȸ ����Ǵ� Ư��
//		//(1)
//		do {
//			System.out.print("������ �Է����ּ��� > ");
//			history = sc.nextInt();			
//			if(history >= 0) {
//				sum += history;
//				count ++;
//			}
//		} while(history >= 0);
//		//(2)
////		do {
////			System.out.print("������ �Է����ּ��� > ");
////			history = sc.nextInt();
////			
////			if(history < 0) break;
////			
////			sum += history;
////			count ++;
////		} while(true);
//		
//		average = (double)sum / count;
//		System.out.printf("��� ������ %.1f\n �л� ���� %d\t �հ� ������ %d�Դϴ� ", average, count, sum);
		
		//4. �޴��� 1�� 2���� �ƴϸ� ��� ��������
//		int menu;
//		do {
//			System.out.println("1. ���Ͽ���");
//			System.out.println("2. ��������");
//			System.out.print("�޴� ���� >> ");
//			menu = sc.nextInt();
//		} while(!(menu>=1 && menu<=2));	//(menu<1||menu>2)
		
		//5. Ư�� ���� �Է¹޴µ� 1~12���� �ƴ� �ٸ� ���� �Է����� �� �ٽ� �Է¹޵��� ����
		System.out.println("�� ���ΰ���?");
		int year = sc.nextInt();
		int days;
		int month;
		
		//(1)
		do {
			System.out.println("������ ����� ���� �Է����ּ���");
			month = sc.nextInt();
		
			switch (month) {
			case 2: if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) days = 29; //���� �϶� 2���� 29��
					else days = 28; break; //����� 28��
								
			case 4: case 6: case 9: case 11: days = 30; break;
			default: if(month <= 12) days = 31;
					 else { days = 0;	//�߸��� �� �Է½� 0�Ϸ� ����ó��
					 	System.out.println("�ٽ� �Է��ϼ���");
					 }
			}
			
		}while(days <= 0);
		
		System.out.printf("�Է��� \"%d��\"�� \"%d��\"���� �ֽ��ϴ�.\n", month, days);
		
		//(2)
//		do {
//			System.out.println("������ ����� ���� �Է����ּ���");
//			month = sc.nextInt();
//		
//			if(!(month>=1 && month <=12)) System.out.println("�ٽ� �Է��ϼ���");
//			else break;
//			
//		}while(true);
//		
//		switch (month) {
//		case 2: if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) days = 29; //���� �϶� 2���� 29��
//				else days = 28; break; //����� 28��
//							
//		case 4: case 6: case 9: case 11: days = 30; break;
//		default: if(month <= 12) days = 31;
//		
//		System.out.printf("�Է��� \"%d��\"�� \"%d��\"���� �ֽ��ϴ�.\n", month, days);
	}
}