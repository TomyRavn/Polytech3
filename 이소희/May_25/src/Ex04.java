import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int [] arr = {10, 20, 30, 40, 50};
	
		
		
		
//		int[] a;
//		a = new int[5];
		//or
		int[] a = new int[] {10, 20, 30, 40, 50};
		
//		for(int i = 0; i<arr.length; i++) {
//			System.out.printf("%5d", arr[i]);
		
		for(int i = 0; i<a.length; i++) {
			System.out.printf("정수%d: ", i+1);
			a[i] = sc.nextInt();
		}
		for(int i = 0; i<a.length; i++) {
			System.out.printf("%4d", a[i]);

	}
	}
}
