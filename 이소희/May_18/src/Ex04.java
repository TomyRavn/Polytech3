import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[[MENU]]");
		System.out.println("1. 짬뽕");
		System.out.println("2. 육회 비빔밥");
		System.out.println("3. 떡볶이");
		System.out.println("4. 국밥");
		System.out.println("메뉴 선택>>");
		
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1: System.out.println("짬뽕 선택"); break;
		case 2: System.out.println("육회 비빔밥 선택"); break;
		case 3: System.out.println("떡볶이 선택"); break;
		case 4: System.out.println("국밥 선택"); break;
		default: System.out.println("존재 하지 않는 항목입니다.");
		}
	}

}
