import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// 3행 3열 2차원 배열 각 값에 1부터 100까지의 난수를 입력 시키고, 대각선 방향에 값을 출력하시오.
		// [0,0][1,1][2,2]
		
			
		int[][] arr = new int[3][3];	
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
								
				arr[i][j] = (int) (Math.random() * 101);
				if (i == j)
					sum += arr[i][j];}
			}	
	
	
		
		for (int i = 0; i < arr.length; i++) {	
			for (int j = 0; j < arr[i].length; j++) {			
					
				System.out.printf("%7d", arr[i][j]);
	
			}
			System.out.println();
			
		}
		System.out.println("대각선의 총합 : " + sum);
	}
}
	