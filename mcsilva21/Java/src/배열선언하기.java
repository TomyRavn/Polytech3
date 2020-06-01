
public class 배열선언하기 {

	public static void main(String[] args) {
		
		String[] strArray = new String[3];
		for (int i = 0; i < strArray.length; i++) {
							
			strArray[0]="java";
			strArray[1]="C++";
			strArray[2]="c#";

			System.out.println(strArray[i]);
		}

	}

}