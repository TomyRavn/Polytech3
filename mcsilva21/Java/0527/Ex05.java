
public class Ex05 {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("프로그램 사용qjq");
			System.out.println("java Ex05 num1 num2");
			System.exit(0);
		}
		
		
//		if(args.length == 0)
//			System.out.println("넘겨받은 문자열 인수가 없습니다.!~");
//
//		else 
//			System.out.println("문자열이 있습니다!~");
		
		int n = Integer.parseInt(args[0]);
		int n1 = Integer.parseInt(args[1]);
		
		System.out.println(n+ "+" + n1 + "=" + (n+n1));
		

	}

}
