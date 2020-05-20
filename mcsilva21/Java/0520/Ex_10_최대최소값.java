import java.util.Scanner;

public class Ex_10_최대최소값 {

	public static void main(String[] args) {
	
			Scanner s = new Scanner(System.in);
			
			int n, min,max;	
			
			System.out.printf("입력%d:",1);
			min = max =n =s.nextInt();
			
			for(int i=2; i<=10; i++) {	
				
			System.out.printf("입력%d:",i);
			n = s.nextInt();
			
				if(max<n)
					max=n;
				
				if(min>n)
					min=n;
		}	
					
			System.out.printf("최대값:%d, 최소값:%d\n", max,min);
	
		
		
	}

	}


