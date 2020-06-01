
public class For배열구현 {

	public static void main(String[] args) {				
		int[] arr = {10,20,30,40,50};		
		int sum = 0;
		for (int n: arr) {
			sum+=n;
		}
		System.out.printf("전체합:%d\n",sum);
	}
}
