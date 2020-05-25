import java.util.Scanner;

public class 메소드2개로계산기만들기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true){	
			menu();
			System.out.println("\n메뉴선텍>>");
			int n = s.nextInt();
	
			if(n==5) {
				System.out.println("프로그램을 종료합니다.");
				return; //while 루프를 빠져나옴
			}
			
			if(!(n >=1 && n<=5 )) {
				System.out.println("잘못입력 했습니다.다시입력하세요");
				continue; // 아래의 값을 건너뛰어야 함
			}
			
			System.out.print("정수1 입력");
			int x = s.nextInt();
			
			System.out.print("정수2 입력");
			int y = s.nextInt();
			int result =0;
			
			switch(n) {
			case 1:result = add(x, y); break;
			case 2:result = sub(x, y); break; 
			case 3:result = mul(x, y); break; 
			case 4:result = div(x, y); break; 
			case 5:System.out.println("프로그램 종료");return;
			}
					
			System.out.printf("계산 결과:%d\n",result);
		}
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////// 메인메소드 부터 실행
	
	public static int add(int x, int y) {
		return x + y; // 메서드 호출문 ,return 그 위치에서 바로 종료.
	}
	public static int sub(int x, int y) {
		return x - y; 
	}
	public static int mul(int x, int y) {
		return x * y; 
	}
	public static int div(int x, int y) {
		return x / y;
	}
	
	public static void menu() {
		System.out.println("1. 덧셈");
		System.out.println("2. 뺄셈");
		System.out.println("3. 나눗셈");
		System.out.println("4. 곱셈");
		System.out.println("5. 종료");
	}
	

}