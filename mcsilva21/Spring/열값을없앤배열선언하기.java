import java.util.Scanner;

public class 열값을없앤배열선언하기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		
		int[][] arr = new int [2][];
		
		for (int i=0; i <arr.length; i++) {//행	
			System.out.println(arr[i]);			
			}	
		
		arr [0] = new int[3];
		arr [1] = new int[5];
		
		for (int i=0; i <arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.printf("%4d",arr[i][j]);
			}
		System.out.println();
	}
}
}



