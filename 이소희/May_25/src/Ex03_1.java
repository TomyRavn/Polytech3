import java.util.Scanner;

public class Ex03_1 {

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
			menu();
		int num = sc.nextInt();
		
		if(num == 3) {
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		if(!(num >= 1 && num <=3)) {
			System.out.println("잘못 입력 하였습니다. 다시 입력해주세요.");
			continue;
		}
		
		int i;
		int j;
		int count;
		
		switch(num) {
		case 1:
		//약수
		System.out.println("정수를 입력하세요.");
		num = sc.nextInt();
		System.out.printf("입력한 정수 :%d\n", num);
		
		for(i=1; i<=num; i++)
			if(num%i == 0)
			System.out.printf("%d, ", i);
			System.out.println("");
				break;
		
				
		case 2:
		//소수
		System.out.println("정수를 입력하세요.");
		num = sc.nextInt();
		System.out.printf("입력한 정수 :%d\n", num);
		
		count = 0;
		for(j=2; j<=num; j++)
			if(num%j == 0)
				count += 1;
				
			if(count == 1)
			System.out.printf("%d은 소수입니다.\n",num);
			else
			System.out.printf("%d은 소수가 아닙니다.\n",num);
				break;
		}
			
		}
		}



/////////////////////////////////////////////////////////////////////////////////////////////////////////


public static void menu() {
	System.out.println(">>menu"); 
	System.out.println("(1) 약수 출력 (2) 소수 판단 (3)종료 (메뉴 선택)");
}
}
