import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		//특정 달을 입력받아 말일이 몇 일까지 있는지 처리해주는 프로그램(Switch로 처리)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 년인가요?");
		int year = sc.nextInt();
		System.out.println("말일을 계산할 달을 입력해주세요");
		int month = sc.nextInt();
		int days; //모든 경우의 조건에서 값이 나오는 경우 초기화를 안해도 됨
		
		switch (month) {
		case 2: if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) days = 29; //윤년 일때 2월은 29일
				else days = 28; break; //평년은 28일
				
				//조건연산자
				//days = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)? 29:28;
				//break;
				
		case 4: case 6: case 9: case 11: days = 30; break;
		default: if(month <= 12) days = 31;
				 else days = 0;	//잘못된 값 입력시 0일로 예외처리
		}
		System.out.printf("입력한 \"%d월\"은 \"%d일\"까지 있습니다.\n", month, days);
	}
}