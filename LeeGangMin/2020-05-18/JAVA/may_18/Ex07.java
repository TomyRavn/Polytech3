import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		//ㄱ.while 루프를 이용해 5회 반복 출력
//		int i = 1;
//		while(i <= 5){
//			System.out.println("HELLO");
//			i++;
//		}
		
		//ㄴ.while 루프를 이용해 7단 출력
//		int i = 1;
//		while(i <= 9) {
//			System.out.printf("%d * %d = %d\n", 7, i, 7*i);
//			i++;
//		}
		
		//ㄷ.while 루프를 이용해 원하는 구구단 출력
//		Scanner sc = new Scanner(System.in);

//		System.out.print("원하는 구구단을 입력하세요 > ");
//		int input = sc.nextInt();
//		int i = 1;
		
//		while(i <= 9) {
//			System.out.printf("%d * %d = %d\n", input, i, input*i);
//			i++;
//		}
		
		//ㄹ.while 루프를 이용해 1부터 n까지 합 출력
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("숫자를 입력해주세요 > ");
//		int number = sc.nextInt();
//		int i = 1;
//		int sum = 0;
//		
//		while(i <= number) {
//			sum += i;
//			i++;
//		}
//		
//		System.out.printf("전체 합 : %d\n", sum);
		
		//ㅁ. while(true) ==> 무한 루프 상태
//		int i = 1;
//		int sum = 0;
//		
//		while(true) {
//			System.out.println("HELLO");
//			if(i >= 5) break;
//			i++;
//			
//			//== if(i > 5) break;
//			//System.out.println("HELLO");
//			//i++;
//		}
		
		//ㅂ. 철학 과목의 중간 고사 점수의 전체 평균 점수를 구하시오.
		//학생인원은 입력받는 값
		//더 이상 입력할 학생이 없으면 음수를 입력해 무한 루프를 빠져나옴
//		Scanner sc = new Scanner(System.in);
//		
//		int sum = 0;
//		int studentCount = 0;
//		
//		while(true) {
//			System.out.printf("%d번째 학생의 철학 점수를 입력해주세요 > ", studentCount+1);
//			int philosopy = sc.nextInt();
//			
//			if(philosopy < 0) break;	//음수 입력 시 무한 루프 빠져나옴(위치에 주의)
//			
//			sum += philosopy;			//입력된 점수를 합계에 더함
//			studentCount++;				//학생 수를 증가시킴(평균 값 계산 및 출력에 사용)
//		}
//		double average = (double)sum / studentCount;
//		System.out.println("=========================================");
//		System.out.printf("철학 점수의 전체 평균 점수는 %.1f점\n학생수는 %d명입니다.", average, studentCount);
		
		//ㅅ. for 루프를 이용해 Hello 5번 출력
//		for(int i = 1; i <= 5; i++) {
//			System.out.println("HELLO");
//		}
		
		//ㅇ. for 루프를 이용해 9단 출력
//		for (int i = 1; i <=9; i++) {
//			System.out.printf("%d * %d = %d\n", 9, i, 9*i);
//		}
		
		//ㅈ. 1부터 n까지 누적 합
//		Scanner sc = new Scanner(System.in);
//		//입력받음
//		System.out.print("합계를 구할 수를 입력해주세요 > ");
//		int number = sc.nextInt();
//		//합계 변수
//		int sum = 0;
//		//반복문(n까지 합계)
//		for (int i = 1; i <= number; i++) {
//			sum += i;
//		}
//		//합계 출력
//		System.out.println(sum);
		
		//ㅊ. 무한 반복되는 구구단 출력
		//음수 일 때 반복문 종료
		Scanner sc = new Scanner(System.in);
		
		for(;;) {	//== while(true)
			System.out.print("구구단을 출력할 숫자를 입력해주세요 > ");
			int number = sc.nextInt();
			
			if(number < 0) {
				System.out.println("프로그램 종료 ");
				break;
			}
			
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", number, i, number * i);
			}
			
			System.out.println("=================================");
		}
	}
}