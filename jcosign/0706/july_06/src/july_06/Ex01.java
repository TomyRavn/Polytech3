package july_06;

public class Ex01 {

	public static void main(String[] args) {
		String str = "IT CookBook Java";	//문자열을 선언하고 대입한다.
		int len;							//문자열 배열과 길이를 저장할 변수를 선언한다.
		
		len = str.length();
		
		System.out.printf("문자열: %s \n", str);		//문자열을 출력한다.
		System.out.printf("문자열 길이: %d", len);		//문자열 길이를 출력한다.
	}

}
