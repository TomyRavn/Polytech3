import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//������ 3�� �Է��� �ִ밪 ���
		int x, y, z, max;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ 3�� �Է��ϼ���. 1��° >");
		x = sc.nextInt();
		System.out.println("������ 3�� �Է��ϼ���. 2��° >");
		y = sc.nextInt();
		System.out.println("������ 3�� �Է��ϼ���. 3��° >");
		z = sc.nextInt();
		
		//1. ���� ������ ���
//		max = x>y? x:y;
//		max = max>z? max:z;
//		System.out.println("�ִ� : " + max);
		
		//2. if�� ���
		if(x>y) max = x; 
		else max = y;		// x�� y���Ͽ� max�� ����
		if(z>max) max = z;	//max(x�� y�� ū ��)�� z���Ͽ� z�� ũ�� max�� ����, ������ max �״�� ��� 
		System.out.println("�ִ� : " + max);
		
		//3. �÷ο� ��Ʈ ���� ���
//		if(x>y) {
//			if(x>z) max = x;
//			else max = z;
//		} else {
//			if(y>z) max = y;
//			else max = z;
//		}
	}
}