
public class Ex13 {

	public static void main(String[] args) {
		int num1 = 12345780;
		int num2 = 12345780;
		
		double num3 = num2;
		num2 = (int)num3;
		
		int result = num1 - num2;
		System.out.println(result);
		

	}

}
