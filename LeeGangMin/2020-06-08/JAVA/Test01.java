public class Test01 {
	public static int add(int x, int y) {
		return x + y;
	}
	
	//�迭 ��ü�� �ּҸ� �Ѱ���(Call by Reference)
	//arr�� a�� �ּҸ� ����(���������� ��)
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
//		int result = add(a, b);		//add��� �޼ҵ� �̸������ε� ȣ�Ⱑ��(static�� ��� ������)
//		
//		System.out.println(result);
		
		//2. Call by Reference
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 101);
		}
		
		//arr���� �迭��ü�� �ּҰ� ����Ǿ�����
		//�� �ּҸ� getSum���� ����
		int result = getSum(arr);
		System.out.println(result);
		
	}
}