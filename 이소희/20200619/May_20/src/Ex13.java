import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		// 10개의 정수를 입력 받아 최대값과 최소값을 구하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int n, min, max;
		System.out.printf("입력1:");
		min = max = n = sc.nextInt();
		
		for(int i=2; i<=10; i++) {
	
			System.out.printf("입력%d:", i);
			n = sc.nextInt();
			
			if(max<n)
				max=n;
			
			if(min>n)
				min=n;
	
		}
		System.out.printf("최대값:%d, 최소값:%d", max, min);
	}
}



