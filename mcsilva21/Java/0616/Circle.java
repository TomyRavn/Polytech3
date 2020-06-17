import java.io.ObjectInputStream.GetField;

public class Circle {
	static int radius;

	void set(int r) {
		radius = r;
	}

	double getArea() {
		return 3.14 * radius * radius;
	}

	public Circle(int radius) {
		this.radius = radius;
	}

	public Circle() {

	}

	public static void main(String[] args) {

		
		Circle[] c = new Circle[5];
		
		for (int i = 0; i < c.length; i++) {			
			c[i] = new Circle(i+1);			
			System.out.println(c[i].getArea());
			
		}
						
	}

}
