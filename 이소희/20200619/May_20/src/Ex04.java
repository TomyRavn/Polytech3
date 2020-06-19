import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// 달을 입력 받았을 때  며칠이 있는지 출력하기 단, 
		// 잘못된 달이 입력 되면 다시 입력하도록 하기.
		
		Scanner sc = new Scanner(System.in);
		int month;
		int days;
		
		do {
			System.out.println("월을 입력하세요>>");
			month = sc.nextInt();				
			
			if(month > 12 || month < 1)
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			else break;
					
		} while(true);
		switch(month) {
		case 2: days = 29; break;
		case 4: case 6: case 9: case 11: days = 30; break;
		default: days = 31;
		System.out.printf("%d월 달은 %d일 까지 있습니다. \n", month, days);
		
	

	}
	}
}
