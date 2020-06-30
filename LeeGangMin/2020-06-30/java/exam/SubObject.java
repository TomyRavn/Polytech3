package exam;

class SuperObject {
	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.print("부모");
		System.out.println(name);
	}
}

public class SubObject extends SuperObject{
	protected String name;
	
	public void test() {
		System.out.println("테스트");
	}
	
	@Override
	public void draw() {
		System.out.print("자식");
		name = "Sub";
		super.name = "Super";
		super.draw();
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		SubObject b = new SubObject();
		b.paint(); //->b.paint 의 draw는 자식 객체의 draw 메소드를 호출(자식 클래스 기반의 객체에서 호출한 메소드는 자식 클래스의 메소드를 호출)
		System.out.println("*");
//		b.draw();
		
		SuperObject a = new SuperObject();
		a.draw();	//부모 클래스 기반의 객체에서 호출한 메소드는 부모 자신의 메소드를 호출
		//a.test(); //자식 객체에서 추가로 포함시킨 메소드는 부모 클래스 참조변수에서 사용불가
					//재정의 내린 메소드는 사용가능하다
	}
}