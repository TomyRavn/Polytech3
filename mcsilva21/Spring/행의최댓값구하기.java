import java.util.Scanner;

public class 행의최댓값구하기 {

	public static void main(String[] args) {
		//난수를 통해 발생시킨 값을  3행3열로 저장한 후  대각선의 합을 출력하여라

	
			int[][] arr = new int [3][3];
			

			for (int i=0; i <arr.length; i++) {//행
				for (int j=0; j<arr[i].length; j++) { //열
					arr[i][j] = (int) (Math.random()*101);	
					System.out.printf("%4d",arr[i][j]);
					}				
				System.out.println();					
					}													
				System.out.println();	
				for (int i=0; i <arr.length; i++) {
					int max = arr[i][0];
					
				for (int j=1; j<arr[i].length; j++) {
					if(max<arr[i][j])
						max=arr[i][j];
				}
					System.out.printf("%d행의 최댓값: %d\n",i+1,max);		
				}				
												
	}							
				
				
						
	}

