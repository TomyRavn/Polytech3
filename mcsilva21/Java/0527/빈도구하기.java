
public class 빈도구하기 {

	public static void main(String[] args) {
		
//		int[] arr = new int[10];
//		int temp;
//	
//		for (int i = 0; i < arr.length; i++) {	
//			for(int j=1; j<100; j++) 	
//				arr[i] = (int)(Math.random()*10);
//			
//			
//			System.out.printf("a[%d]: %d번",i,arr[i]);
//			System.out.println();
						
			
			int[] arr = new int[10];
	
			for (int i=0; i<100; i++) {
				arr[(int)(Math.random()*10)]++;
			}
				int m = 0;
				
				for (int i = 1; i < arr.length; i++) {
					if(arr[i]>arr[m])
						m=i;
				}
							
				for (int i = 0; i < arr.length; i++) {
					System.out.printf("%d:%4d회\n",i,arr[i]);
			
		}		
				System.out.printf("\n최빈값:%d, 최빈값의 빈도수:%d\n",m,arr[m]);
		
		}
}
	
	

