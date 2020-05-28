package kr.ac.kopo.exapp;
import java.util.Scanner;

public class ExLogin {
	//"ID를 입력하세요" 라고 출력하고, ID를 입력받고,
	//"비밀번호를 입력하세요" 라고 출력하고, 비밀번호를 입력받고,
	//입력한 ID가 "a001"이 아니면, "존재하지 않는 ID입니다"라고 출력
	//입력한 ID가 "a001"이고 비밀번호가 "1234"이면, "로그인 성공"이라고 출력
	//입력한 ID가 "a001"이고 비밀번호가 "1234"가 아니면, "로그인 실패"라고 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String id = "a001";	//데이터베이스 저장된 ID
		String pw = "1234"; //데이터베이스 저장된 P/W
		
		String inputId;		//입력받는 ID
		String inputPw;		//입력받는 P/W
		boolean hack = false; //로그인 실패 확인 변수
		int count = 5;		//로그인 시도 가능 횟수
		int count_text = 5; //로그인 잔여 횟수 출력을 위한 변수(잔여 횟수 출력 변화를 위해 count가 감소될 시 로그인 시도 횟수도 줄어드므로 따로 변수 선언)
		
		//System.out.println(inputId + ", " + inputPw); 주석 제거 시 값이 제대로 입력되었는 지 확인하는 코드
		
		for(int i = 1; i <= count; i++) {	//로그인 여러번 시도를 위한 반복문
			System.out.print("ID를 입력하세요 > ");
			inputId = sc.nextLine();
			System.out.print("비밀번호를 입력하세요 > ");
			inputPw = sc.nextLine();
			
			if(inputId.equals(id)) {
				if(inputPw.equals(pw)) {
					System.out.println("로그인 성공");
					hack = false;
					break;	//로그인 성공 시 더 시도할 필요 없으므로 반복문을 빠져나감
					}
				else {
					System.out.println("로그인 실패");
					}
				}
			else {
				System.out.println("로그인 실패");
				}
			count_text--; //로그인 잔여 횟수(텍스트 출력) 감소
			System.out.println("남은 접속 가능 횟수 : " + count_text + "회");
			hack = true;  //로그인 실패 확인
		}
		if(hack) {	//반복문 종료까지 계속 실패하여 실패 확인 되었을 경우
			System.out.println("5회 연속 접속 실패하여 프로그램을 종료합니다");
		}
	}
}