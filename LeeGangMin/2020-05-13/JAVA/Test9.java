import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("알파벳을 입력하세요 > ");
		char ch = sc.nextLine().charAt(0);
		
		if(ch>=65 && ch<97) System.out.println("1");	//==> 정확한 범위는 65~90까지 포함 (ch>=65 && ch <=90)
		else System.out.println("0");					//또는 직접적으로 (ch>='A' && ch<='Z')로 표현
		
		//=== 2. ===//
//		ch = ch>=65 && ch<97? '1':'0';
//		System.out.println(ch);
		
		//=== 응용(대 소문자 전환) ===//
		if(ch>=65 && ch<97) ch += 32;	//대문자를 소문자로
		else ch -= 32;					//소문자를 대문자로
		System.out.println(ch);
	}
}