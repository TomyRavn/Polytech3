package kr.ac.kopo.exapp;
import java.util.ArrayList;
import java.util.Scanner;

public class ExList {
	public static void main(String[] args) {
		//"1.목록 2.추가 3.삭제 4.종료" 라고 메뉴를 출력
		//번호를 입력받는다
		//"1"을 입력한 경우, 현재까지 입력한 값들을 모두 출력
		//"2"를 입력한 경우, "좋아하는 음식을 입력하세요"라고 출력하고,
		//음식 이름을 입력받아 리스트에 저장
		//"3"을 입력한 경우, 삭제할 음식의 번호를 입력하세요"라고 출력하고,
		//입력한 번호의 음식을 리스트에서 삭제 는 일단 제외
		//"4"를 입력한 경우, 프로그램을 종료
		//위 작업을 무한 반복
		//예시문
//		list.add("피자");
//		list.add("햄버거");
//		System.out.println("리스트에 저장된 문자열 갯수 : " + list.size());
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		list.add(e): 리스트에 값을 저장하는 명령어
//		list.size(): 리스트에 몇 개가 들었는지 알 수 있는 명령어
		
		//리스트 생성
		//String을 여러 개 저장할 수 있는 리스트(목록) 생성
		//리스트는 껐다켜면 다 날아감
		ArrayList<String> list = new ArrayList<String/*타입*/>();	//ctrl + 1로 자동생성
		
		Scanner sc = new Scanner(System.in);
		String choose = "";		//빈 값으로 초기화
		
		while(true) {	//무한 반복
			//입력
			System.out.println("1.목록 2.추가 3.삭제 4.종료");
			System.out.println("실행하고 싶은 명령을 입력해주세요 > ");
			choose = sc.nextLine();	//선택 항목이 무엇인지 저장할 변수
			
			//1번 입력했을 때 목록 출력
			if(choose.equals("1")) {
				if(list.size() == 0) System.out.println("아무 것도 입력된 값이 없습니다");	//목록이 빈 경우 예외처리
				else {
					System.out.println("현재까지 입력한 목록");
					System.out.println("===================");
					for(int i = 0 ; i < list.size(); i++) {
						System.out.println(i + ". "+ list.get(i)); //목록에 입력된 크기만큼 반복하여 출력
					}
				}
			}
			
			//2번 입력했을 때 리스트 추가
			else if(choose.equals("2")) {
				System.out.print("추가할 항목을 입력해주세요 > ");
				list.add(sc.nextLine()); //추가
			}
			
			//3번 입력했을 때 목록을 보여주고 인덱스 입력받아 삭제
			else if(choose.equals("3")) {
				//사용자 편의를 위해 목록과 인덱스 번호를 보여줌
				System.out.println("현재까지 입력한 목록");
				System.out.println("===================");
				for(int i = 0 ; i < list.size(); i++) {
					System.out.println(i + ". "+ list.get(i));
				}
				
				//삭제 인덱스 입력
				System.out.print("삭제할 항목의 인덱스를 입력해주세요 > ");
				int remover = Integer.parseInt(sc.nextLine());
				
				//존재하는 인덱스 범위를 초과한 값이 입력된 경우 예외처리
				if(remover < list.size()) list.remove(remover);
				else System.out.println("삭제할 인덱스가 없습니다");
			}
			
			//4번 입력했을 때 프로그램 종료
			else if(choose.equals("4")) {
				System.out.println("프로그램을 종료합니다.");
				//System.exit(0);
				return;
			}
			
			//1,2,3,4를 제외한 값이 입력된 경우 예외처리
			else
			{
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
		
	}
}