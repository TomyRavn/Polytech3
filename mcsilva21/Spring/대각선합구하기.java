import java.util.Scanner;

public class 대각선합구하기 {

	public static void main(String[] args) {
		//난수를 통해 발생시킨 값을  3행3열로 저장한 후  대각선의 합을 출력하여라

	
			int[][] arr = new int [3][3];
			int sum=0;
			
			for (int i=0; i <arr.length; i++) {//행	
				for (int j=0; j<arr[i].length; j++) { //열	
					arr[i][j] = (int) (Math.random()*101);
//					arr[2][2]=arr[0][0]+arr[1][1];
//					arr[2][0]=arr[0][2]+arr[1][1];	
					if(i==j)
						sum += arr[i][j];
				}					
		} 		
			for (int i=0; i <arr.length; i++) {
				for (int j=0; j<arr[i].length; j++) {
					System.out.printf("%7d",arr[i][j]);
				}
			System.out.println();
			

	}
			System.out.println("대각선합:"+sum);
	}
}
