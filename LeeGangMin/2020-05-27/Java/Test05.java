package may_27;

public class Test05 {
	public static void main(String[] args) {
		//0 ~ 9 ���� �߻�
		//for loop�� �̿��� 100�� �ݺ�
		//�߻� �� Ƚ���� �迭�� �����Ͽ� ���� ū ���� ��ȣ�� ���Ͽ� ���
		//�ֺ� : x, �߻��� : yȸ
		
		//�迭 ���� (0���� �ڵ� �ʱ�ȭ��)
		int[] count = new int[10];
		
		//100ȸ ���� ��Ű�鼭 ���� �̱�
		for(int j = 0; j < 100; j++) {

			int temp = (int)(Math.random() * 10);
			
			//1.���� 0~9�� �ε������� ������ �ش� �ε��� �� ����
//			for (int i = 0; i < count.length; i++) {
//				if(i == temp) {
//					count[i]++;
//				}
//			}
			//2.
			count[temp]++;
		}
		
		//�ֺ� �ε��� ������ ����
		int bestIndex = 0;
		
		//�ֺ� �ε��� ����
		for(int i = 0; i < count.length; i++) {	
			if(count[i] > count[bestIndex]) bestIndex = i;
		}
		
		//���
		for(int i = 0; i < count.length; i++) {
			System.out.printf("count[%d]: %4d��\n", i, count[i]);
		}
		
		System.out.printf("\n�ֺ� : %d, �߻��� : %dȸ", bestIndex, count[bestIndex]);
	}
}