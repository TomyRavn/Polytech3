import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// 1부터 100까지의 난수를 5개 만들어 값을 저장하고, 최대값 찾기
		
		double max = 0;
		int[] arr = new int[5];
	
		for(int i=0; i<arr.length; i++) {
			arr[i] =(int)(Math.random()*101);
			System.out.printf("%d번째 난수:%d",i+1, arr[i]);
			System.out.println();
			
			
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.printf("최대값: %d", (int)max);
	}
}

		

	


