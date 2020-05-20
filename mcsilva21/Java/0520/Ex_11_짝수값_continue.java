import java.util.Scanner;

public class Ex_11_짝수값_continue {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int sum = 0;
//		
//		for(int i=1; i<=100; i++) {
//			if(i%2 == 1)
//				continue; //if 조건문을 실행하지 않고 건너뛰고 다시 조건식으로 돌아감
//			
//			sum += i;
//		}
//			System.out.println("전체합:" + sum);
		int cnt = 0;
		
		go:
		
		for(int i=1; i<=3; i++) {
			cnt++;
			System.out.printf("\n[%d행]\n",i);
			
			for(int j=1; j<=3; j++) {
				System.out.println("Inner for loop~");
				
				if(cnt ==2)
					break go;
			}
			System.out.println("\nOuter for loop");
		}
		
		System.out.println("찾았다");
		
		
		
		
		
		
	}

}
