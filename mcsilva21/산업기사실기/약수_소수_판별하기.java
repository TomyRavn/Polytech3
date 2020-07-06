import java.util.Scanner;

public class 약수_소수_판별하기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true){	
			menu();			
			System.out.println("(1)약수 출력 (2)소수판단 (3)종료 (매뉴선택)");
			System.out.println("Menu>>");
			int n = s.nextInt();
	
			if(n==3) {
				System.out.println("프로그램을 종료합니다.");
				return; //while 루프를 빠져나옴
			}
			
			if(!(n >=1 && n<=3)) {
				System.out.println("잘못입력 했습니다.다시입력하세요");
				continue; // 아래의 값을 건너뛰어야 함
			}
			
			System.out.print("정수를 입력");
			int x = s.nextInt();
			int j;
			int p;
			int count;
			
			
			switch(n) {

			case 1:
				for(j=1; j<=x; j++)	
					if(x%j==0)
						System.out.printf("%d ",j);
				System.out.println();
				break;

			case 2: 					
				count=0;
				
				for(p=2; p<=x; p++)					
					if(x%p==0) 
						count += 1;

				if(count == 1) 
					System.out.printf("%d는 소수 입니다\n",x);	
				else
					System.out.printf("%d는 소수가 아닙니다\n",x);

				break;


			case 3:System.out.println("프로그램 종료");return;
			}

		}
	}
		
/////////////////////////////////////////////////////////////////////////////////////////// 메인메소드 부터 실행
	

	public static void menu() {
		System.out.println("1. 약수출력");
		System.out.println("2. 소수판단");
		System.out.println("3. 종료");

	}
	

	}


