package may_27;

public class Test01 {
	public static void main(String[] args) {
		//5���� ������ �迭����
		int[] numArray = new int[5];
		
		//0~4�������� �ε��� (�� 5��) �� ���� �迭��
		//1~5������ ���� �������� ����
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = (int)(Math.random() * 5 + 1);
		}
		
		//�ִ񰪿� 0��° �ε����� ���� ����
		int max = numArray[0];
		
		//1~4�������� �ε������� ������ ���鼭
		//�ִ񰪺��� ���� �ε����� ���� ũ�� �ִ��� ������ ������ ��ü
		for (int i = 1; i < numArray.length; i++) {
			if(numArray[i] > max) max = numArray[i];
		}
		
		//================== ��� ==================//
		//�ε����� �� ���� ���
		for (int i = 0; i < numArray.length; i++) {
			System.out.printf("[%d]: %-3d", i, numArray[i]);
		}
		
		//�ִ� ���
		System.out.printf("\n�ִ�: %d", max);
		//========================================//
	}
}