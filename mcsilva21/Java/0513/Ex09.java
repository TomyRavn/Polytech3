import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 	
		
		System.out.println("숫자를 입력하세요");
		int x = scan.nextInt();
		
		System.out.println("숫자를 입력하세요");
		int y = scan.nextInt();
		
		int result = x/y;
		
		if(y == 0) {
			System.out.println("입력오류");
			System.out.println("0은 분모 사용불가!!");
			
		} else {
				System.out.println("나눗셈을 실행하세요");
				System.out.print(result);
		
	}

}
}
