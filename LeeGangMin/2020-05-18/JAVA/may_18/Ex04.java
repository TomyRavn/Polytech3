import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("  [[ MENU ]]  ");
		System.out.println("1.  짬뽕");
		System.out.println("2.  국밥");
		System.out.println("3.  육회비빔밥");
		System.out.println("4.  칼국수");
		System.out.print("메뉴 선택 >> ");
		
		int menu = sc.nextInt();
		
		//if - else if구문 중 == (일치 여부 판단)형태의 조건식만 switch구문으로 변환가능
		//switch 구문은 모두 if - else if구문으로 변환가능
		switch(menu) {
		case 1 : System.out.println("짬뽕 선택~"); break;		//case에 붙는 상수는 정수형 계열의 상수만 올 수 있음(C언어에서도 동일)	
		case 2 : System.out.println("국밥 선택~");	break;		//정수가 저장된 변수도 허용되지 않는다
		case 3 : System.out.println("육회비빔밥 선택~");	break;	//'A'와 같은 단일 문자 상수도 허용됨(ASCII코드의 정수값)
		case 4 : System.out.println("칼국수 선택~"); break;
		default : System.out.println("존재하지 않는 항목입니다. 다시 입력해주세요");
		}
	}
}