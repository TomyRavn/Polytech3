public class Circle {
	int radius;
	void set(int r) { radius = r; }
	double getArea() { return 3.14*radius*radius; }
	
//	public Circle(int r) {
//		radius = r;
//	}
	
	public Circle() {
		
	}
	
	//필드와 매개변수명이 동일한 경우 매개변수를 우선으로 한다.
//	public Circle(int radius) {
//		radius = radius;
//	}
	
	//this = 자기참조 레퍼런스, 객체의 주소(클래스 내부에서만 사용가능한 레퍼런스)
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public static void main(String[] args) {
		Circle pizza = new Circle(10);
		System.out.println(pizza.getArea());
		
		Circle donut = new Circle();
		System.out.println(donut.getArea());
	}
}