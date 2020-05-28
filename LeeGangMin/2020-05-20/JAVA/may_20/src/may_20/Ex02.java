package may_20;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		//가위 바위 보 게임 지속적으로 플레이
		Scanner sc = new Scanner(System.in);
		
		int com = (int)(Math.random() * 3 + 1);	//컴퓨터 1~3까지 랜덤 뽑기
		
		//1,2,3을 편의상 SCIS, ROCK, PAPE 라는 문자로 final상수로 정의
		final int SCIS = 1;
		final int ROCK = 2;
		final int PAPE = 3;
		
		//게임시작
		while(true){
			String inputRetry = "";		//재시작 여부(y,n) 입력받을 변수 초기화
			String comStr="컴 : ";		//컴퓨터가 무엇을 냈는지 알려줄 변수
			String userStr="나 : ";		//내가 무엇을 냈는지 알려줄 변수
			String result="";			//승부 결과를 알려주기 위한 변수
			int user;					//유저가 입력한 값(가위, 바위, 보)
			
			while(true) {
				//가위, 바위, 보 입력
				System.out.println("가위(1) 바위(2) 보(3) : ");
				user = Integer.parseInt(sc.nextLine());
				//값이 제대로 입력된 경우 루프를 빠져 나감
				if(user >= 1 && user <= 3) break;
				//가위, 바위, 보(1~3)가 아닌 다른 값을 입력한 경우 다시 입력
				else System.out.println("다시 입력하세요");
			}
			
			//1,2,3을 문자 "가위, 바위, 보"로 출력되게 설정
			//(1) com
			if(com == SCIS) comStr += "가위";
			else if(com == ROCK) comStr += "바위";
			else if(com == PAPE) comStr += "보";
			//(2) user
			if(user == SCIS) userStr += "가위";
			else if(user == ROCK) userStr += "바위";
			else if(user == PAPE) userStr += "보";
			//출력
			System.out.println(comStr);
			System.out.println(userStr);
			
			//가위바위보 승부 조건 설정
			switch(com) {
				case SCIS:
					result = user == SCIS? "비겼습니다"
							:user == ROCK? "이겼습니다":"졌습니다";
					break;
				case ROCK:
					result = user == SCIS? "졌습니다"
							:user == ROCK? "비겼습니다":"이겼습니다";
					break;
				case PAPE:
					result = user == SCIS? "이겼습니다"
							:user == ROCK? "졌습니다":"비겼습니다";
					break;
			}
			//결과값 출력
			System.out.println(result);
			System.out.println("---------");
			
			//게임 계속할지 여부
			while(true) {
				//계속할지 여부 입력
				System.out.println("게임을 계속 하시겠습니까? (Y/N)");
				inputRetry = sc.nextLine();
				//Y,N,y,n(대소문자) 입력 시 루프를 빠져나감
				if(inputRetry.equals("N")||inputRetry.equals("Y")||inputRetry.equals("n")||inputRetry.equals("y")) break;
				//아닐 시 다시 입력
				else {System.out.println("잘못된 입력입니다. 다시 입력해주세요.");}
			}
			
			//제대로 된 입력시 조건에 맞는 실행
			if(inputRetry.equals("N")||inputRetry.equals("n")) {
				System.out.println("게임을 종료합니다.");break;
			}
			else {
				System.out.println("게임을 재시작합니다.");
				System.out.println("======================");
			}
			
		}
	}
}