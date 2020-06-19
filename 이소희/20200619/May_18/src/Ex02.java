import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//근로 소득세를 계산하는 프로그램을 작성하여보자. 근로소득세율은 다음 표와 같다.
//		1000만원 이하 = 8%
//		1000만원 초과 4000만원 이하 = 17%
//		4000만원 초과 8000만원 이하 = 26%
//		8000만원 초과 = 35%
		
		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력하세요.(단위: 만 원)");
		double x = sc.nextDouble();
		
		if(x<=1000)
			System.out.printf("근로 소득세 : %.0f 원 입니다.\n", x*0.08);
		else if(x<=4000)
			System.out.printf("근로 소득세 : %.0f 원 입니다.\n", x*0.17);
		else if(x<=8000)
			System.out.printf("근로 소득세 : %.0f 원 입니다.\n", x*0.26);
		else
			System.out.printf("근로 소득세 : %.0f 원 입니다.\n", x*0.35);

	}

}
