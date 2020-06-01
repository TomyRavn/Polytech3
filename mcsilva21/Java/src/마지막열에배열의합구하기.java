import java.util.Scanner;

public class 마지막열에배열의합구하기 {

	public static void main(String[] args) {
		
	Scanner s = new Scanner(System.in);	
	int sum=0;
		
		int[][] arr = new int [3][4];
		
		for (int i=0; i <arr.length; i++) {//행	
			System.out.printf("%d행:",i+1);
			for (int j=0; j<arr[i].length-1; j++) { //열	
				arr[i][j]=s.nextInt();
				arr[i][3]+=arr[i][j];
			}					
	} 		
		for (int i=0; i <arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.printf("%7d",arr[i][j]);
			}
		System.out.println();
	}
}
}