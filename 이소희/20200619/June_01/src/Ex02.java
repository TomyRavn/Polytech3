import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//이 차원 배열 행열 값 입력 받아 출력하기
		

		Scanner sc = new Scanner(System.in);
		System.out.println("행 값을 입력하세요.");
		int num = sc.nextInt();
		System.out.println("열 값을 입력하세요.");
		int num2 = sc.nextInt();
		
		
		int[][] arr = new int[num][num2];
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num2; j++) {
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
		}

	}

}
