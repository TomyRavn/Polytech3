package july_06;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str; //= new String();
		
		System.out.print("문자열 입력 ==>");
		str = s.nextLine();				//문자열을 키보드로 입력받는다.
		
		System.out.print("출력 문자열 ==>");
		for (int i = 0; i < str.length(); i++) {		//문자열의 길이만큼 반복한다.
			if(str.charAt(i) == 'o')				//문자가 o이면 $를 출력하고, 아니면 원래 문자를 출력한다.
				System.out.printf("%c",'$');
			else
				System.out.printf("%c",str.charAt(i));
		}

	}

}
