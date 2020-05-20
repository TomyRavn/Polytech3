import java.util.Scanner;

public class Ex04 {
	
	//연속적인 if else는  조건식인 equal을 묻는 경우는 switch로 전환 할 수 있다.

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" [[MENU]] ");
		System.out.println(" 1.짬뽕 ");
		System.out.println(" 2.국밥 ");
		System.out.println(" 3.육회비빔밥 ");
		System.out.println(" 4.칼국수 ");		
		System.out.println("메뉴선택 >>");
			
		int menu = scan.nextInt();
		int n =1; //변수로 선언이 되어있어도 상수만 입력 받아야 한다.
		
		switch(menu) {
		case 1: System.out.println("짬뽕선택"); 
		// 'case 'A': System.out.println("짬뽕선택");'는 65의 값을 가진 정수값으로 분류됨.//
				break;
		case 2: System.out.println("국밥선택");
				break;
		case 3: System.out.println("육회 선택");
				break;
		default: System.out.println("존재하지 않는 항목입니다. 다시 입력 하세요");
			
		}
		
		
		
	}

}
