package may_20;

public class Ex03 {
	public static void main(String[] args) {
		//1.
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//2.
//		for(int i = 1; i <= 5; i++) {
//			for(int j = 1; j <= 5; j++) {
//				System.out.printf("(%d, %d)\n", i, j);
//			}
//			System.out.println();
//		}
		
		//3.
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//test¿ë
//		for(int i = 1; i <= 5; i++) {
//			for(int j = 1; j <= 6 - i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
	}
}