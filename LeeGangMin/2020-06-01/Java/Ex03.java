import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {10, 20, 30, 40, 50};
		int[] brr = new int[10];
		
		//1.
//		brr = arr;
//		//arr�� �ּҰ��� brr�� �ּҰ��� �Ҵ�Ǿ����Ƿ� brr�� arr�� ����Ű�� ��ü�� �����ϰ� �ٲ�
//		//length�� 10�� ������ brr �迭�� ��ǵǾ� ���̻� �� �� ����
//		for (int i = 0; i < brr.length; i++) {
//			System.out.printf("%5d", brr[i]);
//		}
		
		//2.
//		for (int i = 0; i < arr.length; i++) {
//			brr[i] = arr[i];
//		}
//		
//		for (int i = 0; i < brr.length; i++) {
//			System.out.printf("%5d", brr[i]);
//		}
		
		//3.�Ű�����
//		//(������ ���, ����� �� ��°���� ������ ���ΰ�, �Űܴ��� ���(������), �Űܴ���� ��ġ, ������ ����(����)) 
//		System.arraycopy(arr, 0, brr, 0, arr.length);
//		
//		for (int i = 0; i < brr.length; i++) {
//			System.out.printf("%5d", brr[i]);
//		}
		
		//4.���� for��
//		int sum = 0;
//		
//		for(int n: arr) {
//			sum += n;
//		}
//		
//		System.out.printf("��ü�� : %d", sum);
		
		//5. next �޼ҵ带 �̿��ؼ�
		//(1)
//		String str = "";
//		for(int i = 0; i < 5; i++) {
//			str += sc.next();
//		}
//		System.out.println(str);
		
		//(2)
		String[] str = new String[5];
		
		String longStr = "";
		
		//next()�� �����̽��� �� ���ڿ��� �Ϸ�� ����.
		//nextLine()�� ���͸� �Ϸ�� ���� �����̽��� ���ڿ��� ����Ѵ�.
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}
		
		for(String ok: str) {
			longStr += ok;
		}
		
		System.out.printf("���� ���� : %s", longStr);
	}
}