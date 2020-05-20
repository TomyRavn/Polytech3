import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//윤년 특정 연도를 4로 나누어 떨어지고, 100으로는 나누어 떨어지지 않는 연도
		//혹은 400으로 나누어 떨어지는 연도 
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("연도를 입력하세요.");
		int year = scan.nextInt();
	
		boolean result1 = (year %  4 == 0) && (year %  100 !=0) || (year%  400 ==0);	
		System.out.println(result1);				
	}
}
