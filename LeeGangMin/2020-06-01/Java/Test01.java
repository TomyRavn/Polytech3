
public class Test01 {
	public static void main(String[] args) {
		int[][] numArray = new int[3][3];
		
		//1. �밢�� ��
//		int sum = 0;
//		
//		for (int i = 0; i < numArray.length; i++) {
//			
//			for (int j = 0; j < numArray[i].length; j++) {
//				
//				numArray[i][j] = (int)(Math.random()*101);
//				
//				if(i == j) {
//					sum += numArray[i][j];
//				}
//			}
//		}
//		
//		for (int i = 0; i < numArray.length; i++) {
//			for (int j = 0; j < numArray[i].length; j++) {
//				System.out.printf("%4d", numArray[i][j]);
//			}
//			System.out.println();
//		}
//		
//		System.out.printf("�迭�� �밢�� ���� �� : %d", sum);
		
		
		//2. �� ���� �ִ밪 ���
		for (int i = 0; i < numArray.length; i++) {
			
			for (int j = 0; j < numArray[i].length; j++) {
				
				numArray[i][j] = (int)(Math.random()*101);
				
			}
			
			
			int max = numArray[i][0];
			
			for (int j = 0; j < numArray[i].length; j++) {
				
				if(numArray[i][j] > max) {
					max = numArray[i][j];
				}
				System.out.printf("%4d", numArray[i][j]);
			}
			
			System.out.printf("\t%d���� �ִ밪 : %d", i+1, max);
			System.out.println();
		}
	}
}