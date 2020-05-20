package may_20;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.
		
		int max = 0;
		int min = 0;
		
		//1번째 입력
		//min = max = num = sc.nextInt();
		//2번째 입력 [for(int i = 2; i <= 10; i++)]
		//num = sc.nextInt();
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("입력%d: ",i);
			int num = sc.nextInt();
			
			if(i == 1) min = max = num;
			else {
				if(num > max) max = num;
				if(num < min) min = num;
			}
		}
		
		System.out.println();
		System.out.printf("최소값 : %d\n", min);
		System.out.printf("최대값 : %d", max);
	}
}