package may_20;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		//���� ���� �� ���� ���������� �÷���
		Scanner sc = new Scanner(System.in);
		
		int com = (int)(Math.random() * 3 + 1);	//��ǻ�� 1~3���� ���� �̱�
		
		//1,2,3�� ���ǻ� SCIS, ROCK, PAPE ��� ���ڷ� final����� ����
		final int SCIS = 1;
		final int ROCK = 2;
		final int PAPE = 3;
		
		//���ӽ���
		while(true){
			String inputRetry = "";		//����� ����(y,n) �Է¹��� ���� �ʱ�ȭ
			String comStr="�� : ";		//��ǻ�Ͱ� ������ �´��� �˷��� ����
			String userStr="�� : ";		//���� ������ �´��� �˷��� ����
			String result="";			//�º� ����� �˷��ֱ� ���� ����
			int user;					//������ �Է��� ��(����, ����, ��)
			
			while(true) {
				//����, ����, �� �Է�
				System.out.println("����(1) ����(2) ��(3) : ");
				user = Integer.parseInt(sc.nextLine());
				//���� ����� �Էµ� ��� ������ ���� ����
				if(user >= 1 && user <= 3) break;
				//����, ����, ��(1~3)�� �ƴ� �ٸ� ���� �Է��� ��� �ٽ� �Է�
				else System.out.println("�ٽ� �Է��ϼ���");
			}
			
			//1,2,3�� ���� "����, ����, ��"�� ��µǰ� ����
			//(1) com
			if(com == SCIS) comStr += "����";
			else if(com == ROCK) comStr += "����";
			else if(com == PAPE) comStr += "��";
			//(2) user
			if(user == SCIS) userStr += "����";
			else if(user == ROCK) userStr += "����";
			else if(user == PAPE) userStr += "��";
			//���
			System.out.println(comStr);
			System.out.println(userStr);
			
			//���������� �º� ���� ����
			switch(com) {
				case SCIS:
					result = user == SCIS? "�����ϴ�"
							:user == ROCK? "�̰���ϴ�":"�����ϴ�";
					break;
				case ROCK:
					result = user == SCIS? "�����ϴ�"
							:user == ROCK? "�����ϴ�":"�̰���ϴ�";
					break;
				case PAPE:
					result = user == SCIS? "�̰���ϴ�"
							:user == ROCK? "�����ϴ�":"�����ϴ�";
					break;
			}
			//����� ���
			System.out.println(result);
			System.out.println("---------");
			
			//���� ������� ����
			while(true) {
				//������� ���� �Է�
				System.out.println("������ ��� �Ͻðڽ��ϱ�? (Y/N)");
				inputRetry = sc.nextLine();
				//Y,N,y,n(��ҹ���) �Է� �� ������ ��������
				if(inputRetry.equals("N")||inputRetry.equals("Y")||inputRetry.equals("n")||inputRetry.equals("y")) break;
				//�ƴ� �� �ٽ� �Է�
				else {System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");}
			}
			
			//����� �� �Է½� ���ǿ� �´� ����
			if(inputRetry.equals("N")||inputRetry.equals("n")) {
				System.out.println("������ �����մϴ�.");break;
			}
			else {
				System.out.println("������ ������մϴ�.");
				System.out.println("======================");
			}
			
		}
	}
}