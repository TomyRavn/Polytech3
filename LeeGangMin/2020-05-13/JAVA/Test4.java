import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		//물리, 역사, 철학 점수를 입력받아
		//세 점수가 70점 이상이면 '통과'
		//아니면 '다음 기회에' 문자열이 출력되는 프로그램 작성(단, 조건연산자를 이용하여 구함)
		
		int physics;
		int historic;
		int philosophy;
		String pass;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("물리 점수를 입력하시오 > ");
		physics = sc.nextInt();
		System.out.print("역사 점수를 입력하시오 > ");
		historic = sc.nextInt();
		System.out.print("철학 점수를 입력하시오 > ");
		philosophy = sc.nextInt();
		
		pass = (physics>=70 && historic>=70 && philosophy>=70) ? "통과":"다음 기회에";
		System.out.println(pass);
		
		//=== 방법 2 ===//
//		boolean bool_pass;
//		bool_pass = physics>=70 && historic>=70 && philosophy>=70;
		//출력 방법 ①
//		System.out.println(bool_pass? "통과":"다음 기회에");
		//출력 방법 ②
//		if(bool_pass) {
//			System.out.println("통과");
//		}
//		else {
//			System.out.println("다음 기회에");
//		}
		
		//=== 응용 ===//
//		물리 70점 이상이면 통과, 그렇지 않을 때는 역사와 철학 점수 모두 80점 이상이어야 통과
//		pass = physics>=70 ? "통과":(historic>=80 && philosophy>=80)? "통과" : "다음 기회에";
//		System.out.println(pass);		//pass를 안적고 pass에 대입하는 값을 그대로 출력하는 곳에 넣어도 됨
										//pass 대입 값 : (physics>=70 && historic>=70 && philosophy>=70) ? "통과":"다음 기회에"
	}
}