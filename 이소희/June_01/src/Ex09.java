
public class Ex09 {

	public static void main(String[] args) {
//		String[] strArray = new String[3];
//		for (int i = 0; i < strArray.length; i++) {
//			
//			strArray[0] = "java";
//			strArray[1] = "c++";
//			strArray[2] = "c#";
//		
//			System.out.println(strArray[i]);
//			
//		}
//
		
	
		
//		
//		int[] arr = {10, 20, 30, 40, 50};
//		int[] brr = new int[10];
//		
////		brr = arr;
//		
//		for (int i = 0; i < arr.length; i++) {
//			brr[i] = arr[i];}
//		
//		for (int j = 0; j < brr.length; j++) {
//			System.out.printf("%5d" , brr[j]);
//			
//		}
//		
//	}	
		
	
		
		
		
		int[] arr = {10, 20, 30, 40, 50};
		int[] brr = new int[10];
		
		//arr 0에서 부터 arr.length까지를 brr의 0에 복사하겠다.
		System.arraycopy(arr, 0, brr, 0, arr.length);
		
		for (int i = 0; i < brr.length; i++) {
	
		System.out.printf("%5d" , brr[i]);
	





		}
	}	
}

