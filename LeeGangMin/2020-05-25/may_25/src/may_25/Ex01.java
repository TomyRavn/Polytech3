package may_25;

import java.util.Scanner;

public class Ex01 {
	
	//���α׷��� ����(����)�� ���ؼ� �����ϴ� �޼ҵ�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//�޼ҵ� : �ϳ��� ����� �����ϴ� �ϳ��� ������ ���α׷�
		//�������� ����� �� ȣ��

		//1.
//		test(5);
//		
//		System.out.println("���α׷� ��!!");
		
		//2.
		int add = sum(10, 80);
		System.out.printf("���� ��� : %d\n", add);
	}
	
	///////////////////////////////////////////////////////
	public static void test(int num) {
		
		for(int i = 0 ; i < num; i++) {
			System.out.println("Hello Test~~");	
		}
		
	}
	//////////////////////////////////////////////////////
						//int x, int y�� �Ű�����
	public static int sum(int x, int y) {
		return x + y;
	}
}