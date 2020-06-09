public class Test01 {
	public static int add(int x, int y) {
		return x + y;
	}
	
	//배열 객체의 주소를 넘겨줌(Call by Reference)
	//arr을 a에 주소를 복사(참조변수가 됨)
	public static int getSum(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		//1. Call by Value
//		int a = 10;
//		int b = 20;
//		int result = add(a, b);		//add라는 메소드 이름만으로도 호출가능(static을 썼기 때문에)
//		
//		System.out.println(result);
		
		//2. Call by Reference
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 101);
		}
		
		//arr에는 배열객체의 주소가 저장되어있음
		//그 주소를 getSum에서 받음
		int result = getSum(arr);
		System.out.println(result);
		
	}
}