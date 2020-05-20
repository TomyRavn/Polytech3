import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("중간고사 점수를 입력하세요."); 
		int score1 = scan.nextInt();
		System.out.println("기말고사 점수를 입력하세요."); 
		int score2 = scan.nextInt();
		
		double result =(score1+score2)/2;
		System.out.printf("평균은 %.0f점입니다.\n", result); 
		
		if(result>=90)
			System.out.println("당신의 학점은 A입니다");
		else if(result>=80)
			System.out.println("당신의 학점은 B입니다");
		else if(result>=70)
			System.out.println("당신의 학점은 C입니다");
		else
			System.out.println("당신의 학점은 D입니다");
		


	}

}
