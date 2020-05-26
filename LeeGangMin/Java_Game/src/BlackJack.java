import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] cardNumArray = new int[13][4];
		String[] patternArray = {"��", "��", "��", "��"};
		String[][] card = new String[13][4];
		
		//ī�� �ο�(�ʱ�ȭ) (A//,2,3,4,5,6,7,8,9,10,J,Q,K,//A)
		//(1) ī�� ���� �ο� �� ī�� �������� �ʱ�ȭ
		for(int i = 0 ; i < 13; i++) {
			
			for(int j = 0 ; j < 4; j++)
			{
				cardNumArray[i][j] = i + 1;
				card[i][j] = "";
			}
			
		}
		
		//(2) ī�� ���� �ο�
		for(int i = 0; i < 13; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				switch(j) {
				case 0:
					card[i][j] += "��";
					break;
				case 1:
					card[i][j] += "��";
					break;
				case 2:
					card[i][j] += "��";
					break;
				case 3:
					card[i][j] += "��";
					break;
				}
				
			}
			
		}
		
		//(3) ī�� �Ϻ� ���� ���ĺ�ȭ
		for(int i = 0; i < 13; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				switch(cardNumArray[i][j]) {
				case 1: card[i][j] += "A"; 
					break;
				case 11: card[i][j] += "J";
					break;
				case 12: card[i][j] += "Q";
					break;
				case 13: card[i][j] += "K";
					break;
				default: card[i][j] += cardNumArray[i][j]; 
				
				}
			}
			
		}
		
		//���ӽ���
		//����1. ��ǻ�Ϳ� ���� ī��� ��ġ�� �ʴ´�.
		//����2. ���� ī��� ������ ���������� ������� �ʴ´�.
		//����3. ������ ī�带 ��������, ������ ������ �� �ִ�.(Hit / Stand)
		//����4. J,Q,K�� ��� 10�̴�. A�� 1�� 11�� ���� �� �ִ�.
		//����5. ��ǻ�ͳ� ���� �� ī�� ���� 21�� ���� �� ��� ������ ����Ǹ�, �ش� ���� �¸��� �ȴ�.(BlackJack)
		//		(�� �� �����̸� ���º�)
		//����6. ��ǻ�ͳ� ���� �� ī�� ���� 21�� �ʰ��� ��� ��� ������ ����Ǹ�, �ش� ���� �й谡 �ȴ�.(Burst)
		
		while(true) {
			//��ǻ�� ī�� ����
			int comNum = (int)(Math.random() * 12);
			int comPat = (int)(Math.random() * 3);
			//���� ī�� ����
			int userNum = (int)(Math.random() * 12);
			int userPat = (int)(Math.random() * 3);
			
			String comCard = card[comNum][comPat];
			String userCard = card[userNum][userPat];
			
			System.out.printf("���� : %s\n", comCard);
			System.out.printf("���� : %s", userCard);
			
			break;
		}
		
//		//���
//		for(int i = 0; i < 13; i++) {
//			
//			for(int j = 0; j < 4; j++)
//			{
//				System.out.printf("%s", card[i][j]);
//			}
//			System.out.println();
//			
//		}
		
	}
}