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
		
		//리스트 생성
		//String을 여러 개 저장할 수 있는 리스트(목록) 생성
		//리스트는 껐다켜면 다 날아감
		ArrayList<String> list = new ArrayList<String/*타입*/>();	//ctrl + 1로 자동생성
		
		Scanner sc = new Scanner(System.in);
		String choose = null;
		
		//예시문
//		list.add("피자");
//		list.add("햄버거");
//		System.out.println("리스트에 저장된 문자열 갯수 : " + list.size());
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		
		while(true) {
			System.out.println("1.목록 2.추가 3.삭제 4.종료");
			//list.add(e): 리스트에 값을 저장하는 명령어
			//list.size(): 리스트에 몇 개가 들었는지 알 수 있는 명령어
			if(choose) {
			list.add(sc.nextLine());
			}
			
		}
		
	}
}