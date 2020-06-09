
//Person class는 메인 메소드가 없는 라이브러리 클래스이다.
public class Person {
	public String name;
	public int age;
	
	//생성자
	public Person() {
		
	}
	
	public Person(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
}