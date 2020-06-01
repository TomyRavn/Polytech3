
public class ArrCopy사용하기 {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50};
		int[] brr = new int[10];
		
	System.arraycopy(arr,0,brr,0,arr.length);
	
	for (int i = 0; i < brr.length; i++) {
		System.out.println(brr[i]);
		
	}
		
	
		}
		
	}


