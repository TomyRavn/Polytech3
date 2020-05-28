import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// 물리 점수 입력, 전체합 구하기 /빠져 나온 후 평균 출력, 음수 나오면 빠져나오기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("물리 점수를 입력하세요(실행 종료 시 음수를 입력하세요)>>");
		int score = sc.nextInt();
		int sum = 0;
		int stu = 0;
		
		do {sum += score;
			stu++;
			
			System.out.println("물리 점수를 입력하세요(실행 종료 시 음수를 입력하세요)>>");
			score = sc.nextInt();
		
			if(score < 0) 
				break;
		
		}while (true);
		System.out.printf("물리 점수 합 : %d\n" , sum);
		System.out.printf("물리 점수 평균 : %.2f" , (double)sum/stu);
	}

}
