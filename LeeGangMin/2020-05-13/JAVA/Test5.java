import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		//세 자리로 이루어진 십진수 양의 정수 값을 입력 받은 후에
		//각각의 자릿수를 분리하고
		//이 자릿 수를 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오 : ");
		int num = sc.nextInt();
		
		//1. num을 입력받고 num 값은 그대로 유지하면서 나머지 변수에 연산 값을 직접 넣어주는 방식
		int hundred = num / 100;
		int ten = (num-(hundred*100)) / 10;		//<=> int ten = num % 100 / 10;
		int one = num-(hundred*100)-(ten*10);	//<=> int one = num % 10;
		System.out.printf("백의 자릿수 : %d\n십의 자릿수 : %d\n일의 자릿수 : %d\n", hundred, ten, one);
		
		//2. num을 입력받고 num을 직접 나누면서 변화시켜서 처리하는 방식
//		int hundred = num / 100;
//		num = num - (hundred * 100);
//		int ten = num / 10;
//		num = num - (ten * 10);
//		int one = num;
//		System.out.printf("백의 자릿수 : %d\n십의 자릿수 : %d\n일의 자릿수 : %d\n", hundred, ten, one);
		
		//3. 직접 값 출력
//		System.out.printf("백의 자릿수 : %d\n", num/100);
//		System.out.printf("십의 자릿수 : %d\n", num%100/10);
//		System.out.printf("일의 자릿수 : %d\n", num%10);
	}
}