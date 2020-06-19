import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		//알대 알소 숫자 기타문자
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		
		if(ch >='A' && ch<='Z')
			System.out.println("알파벳 대문자 입니다.");
		else if(ch >='a' && ch <= 'z')
			System.out.println("알파벳 소문자 입니다.");
		else if(ch >= '0' && ch <= '9')
			System.out.println("숫자입니다.");
		else
			System.out.println("기타문자입니다.");
		

	}

}
