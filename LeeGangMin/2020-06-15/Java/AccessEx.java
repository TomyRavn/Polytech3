class Sample {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void setD(int d) {
		this.d = d;
	}
	
	public int getD() {
		return d;
	}
}

public class AccessEx extends Sample{
	public static void main(String[] args) {
		Sample aClass = new Sample();
		aClass.a = 10;
		aClass.b = 10;
		aClass.c = 10;
		aClass.setD(10);
		
		System.out.printf("%d, %d, %d, %d", aClass.a, aClass.b, aClass.c, aClass.getD());
	}
}

//클래스의 용도
//1. 라이브러리 : 만들어놓고 이용
//2. 실행용 : main() 메소드를 가지고 있는 실행할 목적으로 만든 클래스



//static 키워드가 붙은 필드는
//자바 프로그램을 실행하면 JVM에 의해서 스택에 생성
//힙영역에 객체가 생성되지 않아도 METHOD AREA영역에 만들어짐
//METHOD AREA영역에 하나만 생성됨

//인스턴스 필드는 객체를 그때그때 생성할 때마다 비례해서 힙 영역에 생성

//Static 필드(정적 멤버)는 객체를 생성하지 않고도 클래스이름을 통해서 다이렉트로 접근 및 활용이 가능
