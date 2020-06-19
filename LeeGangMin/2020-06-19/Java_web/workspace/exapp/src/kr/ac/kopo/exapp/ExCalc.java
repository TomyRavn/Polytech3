package kr.ac.kopo.exapp;

import java.util.Scanner;

public class ExCalc {
	public static void main(String[] args) {
		//1. "첫번째 숫자를 입력하세요"라고 출력하고 숫자를 입력받고,
		//"두번째 숫자를 입력하세요"라고 출력하고 숫자를 입력받고,
		//"연산자를 입력하세요 (+,-,*,/)"라고 출력하고 연산자를 입력받고,
		//첫번째입력한숫자 입력한연산자 두번째입력한숫자 = 연산결과
		//를 출력하도록 프로그램을 작성하세요.
		
		//2. +,-,*,/ 가 아닌 연산자를 입력한 경우,
		//"알 수 없는 연산자"를 출력하도록 프로그램을 작성하세요.
		Scanner sc = new Scanner(System.in);
		double firstNum;			//첫번째 입력받는 숫자
		double secondNum;			//두번째 입력받는 숫자
		String operator;			//연산자
		double result = 0;			//결과값(초기값 0으로 설정)
		boolean trueInput = true;	//연산자가 제대로 입력되었는지 판별하는 변수
		
		//형변환하는 형태로 작성
		System.out.println("첫번째 숫자를 입력하세요");
		String firstInput = sc.nextLine();
		firstNum = Integer.parseInt(firstInput);	//더블형 변수에 정수형으로 형변환한 이유 : 정수형으로 입력되었는지 자동으로 판별 가능(약식)
													//정수 입력 아닐 시 에러 발생
		System.out.println("두번째 숫자를 입력하세요");
		String secondInput = sc.nextLine();
		secondNum = Integer.parseInt(secondInput);	//더블형 변수에 정수형으로 형변환한 이유 : 정수형으로 입력되었는지 자동으로 판별 가능(약식)
		
		System.out.println("연산자를 입력하세요 (+,-,*,/)");
		operator = sc.nextLine();
		
		if(operator.equals("+")) {
			result = firstNum + secondNum;
		}
		else if(operator.equals("-")) {
			result = firstNum - secondNum;
		}
		else if(operator.equals("*")) {
			result = firstNum * secondNum;
		}
		else if(operator.equals("/")) {
			result = firstNum / secondNum;
		}
		else {
			System.out.println("알 수 없는 연산자 입력됨");
			trueInput = false;						//연산자를 제대로 입력하지 않은 경우
			
			//또는 이 이후로 할 일이 없으므로 프로그램 종료(현재 메소드 종료)시키는 명령어 입력
			//return;  ->  아래쪽 실행 X
		}
		
		if(trueInput) {								//연산자 입력이 제대로 입력된 경우에만 true로 유지되기 때문에 해당 경우에만 출력 
			System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
		}
	}
}