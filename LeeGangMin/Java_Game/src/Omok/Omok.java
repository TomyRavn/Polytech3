package Omok;
import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {
		
		//�������� ����ϴ� String ���ڿ� �迭 ����
		String[][] Omokpan = new String [19][19];
		
		//���� ���� �޴� ���Ῡ�θ� �Ǻ��� boolean �� ����
		boolean flag = true;
		
		//�ʱ� ȭ�� ���
		System.out.println("������������������������������������");
		System.out.println("��������������� ��     ��  ���������������");
		System.out.println("������������������������������������");
		
		//1�� (1000�и���) �ִٰ� ���� ��ɹ� ����
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//���� ����
		while(flag) {
			//���� ���� �Է� ���� �Ǻ��� boolean ������
			boolean gameStart = false;
			
			while(!gameStart) {
				Scanner sc = new Scanner(System.in);
				System.out.println("������ �����Ͻðڽ��ϱ�? (Y/N)");
				String input = sc.nextLine();	//���� ���� ���� �Է� �޴� ����
				
				switch(input) {
				//Y�� y�Է¹��� �� ���� ����
				case "Y": case "y": System.out.println("������ �����մϴ�!!!");
				gameStart = true;
				break;
				//N�̳� n�Է¹��� �� ���� ����
				case "N": case "n": System.out.println("������ �����մϴ�");
				gameStart = true;
				flag = false;
				break;
				//�ٸ� �� �Է� �� �� �Է�(while�� �ݺ�)
				default:
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���");
					gameStart = false;
				break;
				}
			}//end of while(!gameStart)
			
			//���� ������ ��쿡�� ���� ��ɹ� ����
			if(flag) {
				boolean isPlayingGame = true;	//������ ���������� �Ǻ��� boolean �� ����(while�� �۵�)
				makeOmokpan(Omokpan);			//������ �ʱ� ��� ���� ���ִ� �޼ҵ�
				
				Stone player1 = new Stone();	//StoneŬ����(x, y��ǥ) Ÿ���� player1 ����
				Stone player2 = new Stone();	//StoneŬ����(x, y��ǥ) Ÿ���� player2 ����
				
				boolean playerSwitch = false;	//player1�� player2 �� ���� �Ǻ��� �� ����
				boolean isDuplicate = true;		//���� �̹� ������ ���� ���� ������ �Ǻ��� �� ����
				boolean checkWin = false;		//�̰���� �Ǻ����� �� ����
				
				Scanner sc = new Scanner(System.in);
				
				printOmokpan(Omokpan);			//������ �ʱ� ��� ���
				
				while(isPlayingGame) {
					//player1�� player2�� X,Y���� -1�� ����(�ε��� ���� 0,0�� �޾ƿ��� �ȵǹǷ�)
					//����, while�������� ó���� ��� �ʱ�ȭ�� �����־�� ������� �Է��� ����� ���� �� ����(��� ���� �����ϸ� �ȵ�)
					player1.setX(-1);
					player1.setY(-1);
					player2.setX(-1);
					player2.setY(-1);
					
					isDuplicate = true;
					
					//player1�� ���� �Է¹ް�, �ߺ�üũ�� ���� ��ġ�� ������ while������ ��������
					while(isDuplicate) {
						isDuplicate = false;
						player1 = inputOmok(sc, player1, Omokpan, playerSwitch);
						isDuplicate = checkDuplicate(player1, Omokpan, isDuplicate);
					}
					playerSwitch = doOmok(player1, Omokpan, playerSwitch);	//player1�� ���� ������
					printOmokpan(Omokpan);									//���� ���������Ƿ� �������� ���� ���
					checkWin = winPlayer(Omokpan, checkWin);				//player1�� ���� ���� �� �¸��ߴ��� �Ǻ�
					
					//���� �÷��̾�1�� �̱��� �ʾҴٸ� checkWin �� ������ ������ false�̹Ƿ� ���� ��ɹ� ����
					//true�� �� �÷��̾� 1�� �¸��� ���� �ٷ� ����
					if(!checkWin) {
						isDuplicate = true;
						//player1�� �Ȱ��� �Է¹ް�, �ߺ�üũ�� ��ġ�� ������ while������ ��������
						while(isDuplicate) {
							isDuplicate = false;
							player1 = inputOmok(sc, player2, Omokpan, playerSwitch);
							isDuplicate = checkDuplicate(player2, Omokpan, isDuplicate);
						}
						
						playerSwitch = doOmok(player2, Omokpan, playerSwitch);	//player2�� ���� ������
						printOmokpan(Omokpan);									//���� ���������Ƿ� �������� ���� ���
						checkWin = winPlayer(Omokpan, checkWin);				//player2�� ���� ���� �� �¸��ߴ��� �Ǻ�
					}
					
					//������ ������ �� ���� �������� �˷��ִ� ���
					if(checkWin) {
						System.out.println("-----------���� ��-----------");
						isPlayingGame = false;
					}
				}
			}
			
		}
		
		System.out.println("������������������������������������");
		System.out.println("������������������������������������");
		System.out.println("������������������������������������");
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	//�迭�� �Ű������� �޾�, ������ ����� String ���ڿ��� ����ִ� �޼ҵ�(�Լ�)
	public static void makeOmokpan(String[][] Array){
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				
				if(i == 0) {
					if(j == 0) Array[i][j] = "��";
					else if(j == Array[i].length-1) Array[i][j] = "��";
					else Array[i][j] = "��";
				}
				
				else if(i == Array.length-1) {
					if(j == 0) Array[i][j] = "��";
					else if(j == Array[i].length-1) Array[i][j] = "��";
					else Array[i][j] = "��";
				}
				
				else {
					if(j == 0) Array[i][j] = "��";
					else if(j == Array[i].length-1) Array[i][j] = "��";
					else Array[i][j] = "��";
				}
			}
		}
	}
	
	//�迭�� �Է¹޾� ����ִ� String ���� ������ִ� �޼ҵ�
	public static void printOmokpan(String[][] Array) {
		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				System.out.print(Array[i][j]);
			}
			System.out.println();
		}
	}
	
	//Stone Ŭ���� Ÿ���� ��ü�� �Է¹޾�  �ش� ��ü�� ����ڰ� �Է��� X, Y��ǥ�� ��������ִ� �޼ҵ�, �̶� boolean �������� �÷��̾� ���ʸ� ��������
	//1~19 ���� �ʰ� �Է� ����ó��
	public static Stone inputOmok(Scanner sc, Stone playerN, String[][] Array, boolean switchOff) {
		
		boolean isCorrectRange = true;
		
		while(isCorrectRange) {
			
			isCorrectRange = false;
			if(!switchOff) {
				System.out.println("�÷��̾� 1�� �� �����Դϴ�");
				System.out.print("X,Y ��ǥ�� ������� �Է��ϼ��� > ");
				playerN.setX(sc.nextInt());
				playerN.setY(sc.nextInt());
			}
			else {
				System.out.println("�÷��̾� 2�� �� �����Դϴ�");
				System.out.print("X,Y ��ǥ�� ������� �Է��ϼ��� > ");
				playerN.setX(sc.nextInt());
				playerN.setY(sc.nextInt());
			}

			if(playerN.getX() < 1 || playerN.getX() > Array.length || playerN.getY() < 1 || playerN.getY() > Array.length) {
				System.out.println("������ �ʰ��� �Է��Դϴ�. �ٽ� �Է����ּ���(1~19, 1~19)");
				isCorrectRange = true;
			}
		}
		
		return playerN;
	}
	
	//�̹� ���� �������� ������ ���� �����ִ� �޼ҵ�
	public static boolean doOmok(Stone playerN, String[][] Array, boolean switchOff) {
		//if(Array[playerN.getY()-1][playerN.getX()-1] != "��" || Array[playerN.getY()-1][playerN.getX()-1] != "��") {
			
			if(!switchOff) {
				Array[playerN.getY()-1][playerN.getX()-1] = "��";
				switchOff = true;
			}
			else {
				Array[playerN.getY()-1][playerN.getX()-1] = "��";
				switchOff = false;
			}
			
		//}
		
		return switchOff;
	}
	
	//�ߺ��� üũ�ϴ� boolean �� ������ �Է¹޾� �ߺ����� �ƴ��� �Ǻ� �� ����� ����ִ� �޼ҵ�
	public static boolean checkDuplicate(Stone playerN, String[][] Array, boolean isDuplicate) {
		if(Array[playerN.getY()-1][playerN.getX()-1] == "��" || Array[playerN.getY()-1][playerN.getX()-1] == "��") {
			System.out.println("�̹� ���� �ڸ��� �ߺ��ؼ� ���� ���� �� �����ϴ�.");
			isDuplicate = true;
		}
		else isDuplicate = false;
		
		return isDuplicate;
	}
	
	//� ������ �̰���� �Ǻ��ؼ� boolean������ �������ִ� �޼ҵ�
	public static boolean winPlayer(String[][] Array, boolean checkWin) {
		
		for(int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				
				//-1���� �ʱⰪ���� ����־� �����ϰ� �Ǻ��ϹǷ� ���� ������ ���� ��츸 ó���ϵ��� ���ǹ� ����
				if(Array[i][j] == "��" || Array[i][j] == "��") {
					//����
					//�迭 �ִ� �ε����� ���� ����� �� ����
					if(i < Array.length - 4) {
						if(Array[i][j] == Array[i+1][j] && Array[i][j] == Array[i+2][j] && Array[i][j] == Array[i+3][j] && Array[i][j] == Array[i+4][j]) {
							if(Array[i][j] == "��") {
								System.out.println("�÷��̾� 1�� �¸��Դϴ�");
							}
							else {
								System.out.println("�÷��̾� 2�� �¸��Դϴ�");
							}
							checkWin = true;
							break;
						}
					}
					
					//����
					//�迭 �ִ� �ε����� ���� ����� �� ����
					if(j < Array[i].length - 4) {
						if(Array[i][j] == Array[i][j+1] && Array[i][j] == Array[i][j+2] && Array[i][j] == Array[i][j+3] && Array[i][j] == Array[i][j+4]) {
							if(Array[i][j] == "��") {
								System.out.println("�÷��̾� 1�� �¸��Դϴ�");
							}
							else {
								System.out.println("�÷��̾� 2�� �¸��Դϴ�");
							}
							checkWin = true;
							break;
						}
					}
					
					//�밢�� ����
					//�迭 �ִ� �ε����� ���� ����� �� ����
					if(i < Array.length - 4 && j < Array[i].length - 4) {
						if(Array[i][j] == Array[i+1][j+1] && Array[i][j] == Array[i+2][j+2] && Array[i][j] == Array[i+3][j+3] && Array[i][j] == Array[i+4][j+4]) {
							if(Array[i][j] == "��") {
								System.out.println("�÷��̾� 1�� �¸��Դϴ�");
							}
							else {
								System.out.println("�÷��̾� 2�� �¸��Դϴ�");
							}
							checkWin = true;
							break;
						}
					}
					
					//�밢�� ������
					//�迭 �ִ� �ε����� ���� ����� �� ����
					if(j > 4 && i < Array[i].length - 4) {
						if(Array[i][j] == Array[i+1][j-1] && Array[i][j] == Array[i+2][j-2] && Array[i][j] == Array[i+3][j-3] && Array[i][j] == Array[i+4][j-4]) {
							if(Array[i][j] == "��") {
								System.out.println("�÷��̾� 1�� �¸��Դϴ�");
							}
							else {
								System.out.println("�÷��̾� 2�� �¸��Դϴ�");
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

//����ó�� �ȵ� �κ� : 6��
//�߰��Ǿ�� �� �κ� : ��ǥ ����