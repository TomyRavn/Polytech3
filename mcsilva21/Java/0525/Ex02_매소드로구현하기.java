import java.util.Scanner;

public class Ex02_매소드로구현하기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true){	
		
			System.out.println("(1)약수 출력 (2)소수판단 (3)종료 (매뉴선택)");
			System.out.println("Menu>>");
			int n = s.nextInt();
	
			if(n==3) {
				System.out.println("프로그램을 종료합니다.");
				return; //while 루프를 빠져나옴
			}
			
			if(!(n >=1 && n<=3)) {
				System.out.println("잘못입력 했습니다.다시입력하세요");
				continue;
			}
			
			System.out.print("정수를 입력");
			int x = s.nextInt();
									
			switch(n) {
			case 1: div(x); break;
			case 2: prime(x); break;
			case 3:System.out.println("프로그램 종료");return;
			}
		
		}
	}
		
/////////////////////////////////////////////////////////////////////////////////////////// 메인메소드 부터 실행
	public static void div(int x) {
		for(int i=1; i <=x; i++) {
			if(x%i == 0)
				System.out.printf("%4d",i);
		}

	}
	
	
	
	///////////////////////////////////////////////////////////////////
	public static void prime(int x) {
		int i;
		int cnt=0;
		
		for(i=2; i <x; i++) {
			if(x%i == 0)
				break;
		}
		
		if(i==x)
			System.out.printf("%d는 소수입니다.\n",x);
		else
			System.out.printf("%d는 소수가 아닙니다.\n",x);
	}
	

	}


