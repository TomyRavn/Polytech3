import java.util.Scanner;
import java.text.DecimalFormat;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		System.out.println("자신의 과세 표준 금액을 입력해주세요 (만원 단위 생략)");
		Double money = sc.nextDouble();
		Double moneyTax = (double) 0;
		
		if(money <= 1000) moneyTax = money * 0.08;
		else if(money > 1000 && money <= 4000) moneyTax = money * 0.17;
		else if(money > 4000 && money < 8000) moneyTax = money * 0.26;
		else moneyTax = money * 0.35;
		
		System.out.println("근로 소득세 : "+ formatter.format(moneyTax * 10000) + "원 입니다");
	}
}