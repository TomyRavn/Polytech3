package may_27;

public class Ex04 {
	public static void main(String[] args) {

		//1.
//		if(args.length == 0) {
//			System.out.println("넘겨받은 문자열 변수가 없습니다!!");
//		}else {
//			System.out.println("문자열이 있습니다~");
//		}
	
		//2.
//		int[] a = {};
//		System.out.println(a.length);
	
		//3.
//		System.out.println(args.length);
		
		//4.
		if(args.length != 2) {
			System.out.println("프로그램 사용법");
			System.out.println("java may_27.Ex04 num1 num2");
			System.exit(0);
		}
		
		int n = Integer.parseInt(args[0]);
		int n1 = Integer.parseInt(args[1]);
		
		System.out.println(n + " + " + n1 + " = " + (n+n1));
		
	}
	
}