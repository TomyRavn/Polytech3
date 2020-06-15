public class Ex02 {
	
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static int comSum(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
//	...a 정수형 데이터 여러개를 받을 수 있는 매개변수(갯수가 정해져있지않음)
	public static int comSum1(int ...a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		int result = add(10, 20);
		System.out.printf("Result : %d\n", result);
		
		
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		int result1 = comSum(arr);
		int result2 = comSum1(10, 20, 30, 40, 50);
		System.out.printf("Result1 : %d\n", result1);
		System.out.printf("Result2 : %d\n", result2);
	}
	
	
	//메소드 오버로딩
	//매개변수의 *개수나 *타입이 서로 다르고
	//이름은 동일
	
	
	//다른 패키지에 있는 클래스를 쓰려면
	//public, protected + 상속받은 자식클래스, 패키지 이동
}