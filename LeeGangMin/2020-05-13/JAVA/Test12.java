import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {
		//문자를 입력받고
		//알파벳 대문자, 소문자, 숫자, 기타문자 를 입력받고
		//해당 형태가 무엇인지 알려주는 프로그램
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 입력해주세요 > ");
		char ch = sc.nextLine().charAt(0);
		
		if(ch >= 'A' && ch <= 'Z') System.out.println("대문자 입니다");
		else if(ch >= 'a' && ch <= 'z') System.out.println("소문자 입니다");
		else if(ch >= '0' && ch <= '9') System.out.println("숫자 입니다");
		else System.out.println("기타문자 입니다");
	}
}