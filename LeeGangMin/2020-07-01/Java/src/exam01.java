public abstract class exam01 {
	//-추상 메소드
	//public void method(); 라고 선언만 하고 내부가 구현되어 있지 않은 메소드
	//서브클래스에서 오버라이딩하여 구현
	//
	//-추상 클래스 : 추상 메소드를 하나라도 가진 클래스
	// 클래스 앞에 반드시 abstract라고 선언해야 함
	// 추상 메소드가 하나도 없지만 클래스 앞에 abstract로 선언한 경우
	// => 확장 : interface
	//
	//추상클래스 기반으로는 객체를 단순 생성할 수 없음
	//예) DObject obj = new DObject();
	//추상 클래스를 상속받은 후 추상 메소드를 구현하지 않을 경우 추상클래스
	//구현할 경우 해당 서브 클래스는 추상클래스가 아님
	
	public abstract void draw();
}