public class Ex1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		boolean bool;
		
		bool = x > y;
		System.out.println("결과: " + bool);
		//false
		bool = x < y;
		System.out.println("결과: " + bool);
		//true
		bool = x >= y;
		System.out.println("결과: " + bool);
		//false
		bool = x <= y;
		System.out.println("결과: " + bool);
		//true
		bool = x == y;
		System.out.println("결과: " + bool);
		//false
		bool = x != y;
		System.out.println("결과: " + bool);
		//true
		System.out.println("결과: " + !bool);
		//false
	}
}