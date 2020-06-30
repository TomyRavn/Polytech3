package shape;

public class ShapeEx {
	public static void main(String[] args) {
		Line ln = new Line();
		ln.draw();
		
		Shape sh = new Circle();
		sh.draw();
		
		sh.test();
	}
}