import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		System.out.println("연도을 입력 하세요 !");
		int year =  scan.nextInt();
		
		System.out.println("월을 입력 하세요 !");
		int month = scan.nextInt();
		int days;
	
		
		
		switch(month) {
		case 2: days = (year %4 ==0 && year % 100 != 0 || year % 400 ==0)? 29: 28; break; //3항 연산자
		case 4: case 6: case 9: case 11: days = 30; break;
		default: days = 31;
		}
		
		System.out.printf("입력한 %d달은 %d일까지 있습니다.\n",month,days);
		

	}

}
