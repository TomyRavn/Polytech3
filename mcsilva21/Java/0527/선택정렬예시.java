import java.util.Scanner;

public class 선택정렬예시 {

	public static void main(String[] args) {				
//	
		int[] arr = new int[5];

		int temp=0;
	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
		}
			
		for(int i=0; i<arr.length; i++) {
			int m=i;
			
			for(int j=i+1; j<arr.length; j++ ) {
				if(arr[m]> arr[j])
					m=j;								
			}
			
			temp = arr[i];
			arr[i] = arr[m];
			arr[m] = temp;
								
		}
		
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+" ");
		}
			
							
													
		}						
	}


