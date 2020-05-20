import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		
		System.out.println("알파벳 한 문자 입력");
		
		Scanner sc = new Scanner(System.in);
		
		char ch = sc.nextLine().charAt(0);
		
	/*	if(ch>='A' && ch <='Z') {
			System.out.println("1");
		}else 
			System.out.println("0"); */
		
		if(ch>=65 && ch <=90) {
			System.out.println("1");
		}else 
			System.out.println("0"); 
		
		
		
	}

}
