package ex03;

public class MyColorPoint extends MyPoint {

	public MyColorPoint(int i, int j, String color) {
		super(i, j);
		System.out.println(i + "," + j + "," + color);

	}

	@Override
	protected void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	@Override
	protected void reverse() {
		int temp = x;
		x = y;
		y = temp;

	}

	public static void main(String[] args) {

		MyPoint p = new MyColorPoint(2, 3, "blue");
		p.move(3, 4);
		p.reverse();
		p.show();
	}

}
