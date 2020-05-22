package kr.ac.kopo.exapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ExList {

//1.목록 2.추가 3.삭제 4.종료 라고 메뉴를 출력 번호를 입력받는다. 1"을 입력한 경우, 현재까지 입력한 값들을 모두 출력
//"2"을 입력한 경우, "좋아하는 음식을 입력하세요"라고 출력하고,음식 이름을 입력 받아서 리스트에 저장
//"3"을 입력한 경우, 삭제할 음식의 번호를 입력하세요 라고 출력하고,입력한 번호의 음식을 리스트에서 삭제		
//"4"을 입력한 경우,프로그램을 종료
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
 		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag ){
			System.out.println("1.목록 2.추가 3.삭제 4.종료");	
			String menu = sc.nextLine();
		
			switch(menu) {
			case "1":
				for (int i = 0; i < list.size(); i++) {
					System.out.println(i +":"+ list.get(i));
				 }
				break;			
			case "2":
				System.out.println("좋아하는 음식을 입력하세요");
				String line = sc.nextLine();
				list.add(line);		
				break;			
			case "3":
				System.out.println("삭제할 음식의 번호를 입력하세요");
				String num = sc.nextLine();
				int n = Integer.parseInt(num);
				list.remove(n);
				break;	
			
			case "4":
				flag=false;
				System.out.println("종료합니다.");										
		
			default:
				break;
		}
			
		
		}
	}
}

	

			
	
	



