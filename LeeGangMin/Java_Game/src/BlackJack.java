import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] cardNumArray = new int[13][4];
		String[] patternArray = {"♥", "◆", "♣", "♠"};
		String[][] card = new String[13][4];
		
		//카드 부여(초기화) (A//,2,3,4,5,6,7,8,9,10,J,Q,K,//A)
		//(1) 카드 숫자 부여 및 카드 빈장으로 초기화
		for(int i = 0 ; i < 13; i++) {
			
			for(int j = 0 ; j < 4; j++)
			{
				cardNumArray[i][j] = i + 1;
				card[i][j] = "";
			}
			
		}
		
		//(2) 카드 문양 부여
		for(int i = 0; i < 13; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				switch(j) {
				case 0:
					card[i][j] += "♥";
					break;
				case 1:
					card[i][j] += "◆";
					break;
				case 2:
					card[i][j] += "♣";
					break;
				case 3:
					card[i][j] += "♠";
					break;
				}
				
			}
			
		}
		
		//(3) 카드 일부 숫자 알파벳화
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
		
		//게임시작
		//조건1. 컴퓨터와 유저 카드는 겹치지 않는다.
		//조건2. 뽑은 카드는 게임이 끝날때까지 재사용되지 않는다.
		//조건3. 유저는 카드를 더받을지, 멈출지 선택할 수 있다.(Hit / Stand)
		//조건4. J,Q,K는 모두 10이다. A는 1과 11로 사용될 수 있다.
		//조건5. 컴퓨터나 유저 중 카드 합이 21이 나올 시 즉시 게임이 종료되며, 해당 측의 승리가 된다.(BlackJack)
		//		(이 때 동률이면 무승부)
		//조건6. 컴퓨터나 유저 중 카드 합이 21을 초과할 경우 즉시 게임이 종료되며, 해당 측의 패배가 된다.(Burst)
		
		while(true) {
			//컴퓨터 카드 뽑음
			int comNum = (int)(Math.random() * 12);
			int comPat = (int)(Math.random() * 3);
			//유저 카드 뽑음
			int userNum = (int)(Math.random() * 12);
			int userPat = (int)(Math.random() * 3);
			
			String comCard = card[comNum][comPat];
			String userCard = card[userNum][userPat];
			
			System.out.printf("딜러 : %s\n", comCard);
			System.out.printf("유저 : %s", userCard);
			
			break;
		}
		
//		//출력
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