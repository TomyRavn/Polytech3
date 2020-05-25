import java.util.Scanner;

public class 배열변수 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
////		int[] arr = {10,20,30,40,50};
//		
//		int[] a= new int[] {10,30,40,50};
//				
//		for(int i=0; i<a.length; i++) {
//			System.out.printf("정수%d:",i+1);
//			a[i] = s.nextInt();
//		}
//		for (int i = 0; i < a.length; i++) {
//			System.out.printf("%4d",a[i]);
//	
	
		int[] score = new int[5];
		int sum=0;
		
		for(int i=0; i<score.length; i++) {
			System.out.println("철학점수를 입력하세요:");
			score[i] = s.nextInt();
			sum += score[i];
		}
		
		double result= (double)sum/score.length;
		System.out.printf("평균은%s입니다.",result);
			
	}
	
	
	
}

	


