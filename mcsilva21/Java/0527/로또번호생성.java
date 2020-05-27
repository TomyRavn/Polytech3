import java.util.Scanner;

public class 로또번호생성 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		
		
		int[] arr = new int[6];

		int temp=0;
	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*46);
			 i=temp;
			 
			 System.out.print(arr[i]+" ");
		  
		}
         	
			
	}
						
		}
		
	
	
	


