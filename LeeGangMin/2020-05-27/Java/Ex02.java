package may_27;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] scoreArray = new int[5];
		int sum = 0;
		//���� 5�� �Է¹޾� ��հ� ���ϱ�
		for(int i = 0; i < scoreArray.length; i++) {
			System.out.printf("%d��° �л��� ������ �Է��ϼ���.", i+1);
			scoreArray[i] = sc.nextInt();
			
			if(scoreArray[i] > 100 || scoreArray[i] < 0) {
				System.out.println("�߸��� �Է�, �ٽ� �Է�");
				i--;
				continue;
			}
			
			sum += scoreArray[i];
		}
		
		System.out.printf("��� �� : %.1f", (double)sum / scoreArray.length);
	}
}