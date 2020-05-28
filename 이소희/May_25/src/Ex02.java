import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//
//		int add = test(10, 80);
//		System.out.printf("합의 결과: %d\n", add);
//		
//		
//	}
//		
//	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		public static int test(int x, int y) {
//			
//		//return문을 만나면 종료!
//		return x + y;
//	
//		}
//
//}

		while(true) {
			menu();
			int result = 0;
			
			System.out.print("\n메뉴 선택>>");
			int n = sc.nextInt();
			if (n == 5) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			if(!(n >= 1 && n <=5)) {
				System.out.println("잘못 입력 하였습니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.println("정수 1 입력>>");
			int x = sc.nextInt();
			
			System.out.println("정수 2 입력>>");
			int y = sc.nextInt();
					
		
			switch(n) {
			case 1: result = add(x,y); break;
			case 2: result = sub(x,y); break;
			case 3: result = mul(x,y); break;
			case 4: result = div(x,y); break;
			case 5: System.out.println("프로그램을 종료합니다.");break;
			
			
		}
		
			System.out.printf("계산 결과: %d\n", result);
		
		}		
		}	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//안의 (int x, int y)에서 x나 y는 임의로 설정 가능 
	public static int add(int x, int y) {

		return x + y;	
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
			System.out.println("1.덧셈");
			System.out.println("2.뺄셈");
			System.out.println("3.곱셈");
			System.out.println("4.나눗셈");
			System.out.println("5.종료");
			
			
		}
		}
		

