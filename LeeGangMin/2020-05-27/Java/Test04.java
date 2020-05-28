package may_27;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seatArray = new int[10];	//�¼� ������ �迭
		boolean flag = true;			//while�� ���Ḧ ���� ���Լ�
		
		//��� �¼� 0���� �ʱ�ȭ(���� ���� ����)
		for (int i = 0; i < seatArray.length; i++) {
			seatArray[i] = 0;
		}
		
		//���ѹݺ�
		while(flag) {
			
			printList(seatArray);	//��¿� �Լ�
			
			//����� �Է�
			System.out.print("\n�¼� ����(1~10) :");
			//�Է��� 1~10���� �̷�����Ƿ� -1�� �Ͽ� �ε������� ���� ����
			int seat = sc.nextInt() - 1;
			
			if(seatArray[seat] == 0) {
				seatArray[seat] = 1;
				System.out.println("����Ǿ����ϴ�.");
			}
			else {
				System.out.println("�̹� ����� �¼�, ���� �Ұ�");
				continue;			//�ٽ� ����ȭ�� ���
			}
			
			printList(seatArray);	//��¿� �Լ�
			
			
			//Y,y,N,n �Է��� �ƴ� �� �ݺ��ؼ� �Է¹���
			boolean wrongInput = true;
			sc.nextLine();	//�տ���  int������ �޾ұ� ������ ���� �ǳʶ�
			
			while(wrongInput) {
				System.out.println("����Ͻðڽ��ϱ�?(y/n)?");	
				String input = sc.nextLine();
				wrongInput = false;
				
				switch(input) { 
				case "Y": case "y":
					flag = true;
					break;
				case "N": case "n":
					flag = false;
					break;
				default: wrongInput = true;
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}
			}
		}
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////
	//��� �Լ�
	public static void printList(int[] x) {
		System.out.println("\t\t������ ���� ����");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%4d", i+1);
		}
		System.out.println();
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%4d", x[i]);	
		}
		System.out.println();
		System.out.println("--------------------------------------------");
	}
}