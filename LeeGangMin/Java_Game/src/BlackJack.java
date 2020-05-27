import java.io.IOException;
import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] cardNumArray = new int[13][4];				//ī�� ���� ��� �迭
		boolean[][] tempNumArray = new boolean[13][4];		//ī�尡 �������� Ȯ�� ���� �迭
		String[][] card = new String[13][4];				//������ �߰��� �������� ī�� �迭
		String[] comCard = new String[10];
		String[] userCard = new String[10];
		
		cardSet(cardNumArray, tempNumArray, card);
		
		//���ӽ���
		//����1. ��ǻ�Ϳ� ���� ī��� ��ġ�� �ʴ´�. --�Ϸ�
		//����2. ���� ī��� ������ ���������� ������� �ʴ´�. --�Ϸ�
		//����3. ������ ī�带 ��������, ������ ������ �� �ִ�.(Hit / Stand)
		//����4. J,Q,K�� ��� 10�̴�. A�� 1�� 11�� ���� �� �ִ�.
		//����5. ��ǻ�ͳ� ���� �� ī�� ���� 21�� ���� �� ��� ������ ����Ǹ�, �ش� ���� �¸��� �ȴ�.(BlackJack)
		//		(�� �� �����̸� ���º�)
		//����6. ��ǻ�ͳ� ���� �� ī�� ���� 21�� �ʰ��� ��� ��� ������ ����Ǹ�, �ش� ���� �й谡 �ȴ�.(Burst)
		
		boolean flag = true;
		boolean secondFlag = true;
		int comNum, comPat, userNum, userPat;

		int cardCount = 52;
		comNum = comPat = userNum = userPat = 0;

		while(flag) {
			
			System.out.println("1.���� ����  2.����");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				
				System.out.println("==== ���� ����!!! ====");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int tempCount = 0;
				
				//
				while(secondFlag) {
					
					boolean duplicate = true;

					while(duplicate) {
						//��ǻ�� ī�� ����
						comNum = (int)(Math.random() * 13);
						comPat = (int)(Math.random() * 4);
						//���� ī�� ����
						userNum = (int)(Math.random() * 13);
						userPat = (int)(Math.random() * 4);

						duplicate = false;

						//=== ī�� ������ ��
						if(cardCount <= 0) {
							System.out.println("ī�� ����");
							break;
						}

						//=== ��ǻ�Ϳ� ���� �ߺ� ����
						if(comNum==userNum && comPat==userPat) {
							duplicate = true;
							continue;
						}

						//=== ���� ī�� �������� ����
						if(tempNumArray[comNum][comPat] || tempNumArray[userNum][userPat]) {
							duplicate = true;
							continue;
						}

						//=== ���� ī�� ���
						tempNumArray[comNum][comPat] = true;
						tempNumArray[userNum][userPat] = true;

						cardCount -= 2;
					}
					
					comCard[tempCount] = card[comNum][comPat];
					userCard[tempCount] = card[userNum][userPat];
					
					printCards(comCard, userCard);

					System.out.println("1.Hit  2.Stand");
					int gameInput = sc.nextInt();
					
					switch(gameInput) {
					case 1: tempCount++;
						break;
					case 2: secondFlag = false;
						break;
					default:
						break;
					}
				}
				
				break;
				
			case 2:
				System.out.println("���� ����");
				flag = false;
				break;
				
			default:
				break;
			}
			
			if(cardCount <= 0) {
				System.out.printf("\nī�尡 �����Ƿ� ������ �����մϴ�.");
				flag = false;
			}

		}

	}
	
	//////////////////////////////////////////////////////////////////
	//ī�带 �迭�� �����ϴ� �Լ�
	public static void cardSet(int[][] cardNumArray, boolean[][] tempNumArray, String[][] card) {
		//ī�� �ο�(�ʱ�ȭ) (A//,2,3,4,5,6,7,8,9,10,J,Q,K,//A)
		//(1) ī�� ���� �ο� �� ī�� �������� �ʱ�ȭ
		for(int i = 0 ; i < 13; i++) {

			for(int j = 0 ; j < 4; j++)
			{
				cardNumArray[i][j] = i + 1;
				card[i][j] = "";
				tempNumArray[i][j] = false;
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
	}
	
	//ī�� ��� �Լ�
	public static void printCards(String comCard[], String userCard[]) {
		System.out.printf("���� : ");
		for(int i = 0; i < comCard.length; i++) {
			if(comCard[i] != null) System.out.printf("%-3s", comCard[i]);
		}
		System.out.printf("\n���� : ");
		for (int i = 0; i < userCard.length; i++) {
			if(userCard[i] != null) System.out.printf("%-3s", userCard[i]);
		}
		System.out.println();
		
		System.out.println("---------------------");
	}
	
	
}