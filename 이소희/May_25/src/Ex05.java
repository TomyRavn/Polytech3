import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// 물리 점수 5개 입력 받아 평균 점수 구하기
		System.out.println("물리 점수를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];

		
		int sum = 0;
		
		
		for(int i = 0; i<score.length; i++) {
			System.out.printf("물리 점수%d: ", i+1);
			score[i] = sc.nextInt();
			sum += score[i];
			
		}
		double avg = (double)sum/score.length;
		System.out.printf("물리 점수 평균:%.2f\n" , avg);

	}

	}


