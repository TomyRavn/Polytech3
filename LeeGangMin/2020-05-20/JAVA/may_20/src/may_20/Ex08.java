package may_20;

public class Ex08 {
	public static void main(String[] args) {

		//1. continue
//		int sum = 0;
//		
//		for(int i = 1; i <= 100; i++) {
//			if(i % 2 == 1) continue;		//아래쪽 코드 실행 안하고 증감식으로 바로 감
//			sum += i;						//while문은 조건식으로
//		}
//		System.out.println("전체합 : " + sum);
		
		//2. break
//		int cnt = 0;
//		
//		for(int i = 1; i<=3; i++) {
//			cnt++;
//			System.out.printf("\n[%d행]\n", i);
//			
//			for(int j = 1; j <= 3; j++) {
//				System.out.println("Inner for loop~~");
//				
//				if(cnt == 2) break;
//			}
//			System.out.println("\nOuter for loop");
//		}
		
		//3. label을 이용해 원하는 루프로 바로 빠져나올 수 있도록 함
		int cnt = 0;
		
		go:
			
		for(int i = 1; i<=3; i++) {
			cnt++;
			System.out.printf("\n[%d행]\n", i);
			
			for(int j = 1; j <= 3; j++) {
				System.out.println("Inner for loop~~");
				
				if(cnt == 2)
					break go;
			}
			System.out.println("\nOuter for loop");
		}
		System.out.println("살았다");
	}
}