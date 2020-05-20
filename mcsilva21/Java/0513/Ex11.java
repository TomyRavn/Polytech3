import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("숫자를 입력하세요");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		
			if (x>y && y>z ) 
					System.out.println("최대값:"+x);
				if(x<y && y<z)  

					System.out.println("최대값:"+z);	
					if(x<y && y>z ) 
						System.out.println("최대값:"+y);	
								
	}
			
	
}
	
