package June15;

	public class Circle2 {
	int radius;
	void set(int r) {radius = r;}
	double getArea() {return 3.14*radius*radius;}


	public Circle2(int radius) {
	this.radius = radius;
	}

	public Circle2() {
	}
	
	public static void main(String[] args) {
		Circle2[] c = new Circle2[5];
		
		for (int i = 0; i < c.length; i++) {
		c[i] = new Circle2(i+1);
		System.out.println(c[i].getArea());
		}
		

	}

	}
