import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//사용자가 정수 입력
		System.out.print("첫 번째 수를 입력해주세요 > ");
		int inputA = sc.nextInt();
		System.out.print("두 번째 수를 입력해주세요 > ");
		int inputB = sc.nextInt();
		//계산된 값 저장할 변수
		int resultPlus = 0;
		int resultMinus = 0;
		//두 수의 합은 그대로 계산
		resultPlus = inputA + inputB;
		//두 수의 차는 큰 수에서 작은 수를 뺀 값으로 한다
		if(inputA >= inputB) {
			resultMinus = inputA - inputB;
		}
		else {
			resultMinus = inputB - inputA;
		}
		//출력
		System.out.printf("두 수의 합 : %d\n두 수의 차 : %d", resultPlus, resultMinus);
	}
}