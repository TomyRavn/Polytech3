import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// 절대평가로 학생들의 학점을 계산하는 프로그램을 작성하여 보자.
		//두 점수의 평균이 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 나머지는 F다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score1 = sc.nextInt();
		System.out.println("점수를 입력하세요.");
		int score2 = sc.nextInt();
		
		double result = (score1+score2)/2;
		
		if (result >= 90)
			System.out.println("A입니다.");
		else if (result >= 80)
			System.out.println("B입니다.");
		else if (result >= 70)
			System.out.println("C입니다.");
		else if (result >= 60)
			System.out.println("D입니다.");
		else if (result >= 50)
			System.out.println("E입니다.");
		else
			System.out.println("F입니다.");





	}

}
