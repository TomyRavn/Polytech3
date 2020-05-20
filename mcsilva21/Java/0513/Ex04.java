import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		//3개의 정수값 x,y,z 가장 큰 값을 구함
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("숫자를 입력하세요");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		int max;
		
		max = x>y? x:y;
		max = max>z? max:z;
		
		// int max = (x>=y && x>=z)? x:(y>=x && y>=z)?y:z;)
			
		System.out.printf("최대값:%d\n", max);	

	}

}
