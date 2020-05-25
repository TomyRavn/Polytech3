package may_25;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//윤리과목 점수 5개 입력받아 평균점수 산출
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];
		int sum = 0;
		
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d번째 학생의 윤리 과목 점수를 입력하세요 : ", i + 1);
			score[i] = Integer.parseInt(sc.nextLine());
			sum += score[i];
		}
		
		System.out.printf("%d명의 평균 점수 : %.1f", score.length, (double)sum / score.length);
		
	}
}