
public class Ex13 {
	public static void main(String[] args) {
		int num1 = 123456780;
		int num2 = 123456780;
		
		
		float num3 = num2;
		num2 = (int) num3;
		System.out.println(num1);
		System.out.println(num2);
		//num2는 double형이 아니라 123456780가 아니라 123456784가 출력된다.
		
				int result = num1 - num2;
				System.out.println(result);
	}

}
