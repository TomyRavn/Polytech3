import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if(x % 2 == 0) 
			System.out.println("짝수");
		
		else System.out.println("홀수");
		System.out.printf("입력 받은 수는 %d 입니다.", x);
			
		
	}

}
