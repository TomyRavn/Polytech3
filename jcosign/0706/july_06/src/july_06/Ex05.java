package july_06;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str, strRep, strSub, strAry[];	//입력받는 문자열, 바꿀 문자열, 일부 문자열, 분리한 문자열 배열을 선언한다.
		
		System.out.println("문자열을 입력하세요.");
		str = s.nextLine();
		
		strRep = str.replace(" ", "$");		//입력 문자열의 공백을 $로 바꾼다.
		strSub = str.substring(2,8); 		//입력 문자열의 세 번째부터 여덟 번째 문자를 추출한다.
		strAry = str.split(" ");						//입력 문자열을 공백으로 분리한다.
		
		System.out.println("입력 문자열 ==> "+ str);
		System.out.println("바꾼 문자열 ==> "+ strRep);
		System.out.println("분리한 문자열 ==> "+ strSub);
		
		for(int i = 0; i<strAry.length; i++)
			System.out.println("분리한 문자열" + i + "==>" + strAry[i]);
	}

}
