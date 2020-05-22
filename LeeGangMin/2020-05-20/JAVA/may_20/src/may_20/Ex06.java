package may_20;
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.printf("%d ", j);
			}
			System.out.println();
		}
	}
}