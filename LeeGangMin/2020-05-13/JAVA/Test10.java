import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		//키와 몸무게를 입력받아, 정상인지 비만인지 출력하는 프로그램 작성
		//( 키 - 100 ) * 0.9 == 표준 체중
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키를 입력하세요 > ");
		double height = sc.nextInt();
		System.out.print("몸무게를 입력하세요 > ");
		double weight = sc.nextInt();
		double average_weight = (height - 100) * 0.9;
		
		//표준 체중 출력하는 테스트 함수
//		System.out.println(average_weight);
//		
//		if(average_weight >= weight) System.out.println("정상");
//		else System.out.println("비만");
		
		if(average_weight < weight)
			System.out.println("과체중");
		else if(weight >= average_weight -5 && weight <= average_weight + 5) //조건 자체를 연속으로 적용할 때 else if 사용
			System.out.println("표준");
		else
			System.out.println("저체중");		//==> 입력한 값이 if나 else if 를 만족하면 해당 if구문은 더이상 체크하지 않고 바로 빠져나옴
											//만약 if(10>=5){} if(10>=9){}와 같이 연속으로 개별 if문 작성이면 둘 다 체크되지만
											//if(10>=5){} else if(10>=9){}와 같이 작성되면 맨 처음의 if문만 체크가 됨
	}
}