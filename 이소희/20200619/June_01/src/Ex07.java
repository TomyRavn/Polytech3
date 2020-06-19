import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// 3행 3열 2차원 배열 각 값에 1부터 100까지의 난수를 입력 시키고, 각 행의 최대값 출력하기
		
		int[][] arr = new int[3][3];			

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
								
				arr[i][j] = (int) (Math.random() * 101);	
				System.out.printf("%4d", arr[i][j]);
				
				}		
			
			System.out.println();
			}		
		System.out.println();
		
		
		for (int i = 0; i < arr.length; i++) {
			int max = arr[i][0];
			
		for (int j = 1; j < arr[i].length; j++) {
			if (max < arr[i][j])
				max = arr[i][j];
		}
			System.out.printf("%d행의 최대 값 : %d\n", i+1, max);
	}
	}

}
	