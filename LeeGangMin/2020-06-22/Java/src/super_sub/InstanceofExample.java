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
		
		if(jee instanceof Student) System.out.println("jee�� StudentŸ��");
		
//		if(jee instanceof Researcher) System.out.println("jee�� ResearcherŸ��");
//		if(kim instanceof Student) System.out.println("kim�� StudentŸ��");
		
		if(kim instanceof Professor) System.out.println("kim�� ProfessorŸ��");
		if(kim instanceof Researcher) System.out.println("kim�� ResearcherŸ��");
		if(kim instanceof Person) System.out.println("kim�� PersonŸ��");
		
//		if(lee instanceof Professor) System.out.println("lee�� ProfessorŸ��");
		
		if("java" instanceof String) System.out.println("\"java\"�� StringŸ��");
	}
}