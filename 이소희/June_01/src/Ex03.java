import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		//이 차원 배열의 행열 값 입력 받아 출력하기
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[2][3];	
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d행 : ", i+1);
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
				
			}	
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%7d", arr[i][j]);
				
			}
			System.out.println();
			
		}
	}
}

