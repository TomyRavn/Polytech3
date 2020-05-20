import java.util.Scanner;

public class Ex07_짝수갯구구하기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int result=0;
		
		while(true) {		
		System.out.println("정수를 입력 : (나가기 음수 입력)");
		int num1 =s.nextInt();
	
		if( num1 %2 == 0) //짝수조건
			result++;
				
			if(num1<0) {
				break;   //무한 루프를 빠져나오기 위한 조건
	}	
		}
		System.out.println("프로그램을 종료합니다.");
		System.out.println("짝수의 갯수:" + result);
}
	
}