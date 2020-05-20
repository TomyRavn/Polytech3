
public class Ex01_10까지의합_기본 {

	public static void main(String[] args) {
		
		int i = 0; // 제어변수
		int sum = 0;

		do {
			i++;  //i 값증가
			sum += i;
		} while(i<10);
			
			
		System.out.println("1부터 10까지의 값 :" + sum);	
										

	}

}
