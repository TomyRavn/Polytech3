
public class Test {
	
	public static int add(int x, int y) {
		return x+y;
	}
	
	public static int getSum(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int result = add(a,b);
		
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			System.out.println(arr[i]);
		}
		
		int result2 = getSum(arr);
		
		
		System.out.println(result2);
	}

}
