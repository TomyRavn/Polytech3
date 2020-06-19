
public class Ex04 {

	public static void main(String[] args) {
		// 난수 발생 시켜서 5개의 값 저장, 오름차순 출력하기.
		
		
		int[] arr = new int[5];
		int tmp;
		
		
		for(int i=0; i<arr.length; i++) {
			arr[i] =(int)(Math.random()*101);
		}
			
			
			for(int i = 0; i<arr.length; i++) {
				int m = i;
			
			
			for(int j = i+1; j<arr.length; j++) {
				if(arr[m]>arr[j])
					m=j;
					
			}
			
			tmp = arr[i];
			arr[i] = arr[m];
			arr[m] = tmp;					
			}
		
			
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+" ");
			
		}

}
	}

