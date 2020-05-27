import java.io.IOException;
import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] cardNumArray = new int[13][4];				//카드 숫자 담는 배열
		boolean[][] tempNumArray = new boolean[13][4];		//카드가 쓰였는지 확인 위한 배열
		String[][] card = new String[13][4];				//문양이 추가된 최종적인 카드 배열
		String[] comCard = new String[10];
		String[] userCard = new String[10];
		
		cardSet(cardNumArray, tempNumArray, card);
		
		//게임시작
		//조건1. 컴퓨터와 유저 카드는 겹치지 않는다. --완료
		//조건2. 뽑은 카드는 게임이 끝날때까지 재사용되지 않는다. --완료
		//조건3. 유저는 카드를 더받을지, 멈출지 선택할 수 있다.(Hit / Stand)
		//조건4. J,Q,K는 모두 10이다. A는 1과 11로 사용될 수 있다.
		//조건5. 컴퓨터나 유저 중 카드 합이 21이 나올 시 즉시 게임이 종료되며, 해당 측의 승리가 된다.(BlackJack)
		//		(이 때 동률이면 무승부)
		//조건6. 컴퓨터나 유저 중 카드 합이 21을 초과할 경우 즉시 게임이 종료되며, 해당 측의 패배가 된다.(Burst)
		
		boolean flag = true;
		boolean secondFlag = true;
		int comNum, comPat, userNum, userPat;

		int cardCount = 52;
		comNum = comPat = userNum = userPat = 0;

		while(flag) {
			
			System.out.println("1.게임 시작  2.종료");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				
				System.out.println("==== 게임 시작!!! ====");
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
						//컴퓨터 카드 뽑음
						comNum = (int)(Math.random() * 13);
						comPat = (int)(Math.random() * 4);
						//유저 카드 뽑음
						userNum = (int)(Math.random() * 13);
						userPat = (int)(Math.random() * 4);

						duplicate = false;

						//=== 카드 없으면 끝
						if(cardCount <= 0) {
							System.out.println("카드 없음");
							break;
						}

						//=== 컴퓨터와 유저 중복 방지
						if(comNum==userNum && comPat==userPat) {
							duplicate = true;
							continue;
						}

						//=== 뽑힌 카드 재사용하지 않음
						if(tempNumArray[comNum][comPat] || tempNumArray[userNum][userPat]) {
							duplicate = true;
							continue;
						}

						//=== 뽑힌 카드 기억
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
				System.out.println("게임 종료");
				flag = false;
				break;
				
			default:
				break;
			}
			
			if(cardCount <= 0) {
				System.out.printf("\n카드가 없으므로 게임을 종료합니다.");
				flag = false;
			}

		}

	}
	
	//////////////////////////////////////////////////////////////////
	//카드를 배열에 설정하는 함수
	public static void cardSet(int[][] cardNumArray, boolean[][] tempNumArray, String[][] card) {
		//카드 부여(초기화) (A//,2,3,4,5,6,7,8,9,10,J,Q,K,//A)
		//(1) 카드 숫자 부여 및 카드 빈장으로 초기화
		for(int i = 0 ; i < 13; i++) {

			for(int j = 0 ; j < 4; j++)
			{
				cardNumArray[i][j] = i + 1;
				card[i][j] = "";
				tempNumArray[i][j] = false;
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
	}
	
	//카드 출력 함수
	public static void printCards(String comCard[], String userCard[]) {
		System.out.printf("딜러 : ");
		for(int i = 0; i < comCard.length; i++) {
			if(comCard[i] != null) System.out.printf("%-3s", comCard[i]);
		}
		System.out.printf("\n유저 : ");
		for (int i = 0; i < userCard.length; i++) {
			if(userCard[i] != null) System.out.printf("%-3s", userCard[i]);
		}
		System.out.println();
		
		System.out.println("---------------------");
	}
	
	
}