public class Ex02 {
	public static void main(String[] args) {
		String[] strArray = new String[3];
		
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		
		strArray[0] = "Java";
		strArray[1] = "C++";
		strArray[2] = "C#";
		
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		
	}
}