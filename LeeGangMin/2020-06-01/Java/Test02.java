import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1.
		int[][] numArray = new int[4][4];
		
		for (int i = 0; i < numArray.length - 1; i++) {
			System.out.printf("%d�� �Է� > ", i + 1);
			
			for (int j = 0; j < numArray.length - 1; j++) {	
				numArray[i][j] = sc.nextInt();
				numArray[i][numArray.length-1] += numArray[i][j];
			}
		}
		
		for (int i = 0; i < numArray.length - 1; i++) {
			for (int j = 0; j < numArray.length - 1; j++) {
				numArray[numArray.length-1][i] += numArray[j][i];
			}
			numArray[numArray.length-1][numArray.length-1] += numArray[i][numArray.length-1]; 
		}
		
		//���
		System.out.printf("\t\t\t\t���� ��\n");
		for (int i = 0; i < numArray.length; i++) {
			if(i == numArray.length-1) {
				System.out.print("���� �� ");
			}
			for (int j = 0; j < numArray.length; j++) {
				System.out.printf("\t%4d", numArray[i][j]);
			}
			System.out.println();
		}
		
		//2. ������ �ڵ�
		int[][] arr = new int[4][4];
		
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.printf("%d�� �Է� : ", i + 1);
			
			for (int j = 0; j < arr.length - 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				arr[i][arr.length - 1] += arr[i][j];
				arr[arr.length - 1][j] += arr[i][j];
			}
			arr[arr.length - 1][arr.length - 1] += arr[i][arr.length - 1];
		}
		
		//���
		System.out.printf("\t\t\t\t���� ��\n");
		for (int i = 0; i < numArray.length; i++) {
			if(i == numArray.length-1) {
				System.out.print("���� �� ");
			}
			for (int j = 0; j < numArray.length; j++) {
				System.out.printf("\t%4d", numArray[i][j]);
			}
			System.out.println();
		}
		
	}
}