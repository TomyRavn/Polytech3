package monday;

class User {
	String name;
	String type;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String type) {
		this.name = name;
		this.type = type;
	}
}

class Student extends User {
	public Student() {

	}

	public Student(String name) {
		super(name);
	}
	
	public Student(String name, String type) {
		super(name, type);
	}
}

class Staff extends User {
	public Staff() {
		
	}

	public Staff(String name) {
		super(name);
	}
	
	public Staff(String name, String type) {
		super(name, type);
	}
}

class Citizen extends User {
	public Citizen() {
		
	}

	public Citizen(String name) {
		super(name);
	}
	
	public Citizen(String name, String type) {
		super(name, type);
	}
}

public class Test {

	public static void useLibrary(User user) {
		
		System.out.println(user.type + user.name + "이 도서관을 이용합니다.");

	}

//	public void useLibrary(Staff staff) {
//
//		System.out.println(staff.type + staff.name + "이 도서관을 이용합니다.");
//
//	}
//
//	public void useLibrary(Citizen citizen) {
//
//		System.out.println(citizen.type + citizen.name + "이 도서관을 이용합니다.");
//
//	}

	public static void main(String[] args) {

		//1.
////		Test tt = new Test();
//		User user = new Student("홍길동", "학생");
//		useLibrary(user); // Student s1 = new Student();
//
//		User user1 = new Staff("임꺽정", "교직원");
//		useLibrary(user1);
		
		//2.
		User user = new Staff();
		User user1 = new User();
		Citizen city01 = new Citizen();
		
		if(user instanceof Citizen) {
			city01 = (Citizen) user;
			System.out.println("OK~");
		}else {
			System.out.println("Not Ok~");
		}
		
		if(user1 instanceof Citizen) {
			city01 = (Citizen) user1;
			System.out.println("OK~");
		}else {
			System.out.println("Not Ok~");
		}
		
		if(city01 instanceof User) {
//			city01 = (Citizen) user1;
			System.out.println("OK~");
		}else {
			System.out.println("Not Ok~");
		}


	}
}