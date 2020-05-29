package kr.ac.kopo.exapp;
import java.util.Scanner;
import java.util.ArrayList;

public class ListPro {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		ArrayList<String> list = new ArrayList<String>();
		
		while (flag) {
			
			System.out.println("1.목록  2.추가  3.삭제  4.종료");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				for(int i = 0; i < list.size(); i++) {
					System.out.println(i + ": " + list.get(i));
				}
				break;
			case "2":
				System.out.println("좋아하는 음식을 입력하세요.");
				//String line = sc.nextLine();
				list.add(sc.nextLine());
				break;
			case "3":
				System.out.println("삭제할 음식의 번호를 입력하세요.");
				//String num = sc.nextLine();
				//int n = Integer.parseInt(num);
				//list.remove(n);
				list.remove(Integer.parseInt(sc.nextLine()));
				break;
				//리스트는 앞쪽에 있는걸 삭제하면 뒤쪽의 것이 앞쪽으로 당겨지는 단점이 있다.(인덱스 번호 변경됨(당겨짐))
			case "4":
				flag = false;
				break;
				
			default:
				break;
			}
		}
		
	}
}