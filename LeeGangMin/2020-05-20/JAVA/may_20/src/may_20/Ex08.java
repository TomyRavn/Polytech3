package may_20;

public class Ex08 {
	public static void main(String[] args) {

		//1. continue
//		int sum = 0;
//		
//		for(int i = 1; i <= 100; i++) {
//			if(i % 2 == 1) continue;		//�Ʒ��� �ڵ� ���� ���ϰ� ���������� �ٷ� ��
//			sum += i;						//while���� ���ǽ�����
//		}
//		System.out.println("��ü�� : " + sum);
		
		//2. break
//		int cnt = 0;
//		
//		for(int i = 1; i<=3; i++) {
//			cnt++;
//			System.out.printf("\n[%d��]\n", i);
//			
//			for(int j = 1; j <= 3; j++) {
//				System.out.println("Inner for loop~~");
//				
//				if(cnt == 2) break;
//			}
//			System.out.println("\nOuter for loop");
//		}
		
		//3. label�� �̿��� ���ϴ� ������ �ٷ� �������� �� �ֵ��� ��
		int cnt = 0;
		
		go:
			
		for(int i = 1; i<=3; i++) {
			cnt++;
			System.out.printf("\n[%d��]\n", i);
			
			for(int j = 1; j <= 3; j++) {
				System.out.println("Inner for loop~~");
				
				if(cnt == 2)
					break go;
			}
			System.out.println("\nOuter for loop");
		}
		System.out.println("��Ҵ�");
	}
}