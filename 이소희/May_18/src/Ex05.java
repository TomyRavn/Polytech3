import java.util.Scanner;

public class Ex05 {
	//년 월 입력 받고 우

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도를 입력하세요>>");
		int year = sc.nextInt();
		
		System.out.println("월을 입력하세요>>");
		int month = sc.nextInt();
		int days;
		
		
		
		switch(month) {
		case 2: days = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)? 29:28; break;
		case 4: case 6: case 9: case 11: days = 30; break;
		default: days = 31;
		}
		System.out.printf("입력한 %d년 %d월 달은 %d일 까지 있습니다. \n", year, month, days);
	}

}
