import java.util.Scanner;

public class Ex02_달구하기 {

	public static void main(String[] args) {

	
		int days = 0;
		int year= 0;
	
		Scanner s = new Scanner(System.in);
		int month;
		
		do {
			System.out.println( "월을 입력");
			month = s.nextInt();
			
			if(month<1 || month>12)
				System.out.println( "잘못입력");
			else break;
		
		} 	while(true);	

			switch(month) {
			case 2: days = (year %4 ==0 && year % 100 != 0 || year % 400 ==0)? 29: 28; break;
			case 4: case 6: case 9: case 11: days = 30; break;
			default: days = 31;
		}
			System.out.printf("입력한 %d달은 %d일까지 있습니다.\n",month,days);
		
}

}
