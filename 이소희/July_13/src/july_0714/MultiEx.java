package july_0714;

public class MultiEx {
	public static void main(String[] args) {
		A a = new MultiC();		
		a.methodA();
		
		
		B b = new MultiC();
		b.methodB();
		
		C c = new MultiC();
		c.methodA();
		c.methodB();
		c.methodC();
	}
}
