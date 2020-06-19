import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		// x, y, z, 임의의 세 정수 값의 입력을 받아 가장 큰 값을 출력하시오.
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int max;
		
		max = x>y? x:y;
		max = max>z? max:z;
		System.out.printf("최댓값: %d\n", max);

	
	}
}
