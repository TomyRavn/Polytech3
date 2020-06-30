package shape;

public class Shape {
	public void draw() {
		System.out.println("Shape");
	}

	public void test() {
		System.out.println("Test");
	}
}

class Line extends Shape{
	@Override	//어노테이션 기법
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
	}
}

class Rectangle extends Shape{
	public void draw() {
		System.out.println("Rectangle");
	}
}

class Circle extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}