package may_27;

public class Ex03 {
	public static void main(String[] args) {
		int[] a = new int[] {10, 20, 30, 40, 50};
		
		int result = test(a);
		System.out.printf("Result:%d\n", result);
		
	}
	
	
	public static int test(int[] b) {
		int sum = 0;
		
		for (int i = 0; i < b.length; i++) {
			sum += b[i];
		}
		
		return sum;
	}
}