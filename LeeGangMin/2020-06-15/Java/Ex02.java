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
	
//	...a ������ ������ �������� ���� �� �ִ� �Ű�����(������ ��������������)
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
	
	
	//�޼ҵ� �����ε�
	//�Ű������� *������ *Ÿ���� ���� �ٸ���
	//�̸��� ����
	
	
	//�ٸ� ��Ű���� �ִ� Ŭ������ ������
	//public, protected + ��ӹ��� �ڽ�Ŭ����, ��Ű�� �̵�
}