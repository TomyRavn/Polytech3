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
//		Student s = new Student("���繮");
//		p = s;	//��ĳ����
		
		//(2)
		Person p = new Student("���繮");
		
		System.out.println(p.name);
		
		//�θ� Ŭ�������� �ڽ� Ŭ������ �ʵ�� ����� �� ����.
//		p.grade = "A";				//������ ����
//		p.department = "Com";
		
		Student s1 = (Student) p;
		s1.grade = "A";
		s1.department = "Com";
	}
}