import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		//2���� ������ �Է¹޾� �ϳ� �и� �ϳ� ���ڷ� ���
		//�и� 0�� ����̸� 2���� ��¹����� ó��(�Է� ����, 0�� �и�� ��� �Ұ�)
		//�ٸ� ���� ������ ������ �ؼ� 
		//result���� ������ ���
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �� �Է� > ");
		int x = sc.nextInt();
		System.out.println("�и� �� �Է� > ");
		int y = sc.nextInt();
		
		//if(y == 0); �� ��� ���� ������ �ƹ��͵� ��������� �ϳ��� ���ǹ��� �ǹǷ� ����
		if(y == 0) {
			System.out.println("�Է� ����");
			System.out.println("0�� �и�� ��� �Ұ�");
		} else {							//�� �� �̻��� ��쿡�� if�� {} ������� �� ������� ��(else�� ���������� ���� �� ����)
			double result = (double)x/y;
			System.out.println(result);
		}
	}
}