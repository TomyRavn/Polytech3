import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//정수형 year를 입력받고
		//윤년 구별(4로 나누어 떨어지며 100으로 나누어 떨어지지 않을 시 혹은 400으로 나누어 떨어지는 년도는 윤년)
		//윤년이면 true
		//산술관계논리연산자로
		Scanner sc = new Scanner(System.in);
		int year;					//사용자에게 입력 받는 임의의 변수
		boolean yoonYear = false;	//윤년인지 아닌지 저장하는 boolean 변수
		
		//년도 입력받는 부분
		System.out.print("년도를 입력하세요 > ");
		year = sc.nextInt();
		
		//윤년 구별해주는 조건식
		//1.
		yoonYear = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
		
		//2.
//		if((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
//			yoonYear = true;	//① 4로 나누어 떨어지고 100으로 나누어 떨어지지 않을 시 ② 또는 400으로 나누어 떨어질 시
//		}						//윤년이므로 boolean 변수를 true로 저장
		
		System.out.println(yoonYear);	//윤년이면 true로 출력하고, 아니면 false로 출력
										//초기화를 false로 했으므로, 조건식에 해당하지 않으면 false로 기본 출력됨
	}
}