public class Test3 {
	public static void main(String[] args) {
		//1부터 5까지 정수에 대하여 제곱 값과 세 제곱 값을 화면에 출력하는 프로그램 작성
		//(정수 값의 증가는 증감 연산자를 활용)
		int num=1;
		System.out.printf("%-6s %s\t %s\n", "Int", "Square", "Cube");
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		
//		System.out.printf("Int\t Square\t Cube\n");
//		for(int i = 1; i <= 5; i++) {
//			System.out.printf("%d\t %d\t %d\n", num, num*num, num*num*num);
//			num++;
//		}
	}
}