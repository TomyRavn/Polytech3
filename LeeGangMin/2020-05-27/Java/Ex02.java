package may_27;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] scoreArray = new int[5];
		int sum = 0;
		//점수 5개 입력받아 평균값 구하기
		for(int i = 0; i < scoreArray.length; i++) {
			System.out.printf("%d번째 학생의 점수를 입력하세요.", i+1);
			scoreArray[i] = sc.nextInt();
			
			if(scoreArray[i] > 100 || scoreArray[i] < 0) {
				System.out.println("잘못된 입력, 다시 입력");
				i--;
				continue;
			}
			
			sum += scoreArray[i];
		}
		
		System.out.printf("평균 값 : %.1f", (double)sum / scoreArray.length);
	}
}