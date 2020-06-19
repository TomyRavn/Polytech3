import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// 3행 3열 2차원 배열 각 값에 1부터 100까지의 난수를 입력 시키고, 최대값 출력하기
		
			
		int[][] arr = new int[3][3];	
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
								
				arr[i][j] = (int) (Math.random() * 101);
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {	
			for (int j = 0; j < arr[i].length; j++) {			
					
				System.out.printf("%7d", arr[i][j]);
	
			}
			System.out.println();
			
		}
		System.out.println("최대 값 : " + max);
	}
}
	