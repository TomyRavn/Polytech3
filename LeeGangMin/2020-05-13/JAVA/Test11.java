import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) {
		//5���� ��� ����
		//n���� ����� ������ n-1���� ������ �ʿ��ϴ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� > ");
		int score = sc.nextInt();
		
		if(score >= 90 && score <= 100) System.out.println("A");
		else if(score >= 80 && score < 90) System.out.println("B");
		else if(score >= 70 && score < 80) System.out.println("C");
		else if(score >= 60 && score < 70) System.out.println("D");
		else System.out.println("E");	//���� �Է��� ������ �Է¹��� �� ����
		
		//2. ���ǿ�����
//		String grade = (score>=90 && score<=100)?
//				"A":(score >= 80 && score < 90)?
//						"B": (score >= 70 && score < 80)? 
//								"C":(score >= 60 && score < 70)? 
//										"D":"E";
//		System.out.println(grade);
	}
}