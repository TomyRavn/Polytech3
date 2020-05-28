import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		// 입력된 숫자로 트리 만들기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하시오.");
		int num = sc.nextInt();
		
		for(int j =1; j<=num; j++) {
		 	for(int i = 1; i <= j; i++)
		 		System.out.print(i);
		 		System.out.println();

	}
	}
}
