import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		//마지막 열에 각 행의 합을 구하여 출력
		int[][] arr = new int[3][4];	
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d행 : ", i+1);
			for (int j = 0; j < arr[i].length-1; j++) {
				arr[i][j] = sc.nextInt();
				arr[i][3] += arr[i][j];	
				
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
	