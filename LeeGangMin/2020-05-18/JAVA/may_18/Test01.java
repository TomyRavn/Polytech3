import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정수형 1,2,3을 뽑는 난수
//		int a = (int)(Math.random()*10 + 1);	//(int)Math.random()*10 로 할 경우 0.XX를 정수로 먼저 변환하여 0*10이 되므로 유의
												//1부터 9까지 난수라고 설명하셨지만 아님. 1부터 10까지임
		
		//편의를 위해 정의
		final int SCISSORS = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		//컴퓨터가 뽑는 숫자(가위(1), 바위(2), 보(3)만 뽑음)
		int com = 0;
		
		//1~3까지 뽑아서 저장
		com = (int)(Math.random()*3 + 1);
		
		//숫자 대신 가위,바위,보 출력할 변수
		String str = "";
		if(com == SCISSORS) str = "가위";
		else if(com == ROCK) str = "바위";
		else if(com == PAPER) str = "보";
		
		//사용자 입력
		System.out.println("숫자를 입력해주세요. 가위(1) 바위(2) 보(3)");
		int input = sc.nextInt();
		
		//1. if문 쓴 경우
		if(com == input) System.out.println("비겼습니다");					//비겼을 경우
		else {															//안 비겼을 경우
			if(input == SCISSORS || input == ROCK || input == PAPER) {	//1,2,3 입력 이외의 입력의 경우 예외처리
				if(com == SCISSORS) {
					if(input == ROCK) System.out.println("이겼습니다");
					else System.out.println("졌습니다");
				}
				else if(com == ROCK) {
					if(input == PAPER) System.out.println("이겼습니다");
					else System.out.println("졌습니다");
				}
				else {
					if(input == SCISSORS) System.out.println("이겼습니다");
					else System.out.println("졌습니다");
				}
			} else System.out.println("잘못된 입력");						//1,2,3 입력 이외의 입력의 경우 예외처리
		}
		System.out.printf("컴퓨터는 %s를 냈습니다.\n", str);
		
		
		//2. switch문 쓴 경우
//		String str2 = ""; 		//결과 출력할 변수
//		switch(input)
//		{
//		case SCISSORS:
//			str2 = com == SCISSORS? "비겼습니다":com == ROCK? "졌습니다":"이겼습니다";
//			break;
//		case ROCK:
//			str2 = com == SCISSORS? "이겼습니다":com == ROCK? "비겼습니다":"졌습니다";
//			break;
//		case PAPER:
//			str2 = com == SCISSORS? "졌습니다":com == ROCK? "이겼습니다":"비겼습니다";
//			break;
//		default:
//			str2 = "잘못된 입력입니다";
//		}
//		System.out.println(str2);
//		System.out.printf("컴퓨터는 %s를 냈습니다.\n", str);
//		str 대신 com==1?"가위":com==2?"바위":"보" 를 써도 됨
	}
}