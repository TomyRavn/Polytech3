import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		//�� �ڸ��� �̷���� ������ ���� ���� ���� �Է� ���� �Ŀ�
		//������ �ڸ����� �и��ϰ�
		//�� �ڸ� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��Ͻÿ� : ");
		int num = sc.nextInt();
		
		//1. num�� �Է¹ް� num ���� �״�� �����ϸ鼭 ������ ������ ���� ���� ���� �־��ִ� ���
		int hundred = num / 100;
		int ten = (num-(hundred*100)) / 10;		//<=> int ten = num % 100 / 10;
		int one = num-(hundred*100)-(ten*10);	//<=> int one = num % 10;
		System.out.printf("���� �ڸ��� : %d\n���� �ڸ��� : %d\n���� �ڸ��� : %d\n", hundred, ten, one);
		
		//2. num�� �Է¹ް� num�� ���� �����鼭 ��ȭ���Ѽ� ó���ϴ� ���
//		int hundred = num / 100;
//		num = num - (hundred * 100);
//		int ten = num / 10;
//		num = num - (ten * 10);
//		int one = num;
//		System.out.printf("���� �ڸ��� : %d\n���� �ڸ��� : %d\n���� �ڸ��� : %d\n", hundred, ten, one);
		
		//3. ���� �� ���
//		System.out.printf("���� �ڸ��� : %d\n", num/100);
//		System.out.printf("���� �ڸ��� : %d\n", num%100/10);
//		System.out.printf("���� �ڸ��� : %d\n", num%10);
	}
}