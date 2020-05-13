public class Ex2 {
	//조건 연산자
	public static void main(String[] args) {
		int x = 20;
		int y = 50;
		int max;
		
		//조건식? True_value:False_value; //조건식 다음에는 ?를 반드시 써야함
		//참에 해당하는 값을 ?(QuestionMark) 바로 다음에, 거짓에 해당하는 값을 :(Colon) 다음에 배치
		max = x>y? x:y;	//x>y 조건식이 참이면 x를 리턴, 거짓이면 y를 리턴
		System.out.printf("최댓값:%d\n", max);
	}
}