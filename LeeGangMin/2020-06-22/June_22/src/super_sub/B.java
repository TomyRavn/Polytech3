package super_sub;

public class B extends A{
	void set() {
		
		//인스턴스 멤버이기 때문에 객체 생성 후 호출 가능 
		i = 1;
		pro = 2;
//		pri = 3;
		setPri(3);
		pub = 4;
		
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.set();
		
		System.out.println(b.i);
		System.out.println(b.pro);
		System.out.println(b.getPri());
		System.out.println(b.pub);
	}
}