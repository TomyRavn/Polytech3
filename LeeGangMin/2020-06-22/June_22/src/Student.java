import java.util.Scanner;

public class Student extends Person{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.
//		Student stu = new Student();
//		System.out.print("�̸� �Է� > ");
//		stu.name = sc.nextLine();
//		System.out.print("���� �Է� > ");
//		stu.age = Integer.parseInt(sc.nextLine());
//		System.out.print("Ű �Է� > ");
//		stu.height = Integer.parseInt(sc.nextLine());
//		System.out.print("������ �Է� > ");
//		stu.setWeight(Integer.parseInt(sc.nextLine()));
		//2.
		Student stu2 = new Student();
		System.out.print("�̸� �Է� > ");
		String name = sc.nextLine();
		System.out.print("���� �Է� > ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("Ű �Է� > ");
		int height = Integer.parseInt(sc.nextLine());
		System.out.print("������ �Է� > ");
		int weight = Integer.parseInt(sc.nextLine());
		stu2.set(age, name, height, weight);
		
		System.out.println("-- ������ �Ϸ�Ǿ����ϴ�.");
//		System.out.printf("[ �Ż��  ]\n�̸� : %4s\n���� : %4d��\nŰ : %6dcm\n������ : %3dkg\n", stu.name, stu.age, stu.height, stu.getWeight());
		System.out.printf("[ �Ż��  ]\n�̸� : %4s\n���� : %4d��\nŰ : %6dcm\n������ : %3dkg\n", stu2.name, stu2.age, stu2.height, stu2.getWeight());
	}
	
}