package June15;

class Sample {
	public int a;
	private int b;
	int c;
	
	public void setB(int b) {
		this.b = b;
	}
	
	public int getB() {
	return b;
}
}

public class AccessEx {

	public static void main(String[] args) {
		Sample aClass = new Sample();
		aClass.a = 10;
		aClass.setB(10);
		aClass.c = 10;

		int x = aClass.getB();
	}

}
