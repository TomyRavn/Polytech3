package may_20;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.
		
		int max = 0;
		int min = 0;
		
		//1��° �Է�
		//min = max = num = sc.nextInt();
		//2��° �Է� [for(int i = 2; i <= 10; i++)]
		//num = sc.nextInt();
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("�Է�%d: ",i);
			int num = sc.nextInt();
			
			if(i == 1) min = max = num;
			else {
				if(num > max) max = num;
				if(num < min) min = num;
			}
		}
		
		System.out.println();
		System.out.printf("�ּҰ� : %d\n", min);
		System.out.printf("�ִ밪 : %d", max);
	}
}