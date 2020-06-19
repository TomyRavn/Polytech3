import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int sum = 0;
//		
//		for(int i = 1; i<=100; i++) {
//			if(i%2 == 1)
//				continue;
//			
//			sum += i;
//		}
//		System.out.println("전체합:"+sum);

		
		int cnt = 0;
		
		go:
		
		for(int i = 1; i<=3; i++) {
			cnt++;
			System.out.printf("\n[%d행]\n", i);
			
			for(int j=1; j<=3; j++) {
				System.out.println("Inner for loop~~");
				
				if(cnt == 2)
					break go;
			}
			System.out.println("\nOuter for loop");
			
		}
		System.out.println("잘했다~~");
	}

}
