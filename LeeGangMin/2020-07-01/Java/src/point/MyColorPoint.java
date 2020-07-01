package point;

public class MyColorPoint extends MyPoint{
	
	String color;
	
	public MyColorPoint(int x, int y, String color){
		super(x, y);
		this.color = color;
	}
	
	@Override
	protected void move(int x, int y) {
		super.x += x;
		super.y += y;
	}


	@Override
	protected void reverse() {
		int temp = super.x;
		super.x = super.y;
		super.y = temp;
	}
	
	public void show() {
		System.out.println(x + "," + y + "," + color);
	}
	
	public static void main(String[] args) {
		MyPoint p = new MyColorPoint(2, 3, "blue");
		
		p.move(3, 4);
		p.reverse();
		p.show();
	}

}