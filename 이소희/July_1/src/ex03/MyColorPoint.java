package ex03;

public abstract class MyColorPoint extends MyPoint {

	public MyColorPoint(int x, int y, String color) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		MyPoint p = new MyColorPoint(2, 3, "blue");
		p.move(3, 4);
		p.reverse();
		p.show();
	}

}
