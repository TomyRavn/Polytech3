import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//정수 5개 입력 받아 저장 후 총합 구해서 평균 구하기
		int[] score = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오.");

		int sum = 0;
		
		for(int i = 0; i<score.length; i++) {
			System.out.printf("정수%d:" ,i+1);
			score[i] = sc.nextInt();
			sum += score[i];
		}

			System.out.printf("전체 평균 점수 :%.2f\n",(double)sum/score.length);
		}
		

	}

