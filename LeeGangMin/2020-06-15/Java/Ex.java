class StaticSample{
	public int n;				//instance member
	public void g() {
		m = 20;
	}
	public void h() {
		m = 30;
	}
	public static int m;
	public static void f() {
		m = 5;
	}
}

public class Ex {
	public static void main(String[] args) {
		//1.
//		StaticSample s1, s2;
//		s1 = new StaticSample();
//		s1.n = 5;
//		s1.g();
//		s1.m = 50;
//		s2 = new StaticSample();
//		s2.n = 8;
//		s2.h();
//		s2.f();
//		System.out.println(s1.m);
//		System.out.println(s1.n);
//		System.out.println(s2.m);
//		System.out.println(s2.n);
		
		//static 필드이기 때문에 같은 메모리를 공유
		
		//2.
		StaticSample.m = 10;
		
		StaticSample s1;
		s1 = new StaticSample();
		System.out.println(s1.m);
		System.out.println(StaticSample.m);
		
		s1.h();
		System.out.println(s1.m);
		System.out.println(StaticSample.m);
		
		StaticSample.f();
		System.out.println(s1.m);
		System.out.println(StaticSample.m);
		
	}
}