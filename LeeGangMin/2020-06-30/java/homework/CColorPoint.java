package homework;

public class CColorPoint extends CPoint{

	String color;
	
	public CColorPoint(int a, int b, String color) {
		super(a, b);
		this.color = color;
	}
	
	@Override
	void show() {
		showColor(color);
	}
	
	public static void main(String[] args) {
		CPoint a, b;
		
		a = new CPoint(2, 3);
		b = new CColorPoint(3, 4, "red");

		a.show();
		b.show();
	}
}