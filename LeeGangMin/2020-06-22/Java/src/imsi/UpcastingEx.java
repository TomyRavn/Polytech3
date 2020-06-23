package imsi;

class Person{
	String name;
	String id;
	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person{
	String grade;
	String department;
	
	public Student(String name) {
		super(name);
	}
}

public class UpcastingEx {
	public static void main(String[] args) {
		//(1)
//		Person p;
//		Student s = new Student("이재문");
//		p = s;	//업캐스팅
		
		//(2)
		Person p = new Student("이재문");
		
		System.out.println(p.name);
		
		//부모 클래스에서 자식 클래스의 필드는 사용할 수 없다.
//		p.grade = "A";				//컴파일 오류
//		p.department = "Com";
		
		Student s1 = (Student) p;
		s1.grade = "A";
		s1.department = "Com";
	}
}