public class B extends A{
	private int m;

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
	
	public String toString() {
		String s = getN() + " " + getM();
		return s;
	}
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		b.m = 5;
		
		b.setN(10);
		int i = b.getN();
		
		b.setM(20);
		System.out.println(b.toString());
	}
}