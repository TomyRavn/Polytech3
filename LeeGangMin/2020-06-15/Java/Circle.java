public class Circle {
	int radius;
	void set(int r) { radius = r; }
	double getArea() { return 3.14*radius*radius; }
	
//	public Circle(int r) {
//		radius = r;
//	}
	
	public Circle() {
		
	}
	
	//�ʵ�� �Ű��������� ������ ��� �Ű������� �켱���� �Ѵ�.
//	public Circle(int radius) {
//		radius = radius;
//	}
	
	//this = �ڱ����� ���۷���, ��ü�� �ּ�(Ŭ���� ���ο����� ��밡���� ���۷���)
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