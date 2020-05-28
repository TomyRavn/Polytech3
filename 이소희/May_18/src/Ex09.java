import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		//철학 과목의 중간 고사 점수를 입력 받고, 전체 합을 구한다.
		//학생의 인원 수는 모른다. 음수를 입력하면 반복문을 빠져나오도록 한다.
		//전체 평균 점수는?
		
		Scanner sc = new Scanner(System.in);

		int stu = 1;
		int sum = 0;
		int score;
		
		while(true) {
			System.out.printf("%d번 학생 점수(나가가(음수 입력)):" , stu);
			score = sc.nextInt();

			if(score < 0) 
				break;
		}
			
			sum += score;
			stu++;
		
			double avg = (double) sum/stu;
			System.out.printf("철학과목 평균 점수: %.2f\n" , avg);

			
	

	}
	}



