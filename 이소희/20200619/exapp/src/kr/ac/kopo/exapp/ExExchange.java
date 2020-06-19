package kr.ac.kopo.exapp;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExExchange {
	public static void main(String[] args) {
		//쉼표 및 소수점 자릿수 표기방식 지정(소수점 둘째자리 까지 출력하며 아랫수는 반올림)
		DecimalFormat formatter = new DecimalFormat("###,###.##");
		
		//1.
		//"달러 금액을 입력하세요."라고 출력하고, 금액 입력 받고,
		//1달러 == 1216.90원 환율에 맞춰서 계산하여
		//"????원" 이라고 출력하는 프로그램을 작성하세요.
		Scanner sc = new Scanner(System.in);
		Double inputDollarAmount;		//입력 받은 달러 금액
		Double wonAmount;				//환율 적용된 원화 금액
		Double buyWonAmount;			//현찰 사실 때
		Double sellWonAmount;			//현찰 파실 때
		Double sendWonAmount;			//송금 보내실 때
		Double receiveWonAmount;		//송금 받으실 때
														/*===== String 입력 받아 형변환 시===== */
		System.out.print("달러 금액을 입력하세요. > ");		//inputDollarAmount = sc.nextLine();
		inputDollarAmount = sc.nextDouble();			//double wonAmount = Double.parseDouble(inputDollarAmount) * 1216.90; 소수점 아래 쓰레기값 발생가능
		wonAmount = inputDollarAmount * 1216.90;
		System.out.println(formatter.format(wonAmount) + "원");
		System.out.println("============================");
		
		//2.
		//아래 환율을 사용하여,
		//현찰 사실때, 현찰 파실때, 송금 보내실때, 송금 받으실때 금액도 출력
		//현찰 사실때 1,238.19원
		//현찰 파실때 1,195.61원
		//송금 보내실때 1,228.80원
		//송금 받으실때 1,205.00원
		buyWonAmount = inputDollarAmount * 1238.19;
		sellWonAmount = inputDollarAmount * 1195.61;
		sendWonAmount = inputDollarAmount * 1228.80;
		receiveWonAmount = inputDollarAmount * 1205.00;
		
		System.out.println("현찰 사실 때 : " + formatter.format(buyWonAmount) + "원");
		System.out.println("현찰 파실 때 : " + formatter.format(sellWonAmount) + "원");
		System.out.println("송금 보내실 때 : " + formatter.format(sendWonAmount) + "원");
		System.out.println("송금 받으실 때 : " + formatter.format(receiveWonAmount) + "원");
	}
}