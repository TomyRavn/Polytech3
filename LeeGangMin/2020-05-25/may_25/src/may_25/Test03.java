package may_25;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//�������� ���� 5�� �Է¹޾� ������� ����
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];
		int sum = 0;
		
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d��° �л��� ���� ���� ������ �Է��ϼ��� : ", i + 1);
			score[i] = Integer.parseInt(sc.nextLine());
			sum += score[i];
		}
		
		System.out.printf("%d���� ��� ���� : %.1f", score.length, (double)sum / score.length);
		
	}
}