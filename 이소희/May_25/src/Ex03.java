import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
//		다음과 같이 실행되는 프로그램을 설계하세요.
//		>>menu
//		(1) 약수 출력 (2) 소수 판단 (3)종료 (메뉴 선택) : 1
//			임의의 정수 입력: 80
//			1 2 4 5 8 10 16 20 40 80
		
//		>>menu
//		(1) 약수 출력 (2) 소수 판단 (3)종료 (메뉴 선택) : 2
//		임의의 정수 입력:12
//		12는 소수가 아닙니다!
		
		
		
		Scanner sc = new Scanner(System.in);

		
		while(true) {
		System.out.println("\n>>menu"); 
		System.out.println("(1) 약수 출력 (2) 소수 판단 (3)종료 (메뉴 선택)");
		int num = sc.nextInt();
		
		if(num == 3) {
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		if(!(num >= 1 && num <=3)) {
			System.out.println("잘못 입력 하였습니다. 다시 입력해주세요.");
			continue;
		}
		
		
		System.out.println("정수를 입력하세요.");
		int n = sc.nextInt();
		
		switch(num) {
		case 1:
			div(n); break;
	
		case 2:
			prime(n); break;
	
		}			
		}

	}


//////////////////////////////////////////////////////////////////////////////////////////////
public static void div(int x) {
	for(int i = 1; 1<=x; i++)  {
		if(x % i  == 0)
			System.out.printf("%2d", i);
 }
}


public static void prime(int x) {
	int cnt = 0;
	int i;
	for(i = 1; i<=x; i++) 	 {
		if(x%i == 0)
			cnt++;
	}
	if(cnt == 2)
		System.out.printf("%d는 소수입니다." , x);
	else
		System.out.printf("%d는 소수가 아닙니다." , x);
 }
}

//if(i == x)
//	System.out.printf("%d는 소수입니다." , x);
//else
//	System.out.printf("%d는 소수가 아닙니다." , x);
//}
//}
	

