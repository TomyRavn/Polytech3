package kr.ac.kopo.exapp;

import java.util.Scanner;

public class exTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double num1;
		double num2;
		String Operator;
		
		//1개의 Scanner로 다른 형태의 입력을 처리하려고 할 경우 건너뛰며 입력 안 되는 문제 발생
		//2개의 Scanner를 선언하여 쓰던지 형변환으로 통일하여 해결
		System.out.println("첫번째 입력");
		num1 = sc.nextDouble();
		System.out.println("두번째 입력");
		num2 = sc.nextDouble();
		System.out.println("연산자 입력");
		Operator = sc.nextLine();
		System.out.println(num1 + ", " + num2+ ", " + Operator);
	}
}