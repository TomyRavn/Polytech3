import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("���ڸ� �Է��ϼ���");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		
			if (x>y && y>z ) 
					System.out.println("�ִ밪:"+x);
				if(x<y && y<z)  

					System.out.println("�ִ밪:"+z);	
					if(x<y && y>z ) 
						System.out.println("�ִ밪:"+y);	
								
	}
			
	
}
	
