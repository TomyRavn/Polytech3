import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//정수값 3개 입력해 최대값 출력
		int x, y, z, max;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수값 3개 입력하세요. 1번째 >");
		x = sc.nextInt();
		System.out.println("정수값 3개 입력하세요. 2번째 >");
		y = sc.nextInt();
		System.out.println("정수값 3개 입력하세요. 3번째 >");
		z = sc.nextInt();
		
		//1. 조건 연산자 사용
//		max = x>y? x:y;
//		max = max>z? max:z;
//		System.out.println("최댓값 : " + max);
		
		//2. if문 사용
		if(x>y) max = x; 
		else max = y;		// x와 y비교하여 max에 대입
		if(z>max) max = z;	//max(x와 y중 큰 수)와 z비교하여 z가 크면 max에 대입, 작으면 max 그대로 출력 
		System.out.println("최댓값 : " + max);
		
		//3. 플로우 차트 따른 방식
//		if(x>y) {
//			if(x>z) max = x;
//			else max = z;
//		} else {
//			if(y>z) max = y;
//			else max = z;
//		}
	}
}