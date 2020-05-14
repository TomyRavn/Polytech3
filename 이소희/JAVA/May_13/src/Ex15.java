import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력하세요.");
		int score = sc.nextInt();
		
		if(score >= 90) 
			System.out.println("A등급입니다.");
		else if (score >=80) 
			System.out.println("B등급입니다.");
		else if(score >=70)
			System.out.println("c등급입니다.");
		else if(score >= 60)
			System.out.println("D등급입니다.");
		else
			System.out.println("E등급입니다.");

	}

}
