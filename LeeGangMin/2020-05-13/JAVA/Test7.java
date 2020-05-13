import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		//2개의 정수를 입력받아 하난 분모 하난 분자로 취급
		//분모가 0인 경우이면 2개의 출력문으로 처리(입력 오류, 0은 분모로 사용 불가)
		//다른 경우는 나눗셈 연산을 해서 
		//result값에 저장해 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("분자 값 입력 > ");
		int x = sc.nextInt();
		System.out.println("분모 값 입력 > ");
		int y = sc.nextInt();
		
		//if(y == 0); 의 경우 조건 만족시 아무것도 하지말라는 하나의 조건문이 되므로 유의
		if(y == 0) {
			System.out.println("입력 오류");
			System.out.println("0은 분모로 사용 불가");
		} else {							//두 줄 이상일 경우에는 if를 {} 블록으로 꼭 묶어줘야 함(else는 독자적으로 쓰일 수 없음)
			double result = (double)x/y;
			System.out.println(result);
		}
	}
}