package exam;

class Person{
	String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

class Professor extends Person{
	public String getPhone() {
		return "Professor : " + super.getPhone();
	}
}

public class Overriding{
	public static void main(String[] args) {
		Professor a = new Professor();
		a.setPhone("010-1111-1234");
		System.out.println(a.getPhone());
		Person p = a;
		System.out.println(p.getPhone());
	}
}