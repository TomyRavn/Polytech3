public class Ok {
	int x, y;
	
	public Ok() {
		y = 20;
	}
	
	//생성자 사용 이유 : 객체를 생성하는 과정에서 초기화 작업을 하기 위해서
	public static void main(String[] args) {
		Ok obj = new Ok();
		obj.x = 10;
		
		System.out.printf("Field x : %d, Field y : %d", obj.x, obj.y);
	}
	
	//컴파일러는 개발자에 의해서 해당 클래스와 동일한 이름의 만들어진 생성자가 있을 경우에는 기본생성자를 자동생성하지 않음
	//컴파일러가 기본생성자를 만드는 경우는 해당 클래스 내부에 어떤 생성자도 생성하지 않은 경우에만 한정됨
}