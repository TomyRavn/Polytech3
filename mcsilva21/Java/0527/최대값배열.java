import java.util.Scanner;

public class 최대값배열 {

	public static void main(String[] args) {				
//		String[] intArray;
//		int[] intArray = {10,20,30};		
//		int[] intArray;
//	intArray = new String[5];		
//		for (int i = 0; i < intArray.length; i++) {
//		System.out.println(intArray[i]);
//			
//			String str1 = "임꺽정";			
//			String str2 = "임꺽정";			
//			String str3 = new String("임꺽정");			
//			String str4 = "임꺽정";	
//			
//			if(str1 == str2)
//				System.out.println("일치");
//			else
//			System.out.println("불일치");
//			
//			if(str1.equals(str2))
//				System.out.println("일치");
//			else
//			System.out.println("불일치");
//			
//			if(str4 == str2)
//				System.out.println("일치");
//			else
//			System.out.println("불일치");
//									
//		int[] score = new int[5];
//		Scanner s = new Scanner(System.in);
//		int sum=0;
//		
//		for(int i=0; i<score.length; i++) {
//			System.out.println("점수를 입력하세요:");
//			score[i] = s.nextInt();
//			sum += score[i];
//		}
//		
//		double result= (double)sum/score.length;
//		System.out.printf("전체합은%s점 평균은%s점 입니다.",sum, result);	
		
		
		int[] arr = new int[5];
		int max = 0;
			
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			System.out.printf("%d번째 난수:%d",i+1,arr[i]);
			System.out.println();

			if(max<arr[i])
				max=arr[i];			
	}	
				
		System.out.printf("최대값:%d",max);
		
							
		}						
	}


