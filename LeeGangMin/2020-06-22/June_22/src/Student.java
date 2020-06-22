import java.util.Scanner;

public class Student extends Person{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.
//		Student stu = new Student();
//		System.out.print("이름 입력 > ");
//		stu.name = sc.nextLine();
//		System.out.print("나이 입력 > ");
//		stu.age = Integer.parseInt(sc.nextLine());
//		System.out.print("키 입력 > ");
//		stu.height = Integer.parseInt(sc.nextLine());
//		System.out.print("몸무게 입력 > ");
//		stu.setWeight(Integer.parseInt(sc.nextLine()));
		//2.
		Student stu2 = new Student();
		System.out.print("이름 입력 > ");
		String name = sc.nextLine();
		System.out.print("나이 입력 > ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("키 입력 > ");
		int height = Integer.parseInt(sc.nextLine());
		System.out.print("몸무게 입력 > ");
		int weight = Integer.parseInt(sc.nextLine());
		stu2.set(age, name, height, weight);
		
		System.out.println("-- 저장이 완료되었습니다.");
//		System.out.printf("[ 신상명세  ]\n이름 : %4s\n나이 : %4d세\n키 : %6dcm\n몸무게 : %3dkg\n", stu.name, stu.age, stu.height, stu.getWeight());
		System.out.printf("[ 신상명세  ]\n이름 : %4s\n나이 : %4d세\n키 : %6dcm\n몸무게 : %3dkg\n", stu2.name, stu2.age, stu2.height, stu2.getWeight());
	}
	
}