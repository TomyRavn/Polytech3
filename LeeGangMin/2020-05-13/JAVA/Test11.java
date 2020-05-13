import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) {
		//5개의 등급 구별
		//n개의 등급이 있으면 n-1개의 조건이 필요하다
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성적을 입력하세요 > ");
		int score = sc.nextInt();
		
		if(score >= 90 && score <= 100) System.out.println("A");
		else if(score >= 80 && score < 90) System.out.println("B");
		else if(score >= 70 && score < 80) System.out.println("C");
		else if(score >= 60 && score < 70) System.out.println("D");
		else System.out.println("E");	//변수 입력해 변수로 입력받을 수 있음
		
		//2. 조건연산자
//		String grade = (score>=90 && score<=100)?
//				"A":(score >= 80 && score < 90)?
//						"B": (score >= 70 && score < 80)? 
//								"C":(score >= 60 && score < 70)? 
//										"D":"E";
//		System.out.println(grade);
	}
}