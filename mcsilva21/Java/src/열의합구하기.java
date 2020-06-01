import java.util.Scanner;

public class 열의합구하기 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);	

			int[][] arr = new int [4][4];
			
			for (int i=0; i <arr.length-1; i++) {//행	
				System.out.printf("%d행 입력:",i+1);
				for (int j=0; j<arr[i].length-1; j++) { //열	
					arr[i][j]=s.nextInt();
					
					arr[i][3]+=arr[i][j];
					arr[3][j]+=arr[i][j];														
				}	
				
				arr[3][3]+=arr[i][3];
		} 		
			System.out.println();
			System.out.printf("\t     [결과]     ");
			System.out.println();
			for (int i=0; i <arr.length; i++) {
				for (int j=0; j<arr[i].length; j++) {
					System.out.printf("%7d",arr[i][j]);
				}
			System.out.println();
												
	}							
														
	}

}