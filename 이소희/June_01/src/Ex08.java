import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// 정수형 2차원의 44 배열을 이용하여 열의 합을 구하시오.(단, 배열의 원소는 입력을 받는다.)

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][4];	
		int sum = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			System.out.printf("%d행 : ", i+1);
			for (int j = 0; j < arr[i].length-1; j++) {
				arr[i][j] = sc.nextInt();
				arr[3][j] += arr[i][j];
				arr[i][3] += arr[i][j];
				arr[3][3] += arr[i][j];
			 
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




