import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		//A,a,1,기타문자> 입력한 글자를 그대로 받고 다른 것은 기타 문자입니다.
		
		System.out.println("입력하세요");
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);

		
		if(ch>='A' && ch <='Z') {
			System.out.println("대문자입니다:" + ch);		
		}else if(ch>='a' && ch<='z') {
			System.out.println("소문자입니다:" + ch);
		}else if(ch>='0' && ch<='9') {
			System.out.println("숫자입니다.");
		}else {
			System.out.println("기타문자 입니다.");
		
	
		}
	}
	
}

