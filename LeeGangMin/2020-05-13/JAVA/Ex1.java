public class Ex1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		boolean bool;
		
		bool = x > y;
		System.out.println("���: " + bool);
		//false
		bool = x < y;
		System.out.println("���: " + bool);
		//true
		bool = x >= y;
		System.out.println("���: " + bool);
		//false
		bool = x <= y;
		System.out.println("���: " + bool);
		//true
		bool = x == y;
		System.out.println("���: " + bool);
		//false
		bool = x != y;
		System.out.println("���: " + bool);
		//true
		System.out.println("���: " + !bool);
		//false
	}
}