import java.util.Scanner;

public class 입력받은숫자2차원배열로출력 {

	public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);	
		
		int[][] arr = new int [2][3];
		
		for (int i=0; i <arr.length; i++) {//행	
			System.out.printf("%d행:",i+1);
			for (int j=0; j<arr[i].length; j++) { //열	
				arr[i][j]=s.nextInt();					
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