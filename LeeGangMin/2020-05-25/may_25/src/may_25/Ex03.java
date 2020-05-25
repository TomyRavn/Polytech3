package may_25;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//1.
//		int[] arr = {10, 20, 30, 40, 50};
//		int[] a = new int[] {10, 20, 30, 40, 50}; -->대괄호에 값 입력 X
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.printf("%-5d", arr[i]);
//		}
		
		//2.
		int[] a;
		a = new int[5];
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("정수%d: ", i + 1);
			a[i] = sc.nextInt();
		}
	}
}