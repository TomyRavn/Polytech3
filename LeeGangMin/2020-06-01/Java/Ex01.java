import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		//1.
//		int[][] arr = new int[2][3];
		
		//2.
//		int[][] arr = {{10,20}, {30,40}, {50,60}};
		
		//3.
//		int[][] arr = {{10,20,30},{20,30,40}};
		
		//4.
//		Scanner sc = new Scanner(System.in);
//		int[][] arr = new int[3][2];
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.printf("(%d,%d) ���� �Է��ϼ���", i, j);
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		//5.
//		Scanner sc = new Scanner(System.in);
//		int[][] arr = new int[2][3];
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.printf("%d��: ", i+1);
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		//6.
//		int[][] arr = new int[2][];
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		arr[0] = new int[3];
//		arr[1] = new int[5];	//�ڹٿ����� �ึ�� ���� ũ�⸦ ������ �� �ִ�.(C��� ����� ����)
		
		
		//7. 3�� 4���� ������ ������
		//	  �� ������  ���� �� ���� ���� ���ؼ� ����
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][4];
		
		for (int i = 0; i < arr.length; i++) {
			
			int sum = 0;
			
			//(1)
//			for (int j = 0; j < arr[i].length; j++) {
//				if(j < arr[i].length - 1) {
//					System.out.printf("(%d, %d) �� �Է��ϼ��� > ", i, j);
//					arr[i][j] = sc.nextInt();
//					sum += arr[i][j];
//				}
//				else {
//					arr[i][j] = sum;
//				}
//			}
			
			//(2)
			for (int j = 0; j < arr[i].length - 1; j++) {
				System.out.printf("(%d, %d) �� �Է��ϼ��� > ", i, j);
				arr[i][j] = sc.nextInt();
				arr[i][3] += arr[i][j];
			}
		}
		
		//�� �� arr.length�� 1���� �迭�� ������ 2�� ��(1���� �迭 2��)
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				System.out.printf("%5d", arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
}