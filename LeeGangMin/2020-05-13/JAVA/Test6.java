import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		//어떤 수를 입력받아서 짝수인지 홀수인지 구별하여 출력해내는 if문 작성
		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.println("임의의 정수 입력>> ");
		int x = sc.nextInt();
		
		if(x % 2 == 0) {
		System.out.println("짝수");					//해당 조건 이면 출력
		} else {
			System.out.println("홀수");				//조건을 만족하지 않는 경우 출력
		}
		System.out.printf("입력받은 수는 %d입니다.", x);	//무조건 출력
		
	}
}