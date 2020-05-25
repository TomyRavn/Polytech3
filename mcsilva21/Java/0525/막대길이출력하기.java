import java.util.Scanner;

public class 막대길이출력하기 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);	
		
		for(int j=1; j<=10; j++) {
		System.out.printf("막대%d의길이 :",j);
		int n = s.nextInt();


			if(!(n>0 && n<51)) {
				 System.out.print("정수를 다시 입력하세요.");
				 j--;
			continue;

			} 
			
			for(int i=1; i<n; i++)
				 System.out.print("#");
			
			System.out.println();
		}
	}
}


