import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. ��Ʈ�� �� 2���� ������ ��츦 �����Ͽ� ������ ���
//		System.out.print("����� ������ (KOREA(1) / ETC(2))? ");
//		int c = sc.nextInt();
//		System.out.print("����� ������ (MALE(3) / FEMALE(4))? ");
//		int g = sc.nextInt();
//		String str1, str2;
//		str1 = str2 = "";
//		
//		if(c == 1) {
//			str1 = "�ѱ� ";
//		}else if(c == 2) {
//			str1 = "�ؿ� ";
//		}
//		if(g == 3) {
//			str2 = "����";
//		}else if(g == 4) {
//			str2 = "����";
//		}
//		System.out.println("����� " + str1 + str2 + "�Դϴ�.");
		
		//2. ��Ʈ�� �� 1���� ���ǿ� ���� ���ڿ��� �߰��ϴ� ������� ���
//		String str = "";
//		System.out.print("����� ������ (KOREA(1) / ETC(2))? ");
//		int info = sc.nextInt();
//		
//		if (info == 1) {
//			str += "�ѱ� ";
//		} else if(info == 2) {
//			str += "�ؿ� ";
//		}
//		
//		System.out.print("����� ������ (MALE(3) / FEMALE(4))? ");
//		info = sc.nextInt();
//		
//		if (info == 3) {
//			str += "����";
//		} else if(info == 4) {
//			str += "����";
//		}
//		
//		System.out.println("����� " + str + "�Դϴ�.");
		
		//3. ��ø if������ �ش� ���� �����ϴ� ��� �ٷ� ���
		System.out.print("����� ������ (KOREA(1) / ETC(2))? ");
		int c = sc.nextInt();
		System.out.print("����� ������ (MALE(3) / FEMALE(4))? ");
		int g = sc.nextInt();
		
		//final int KOR = 1;
		//final int ETC = 2;
		//final int MALE = 3;
		//final int FEMALE = 4;	==> �������� ���� ���ڸ� ���ڷ� ����(���Ŀ� KOR, ETC, MALE, FEMALE�� 1,2,3,4 ��� �� �� ����)
		
		if(c==1) {
			if(g==3) System.out.println("����� �ѱ� �����Դϴ�.");
			else System.out.println("����� �ѱ� �����Դϴ�.");
		}
		else {
			if(g==3) System.out.println("����� �ؿ� �����Դϴ�.");
			else System.out.println("����� �ؿ� �����Դϴ�.");
		}
	}
}