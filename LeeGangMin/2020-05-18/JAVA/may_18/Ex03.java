import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�߰���� ���� �Է� > ");
		int middleScore = sc.nextInt();
		System.out.print("�⸻��� ���� �Է� > ");
		int finalScore = sc.nextInt();
		int average = (middleScore + finalScore) / 2;
		
		//1.
//		if (average >= 90) System.out.println("������ A����Դϴ�");
//		else if (average >= 80 && average < 90) System.out.println("������ B����Դϴ�");
//		else if (average >= 70 && average < 80) System.out.println("������ C����Դϴ�");
//		else if (average >= 60 && average < 70) System.out.println("������ D����Դϴ�");
//		else System.out.println("������ F����Դϴ�");
		
		//2.
		String result = average >= 90? "A":
			(average >= 80 && average<90)? "B":
				(average >= 70 && average<80)? "C":
					(average >= 60 && average<70)? "D":"F";
		System.out.printf("������ %s����Դϴ�", result);
	}
}