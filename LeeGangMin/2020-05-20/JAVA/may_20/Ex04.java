package may_20;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		//임의의 양의 정수를 반복 입력받아
		//그 중에 전체 짝수의 갯수를 출력하고
		//음수 입력시 반복을 빠져나오는 프로그램
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int countEven = 0;
		
		
		while(true) {
			System.out.print("입력하시오 [나가기('음수입력')] > ");
			num = sc.nextInt();
			
			if(num < 0) break;
			if(num != 0 && num % 2 == 0) countEven++;
		}
		System.out.printf("짝수 갯수 : %d", countEven);
	}
}