import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 	
		String str;
		
		System.out.println("숫자를 입력하세요");
		int x = scan.nextInt();
		
		if(x % 2 == 0) {
			System.out.println("짝수");	
			
	   } else {
		   System.out.println("홀수");	
	   }
		
		
	
}
}