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
//				System.out.printf("(%d,%d) 값을 입력하세요", i, j);
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		//5.
//		Scanner sc = new Scanner(System.in);
//		int[][] arr = new int[2][3];
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.printf("%d행: ", i+1);
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
//		arr[1] = new int[5];	//자바에서는 행마다 열의 크기를 조정할 수 있다.(C언어 등과의 차이)
		
		
		//7. 3행 4열의 정수형 데이터
		//	  맨 마지막  열에 각 행의 합을 구해서 저장
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][4];
		
		for (int i = 0; i < arr.length; i++) {
			
			int sum = 0;
			
			//(1)
//			for (int j = 0; j < arr[i].length; j++) {
//				if(j < arr[i].length - 1) {
//					System.out.printf("(%d, %d) 값 입력하세요 > ", i, j);
//					arr[i][j] = sc.nextInt();
//					sum += arr[i][j];
//				}
//				else {
//					arr[i][j] = sum;
//				}
//			}
			
			//(2)
			for (int j = 0; j < arr[i].length - 1; j++) {
				System.out.printf("(%d, %d) 값 입력하세요 > ", i, j);
				arr[i][j] = sc.nextInt();
				arr[i][3] += arr[i][j];
			}
		}
		
		//이 때 arr.length는 1차원 배열의 길이인 2가 됨(1차원 배열 2개)
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				System.out.printf("%5d", arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
}