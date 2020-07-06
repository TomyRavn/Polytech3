package july_06;

public class Ex06 {

	public static void main(String[] args) {
		String str = "    한글 ABCD efgh    ";		//앞뒤와 중간에 공백이 있으며, 한글과 영문 대문자, 소문자가 섞여있는 문자열
		
		System.out.println("원 문자열 ==> [" + str + "]");			
		System.out.println("대문자로 ==> [" + str.toUpperCase() + "]");		//대문자로 바꾼다.
		System.out.println("소문자로 ==> [" + str.toLowerCase() + "]");		//소문자로 바꾼다.
		System.out.println("공백제거 ==> [" + str.trim() + "]");				//공백을 제거한다.
	}

}
