import java.util.Scanner;

public class Ex09_숫자입력하기 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);		
			System.out.println("정수를 입력 :");
			int num1 =s.nextInt();

			for(int j=1; j<=num1; j++) {   
				for(int i=1; i<=j; i++)			
					System.out.print(i);
					System.out.println();

	}

	}
	
}
