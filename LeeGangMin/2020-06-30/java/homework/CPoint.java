package homework;

public class CPoint {
	private int a;
	private int b;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	
	public CPoint(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	void show() {
		System.out.printf("(%s, %s)\n", a, b);
	}
	
	void showColor(String color) {
		System.out.printf("(%s, %s, %s)\n", a, b, color);
	}
}