package super_sub;

class Person {}
class Student extends Person {}
class Researcher extends Person {}
class Professor extends Researcher {}

public class InstanceofExample {
	public static void main(String[] args) {
		Person jee = new Student();
		Person kim = new Professor();
		Person lee = new Researcher();
		
		if(jee instanceof Student) System.out.println("jee는 Student타입");
		
//		if(jee instanceof Researcher) System.out.println("jee는 Researcher타입");
//		if(kim instanceof Student) System.out.println("kim은 Student타입");
		
		if(kim instanceof Professor) System.out.println("kim은 Professor타입");
		if(kim instanceof Researcher) System.out.println("kim은 Researcher타입");
		if(kim instanceof Person) System.out.println("kim은 Person타입");
		
//		if(lee instanceof Professor) System.out.println("lee는 Professor타입");
		
		if("java" instanceof String) System.out.println("\"java\"는 String타입");
	}
}