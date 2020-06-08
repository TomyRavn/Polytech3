package Omok;
import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {
		
		//오목판을 출력하는 String 문자열 배열 생성
		String[][] Omokpan = new String [19][19];
		
		//게임 메인 메뉴 종료여부를 판별할 boolean 논리 변수
		boolean flag = true;
		
		//초기 화면 출력
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■ 오     목  ■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		//1초 (1000밀리초) 있다가 다음 명령문 실행
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//게임 시작
		while(flag) {
			//게임 시작 입력 여부 판별할 boolean 논리변수
			boolean gameStart = false;
			
			while(!gameStart) {
				Scanner sc = new Scanner(System.in);
				System.out.println("게임을 시작하시겠습니까? (Y/N)");
				String input = sc.nextLine();	//게임 시작 여부 입력 받는 변수
				
				switch(input) {
				//Y나 y입력받을 시 게임 시작
				case "Y": case "y": System.out.println("게임을 시작합니다!!!");
				gameStart = true;
				break;
				//N이나 n입력받을 시 게임 종료
				case "N": case "n": System.out.println("게임을 종료합니다");
				gameStart = true;
				flag = false;
				break;
				//다른 값 입력 시 재 입력(while문 반복)
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요");
					gameStart = false;
				break;
				}
			}//end of while(!gameStart)
			
			//게임 시작한 경우에만 다음 명령문 실행
			if(flag) {
				boolean isPlayingGame = true;	//게임이 진행중인지 판별할 boolean 논리 변수(while문 작동)
				makeOmokpan(Omokpan);			//오목판 초기 모양 설정 해주는 메소드
				
				Stone player1 = new Stone();	//Stone클래스(x, y좌표) 타입의 player1 생성
				Stone player2 = new Stone();	//Stone클래스(x, y좌표) 타입의 player2 생성
				
				boolean playerSwitch = false;	//player1과 player2 의 턴을 판별할 논리 변수
				boolean isDuplicate = true;		//돌이 이미 놓여진 곳에 놓은 것인지 판별할 논리 변수
				boolean checkWin = false;		//이겼는지 판별해줄 논리 변수
				
				Scanner sc = new Scanner(System.in);
				
				printOmokpan(Omokpan);			//오목판 초기 모양 출력
				
				while(isPlayingGame) {
					//player1과 player2의 X,Y값을 -1로 설정(인덱스 값인 0,0을 받아오면 안되므로)
					//또한, while루프에서 처음에 계속 초기화를 시켜주어야 사용자의 입력을 제대로 받을 수 있음(계속 값을 유지하면 안됨)
					player1.setX(-1);
					player1.setY(-1);
					player2.setX(-1);
					player2.setY(-1);
					
					isDuplicate = true;
					
					//player1의 값을 입력받고, 중복체크를 한후 겹치지 않으면 while루프를 빠져나옴
					while(isDuplicate) {
						isDuplicate = false;
						player1 = inputOmok(sc, player1, Omokpan, playerSwitch);
						isDuplicate = checkDuplicate(player1, Omokpan, isDuplicate);
					}
					playerSwitch = doOmok(player1, Omokpan, playerSwitch);	//player1의 돌을 놓아줌
					printOmokpan(Omokpan);									//돌이 놓아졌으므로 오목판을 새로 출력
					checkWin = winPlayer(Omokpan, checkWin);				//player1이 돌을 놓은 후 승리했는지 판별
					
					//만약 플레이어1이 이기지 않았다면 checkWin 논리 변수가 여전히 false이므로 다음 명령문 실행
					//true일 시 플레이어 1의 승리로 게임 바로 종료
					if(!checkWin) {
						isDuplicate = true;
						//player1과 똑같이 입력받고, 중복체크를 겹치지 않으면 while루프를 빠져나옴
						while(isDuplicate) {
							isDuplicate = false;
							player1 = inputOmok(sc, player2, Omokpan, playerSwitch);
							isDuplicate = checkDuplicate(player2, Omokpan, isDuplicate);
						}
						
						playerSwitch = doOmok(player2, Omokpan, playerSwitch);	//player2의 돌을 놓아줌
						printOmokpan(Omokpan);									//돌이 놓아졌으므로 오목판을 새로 출력
						checkWin = winPlayer(Omokpan, checkWin);				//player2가 돌을 놓은 후 승리했는지 판별
					}
					
					//게임이 끝났을 시 게임 끝났음을 알려주는 출력
					if(checkWin) {
						System.out.println("-----------게임 끝-----------");
						isPlayingGame = false;
					}
				}
			}
			
		}
		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	//배열을 매개변수로 받아, 오목판 모양의 String 문자열을 담아주는 메소드(함수)
	public static void makeOmokpan(String[][] Array){
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				
				if(i == 0) {
					if(j == 0) Array[i][j] = "┌";
					else if(j == Array[i].length-1) Array[i][j] = "┐";
					else Array[i][j] = "┬";
				}
				
				else if(i == Array.length-1) {
					if(j == 0) Array[i][j] = "└";
					else if(j == Array[i].length-1) Array[i][j] = "┘";
					else Array[i][j] = "┴";
				}
				
				else {
					if(j == 0) Array[i][j] = "├";
					else if(j == Array[i].length-1) Array[i][j] = "┤";
					else Array[i][j] = "┼";
				}
			}
		}
	}
	
	//배열을 입력받아 들어있는 String 값을 출력해주는 메소드
	public static void printOmokpan(String[][] Array) {
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				System.out.print(Array[i][j]);
			}
			System.out.println();
		}
	}
	
	//Stone 클래스 타입의 객체를 입력받아  해당 객체에 사용자가 입력한 X, Y좌표를 저장시켜주는 메소드, 이때 boolean 논리변수는 플레이어 차례를 구별해줌
	//1~19 범위 초과 입력 예외처리
	public static Stone inputOmok(Scanner sc, Stone playerN, String[][] Array, boolean switchOff) {
		
		boolean isCorrectRange = true;
		
		while(isCorrectRange) {
			
			isCorrectRange = false;
			if(!switchOff) {
				System.out.println("플레이어 1이 둘 차례입니다");
				System.out.print("X,Y 좌표를 순서대로 입력하세요 > ");
				playerN.setX(sc.nextInt());
				playerN.setY(sc.nextInt());
			}
			else {
				System.out.println("플레이어 2가 둘 차례입니다");
				System.out.print("X,Y 좌표를 순서대로 입력하세요 > ");
				playerN.setX(sc.nextInt());
				playerN.setY(sc.nextInt());
			}

			if(playerN.getX() < 1 || playerN.getX() > Array.length || playerN.getY() < 1 || playerN.getY() > Array.length) {
				System.out.println("범위를 초과한 입력입니다. 다시 입력해주세요(1~19, 1~19)");
				isCorrectRange = true;
			}
		}
		
		return playerN;
	}
	
	//이미 돌이 놓여있지 않으면 돌을 놓아주는 메소드
	public static boolean doOmok(Stone playerN, String[][] Array, boolean switchOff) {
		//if(Array[playerN.getY()-1][playerN.getX()-1] != "●" || Array[playerN.getY()-1][playerN.getX()-1] != "○") {
			
			if(!switchOff) {
				Array[playerN.getY()-1][playerN.getX()-1] = "●";
				switchOff = true;
			}
			else {
				Array[playerN.getY()-1][playerN.getX()-1] = "○";
				switchOff = false;
			}
			
		//}
		
		return switchOff;
	}
	
	//중복을 체크하는 boolean 논리 변수를 입력받아 중복인지 아닌지 판별 후 결과를 담아주는 메소드
	public static boolean checkDuplicate(Stone playerN, String[][] Array, boolean isDuplicate) {
		if(Array[playerN.getY()-1][playerN.getX()-1] == "●" || Array[playerN.getY()-1][playerN.getX()-1] == "○") {
			System.out.println("이미 놓인 자리에 중복해서 돌을 놓을 수 없습니다.");
			isDuplicate = true;
		}
		else isDuplicate = false;
		
		return isDuplicate;
	}
	
	//어떤 유저가 이겼는지 판별해서 boolean변수에 저장해주는 메소드
	public static boolean winPlayer(String[][] Array, boolean checkWin) {
		
		for(int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				
				//-1값이 초기값으로 들어있어 동일하게 판별하므로 돌이 놓여진 곳의 경우만 처리하도록 조건문 설정
				if(Array[i][j] == "○" || Array[i][j] == "●") {
					//세로
					//배열 최대 인덱스가 범위 벗어나는 것 방지
					if(i < Array.length - 4) {
						if(Array[i][j] == Array[i+1][j] && Array[i][j] == Array[i+2][j] && Array[i][j] == Array[i+3][j] && Array[i][j] == Array[i+4][j]) {
							if(Array[i][j] == "●") {
								System.out.println("플레이어 1의 승리입니다");
							}
							else {
								System.out.println("플레이어 2의 승리입니다");
							}
							checkWin = true;
							break;
						}
					}
					
					//가로
					//배열 최대 인덱스가 범위 벗어나는 것 방지
					if(j < Array[i].length - 4) {
						if(Array[i][j] == Array[i][j+1] && Array[i][j] == Array[i][j+2] && Array[i][j] == Array[i][j+3] && Array[i][j] == Array[i][j+4]) {
							if(Array[i][j] == "●") {
								System.out.println("플레이어 1의 승리입니다");
							}
							else {
								System.out.println("플레이어 2의 승리입니다");
							}
							checkWin = true;
							break;
						}
					}
					
					//대각선 왼쪽
					//배열 최대 인덱스가 범위 벗어나는 것 방지
					if(i < Array.length - 4 && j < Array[i].length - 4) {
						if(Array[i][j] == Array[i+1][j+1] && Array[i][j] == Array[i+2][j+2] && Array[i][j] == Array[i+3][j+3] && Array[i][j] == Array[i+4][j+4]) {
							if(Array[i][j] == "●") {
								System.out.println("플레이어 1의 승리입니다");
							}
							else {
								System.out.println("플레이어 2의 승리입니다");
							}
							checkWin = true;
							break;
						}
					}
					
					//대각선 오른쪽
					//배열 최대 인덱스가 범위 벗어나는 것 방지
					if(j > 4 && i < Array[i].length - 4) {
						if(Array[i][j] == Array[i+1][j-1] && Array[i][j] == Array[i+2][j-2] && Array[i][j] == Array[i+3][j-3] && Array[i][j] == Array[i+4][j-4]) {
							if(Array[i][j] == "●") {
								System.out.println("플레이어 1의 승리입니다");
							}
							else {
								System.out.println("플레이어 2의 승리입니다");
							}
							checkWin = true;
							break;
						}
					}
				}
				
			}
		}
		
		return checkWin;
	}
	
}

//예외처리 안된 부분 : 6목
//추가되어야 할 부분 : 좌표 숫자