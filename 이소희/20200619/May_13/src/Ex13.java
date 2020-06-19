import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		//Q2> 입력 받은 문자가 알파벳 대문자면 1을, 아니면 0을 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		char ch = sc.nextLine().charAt(0);
		
		if (ch >=65 && ch<=90) //(ch >='A' && ch<='Z') 이렇게 해도 가능!
			System.out.println(1);
		else System.out.println(0);

	}

}
