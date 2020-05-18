import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간고사 성적 입력 > ");
		int middleScore = sc.nextInt();
		System.out.print("기말고사 성적 입력 > ");
		int finalScore = sc.nextInt();
		int average = (middleScore + finalScore) / 2;
		
		//1.
//		if (average >= 90) System.out.println("학점은 A등급입니다");
//		else if (average >= 80 && average < 90) System.out.println("학점은 B등급입니다");
//		else if (average >= 70 && average < 80) System.out.println("학점은 C등급입니다");
//		else if (average >= 60 && average < 70) System.out.println("학점은 D등급입니다");
//		else System.out.println("학점은 F등급입니다");
		
		//2.
		String result = average >= 90? "A":
			(average >= 80 && average<90)? "B":
				(average >= 70 && average<80)? "C":
					(average >= 60 && average<70)? "D":"F";
		System.out.printf("학점은 %s등급입니다", result);
	}
}