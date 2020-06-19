import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		//향상된 for문을 이용한 반복
		
//		int[] arr = {10, 20, 30, 40, 50};
//
//		int sum = 0;
//
//		for(int n: arr) {
//		sum += n;
//}
//		System.out.printf("전체 합: %d\n" , sum);
		
		
		
		Scanner s = new Scanner(System.in); 
		String[] str = new String[5];
		
		String line= "";
		
		for (int i = 0; i < str.length; i++) {
			
			str[i] = s.next();
			//str[i] = s.nextLine();은 엔터 키를 치기 전 까지 긴 문장을 입력 가능!
			//str[i] = s.nextLine();
		}
			
		for (String ok: str) {
			line += ok;
			
		}
		System.out.printf("연결 문장 : %s\n" , line);


	}
	}


