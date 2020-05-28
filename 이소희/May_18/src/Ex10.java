import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		// for 반복문 
		// for (초기화; 조건식 or 경계값; 증감식) 
		// for (i=1; i<=5; i++) sysout();
		
		//for 반복문으로 Hello를 다섯 번 출력하기.
//		int i;
//		
//		for(i=1; i<=5; i++)
//			System.out.println("Hello");
		
		
		
		//for 반복문으로 구구단 구하기
//		int i;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("원하시는 구구단 숫자를 입력하세요.");
//		int a = sc.nextInt();
//		for(i=1; i<=9; i++)
//			System.out.printf("%d*%d = %d\n", a,i,a*i);
//		

		
		//for 반복문으로 1부터 n 값 까지 더하기

		int sum = 0;
		int i;
		Scanner sc = new Scanner(System.in);
	
		System.out.println("합계 값을 구할 숫자를 입력하세요.");
		int b = sc.nextInt();
		
		for(i=1; i<=b; i++)
			sum += i;
		
			System.out.printf("전체 합: %d\n", sum);
	}

}
