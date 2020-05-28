
public class Ex18 {
	public static void main(String[] args) {
		System.out.printf("100+100");
		System.out.printf("\n");
		System.out.printf("%d",100+100);
		System.out.printf("\n");
		
		
		//System.out.printf("%d", 100, 200);
		//하나의 값을 삭제하던가 %d를 추가해야 한다.
		System.out.printf("%d %d", 100, 200);
		System.out.printf("\n");
		//System.out.printf("%d %d", 100);
		//하나의 값을 추가하던가 %d를 삭제해야 한다.
		System.out.printf("%d", 100);
		System.out.printf("\n");
		
		
		//System.out.printf("%d / %d = %.2f\n", 100, 200, 100/200); 에러! 100/200의 값이 정수이기 때문에 %.2f가 아니라 %d를 사용해야 한다.
		System.out.printf("%d / %d = %.2f\n", 100, 200, 100/200.0);
		System.out.printf("%d / %d = %.2f\n", 100, 200, (float)100/200.0);
		System.out.printf("%d / %d = %.2f\n", 100, 200, (double)100/200.0);
		
		System.out.printf("%d / %d = %d\n", 100, 200, 100/200);
		System.out.printf("%s\t%s","Hello", "Java");
		
		
		System.out.printf("%d\n", 123);
		System.out.printf("%5d\n", 123);
		System.out.printf("%05d\n", 123);
		
		System.out.printf("%f\n", 123.45);
		System.out.printf("%7.1f\n", 123.45); //소수점 첫 째 짜리 까지 출력, 단 소수점은 반올림!
		System.out.printf("%7.3f\n", 123.45); //소수점 셋 째 짜리 까지 출력
		
		System.out.printf("%s\n","Hi~Java");
		System.out.printf("%10s\n","Hi~Java"); //오른쪽으로 10칸 띄기, -n은 왼쪽으로 n칸 띄기
		
		System.out.printf("\n줄바꿈\n연습\n");
		System.out.printf("\t탭키\t연습\n");
		System.out.printf("글자가\"강조\"되는 효과\n");
		System.out.printf("\\\\\\ 역슬래시 세 개 출력\n");
		
	}

}
