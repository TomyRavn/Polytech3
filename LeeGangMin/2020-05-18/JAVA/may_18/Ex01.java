import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//����ڰ� ���� �Է�
		System.out.print("ù ��° ���� �Է����ּ��� > ");
		int inputA = sc.nextInt();
		System.out.print("�� ��° ���� �Է����ּ��� > ");
		int inputB = sc.nextInt();
		//���� �� ������ ����
		int resultPlus = 0;
		int resultMinus = 0;
		//�� ���� ���� �״�� ���
		resultPlus = inputA + inputB;
		//�� ���� ���� ū ������ ���� ���� �� ������ �Ѵ�
		if(inputA >= inputB) {
			resultMinus = inputA - inputB;
		}
		else {
			resultMinus = inputB - inputA;
		}
		//���
		System.out.printf("�� ���� �� : %d\n�� ���� �� : %d", resultPlus, resultMinus);
	}
}