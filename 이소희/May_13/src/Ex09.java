import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result;
		System.out.println("임의의 정수 입력>>");
		int x = sc.nextInt();
		System.out.println("임의의 정수 입력>>");
		int y = sc.nextInt();
		
		if(y == 0)
			{System.out.println("입력 오류");
			System.out.println("0은 분모 사용 불가!");}
			
			else {result = x/y;
				System.out.printf("result:%d\n", result);}
	}

}
