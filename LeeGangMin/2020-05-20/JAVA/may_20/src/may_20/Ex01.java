package may_20;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
//		int i = 1;
//		
//		//1.
//		do {
//			System.out.println("HELLO");
//			i++;
//		}while(i<=5);						//do while 루프에서는 while 다음 조건식 뒤에 세미콜론 필요
		
		
		//2.
//		int sum = 0;
//		
//		do {
//			sum += i;
//			i++;
//		}while(i<=10);
//		
//		System.out.printf("합은 %d입니다.", sum);
		
		//3. 과목 점수를 입력받다가 음수 입력받으면 무한루프 종료
		Scanner sc = new Scanner(System.in);
//		int history;
//		double average;
//		int sum = 0;
//		int count = 0;
//		//do while은 무조건 1회 실행되는 특성
//		//(1)
//		do {
//			System.out.print("점수를 입력해주세요 > ");
//			history = sc.nextInt();			
//			if(history >= 0) {
//				sum += history;
//				count ++;
//			}
//		} while(history >= 0);
//		//(2)
////		do {
////			System.out.print("점수를 입력해주세요 > ");
////			history = sc.nextInt();
////			
////			if(history < 0) break;
////			
////			sum += history;
////			count ++;
////		} while(true);
//		
//		average = (double)sum / count;
//		System.out.printf("평균 점수는 %.1f\n 학생 수는 %d\t 합계 점수는 %d입니다 ", average, count, sum);
		
		//4. 메뉴가 1번 2번이 아니면 계속 루프돌게
//		int menu;
//		do {
//			System.out.println("1. 파일열기");
//			System.out.println("2. 파일저장");
//			System.out.print("메뉴 선택 >> ");
//			menu = sc.nextInt();
//		} while(!(menu>=1 && menu<=2));	//(menu<1||menu>2)
		
		//5. 특정 달을 입력받는데 1~12월이 아닌 다른 달을 입력했을 때 다시 입력받도록 루프
		System.out.println("몇 년인가요?");
		int year = sc.nextInt();
		int days;
		int month;
		
		//(1)
		do {
			System.out.println("말일을 계산할 달을 입력해주세요");
			month = sc.nextInt();
		
			switch (month) {
			case 2: if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) days = 29; //윤년 일때 2월은 29일
					else days = 28; break; //평년은 28일
								
			case 4: case 6: case 9: case 11: days = 30; break;
			default: if(month <= 12) days = 31;
					 else { days = 0;	//잘못된 값 입력시 0일로 예외처리
					 	System.out.println("다시 입력하세요");
					 }
			}
			
		}while(days <= 0);
		
		System.out.printf("입력한 \"%d월\"은 \"%d일\"까지 있습니다.\n", month, days);
		
		//(2)
//		do {
//			System.out.println("말일을 계산할 달을 입력해주세요");
//			month = sc.nextInt();
//		
//			if(!(month>=1 && month <=12)) System.out.println("다시 입력하세요");
//			else break;
//			
//		}while(true);
//		
//		switch (month) {
//		case 2: if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) days = 29; //윤년 일때 2월은 29일
//				else days = 28; break; //평년은 28일
//							
//		case 4: case 6: case 9: case 11: days = 30; break;
//		default: if(month <= 12) days = 31;
//		
//		System.out.printf("입력한 \"%d월\"은 \"%d일\"까지 있습니다.\n", month, days);
	}
}