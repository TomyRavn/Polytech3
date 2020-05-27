package may_27;

public class Test01 {
	public static void main(String[] args) {
		//5개의 정수형 배열선언
		int[] numArray = new int[5];
		
		//0~4번까지의 인덱스 (총 5개) 를 쓰는 배열에
		//1~5까지의 수를 랜덤으로 대입
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = (int)(Math.random() * 5 + 1);
		}
		
		//최댓값에 0번째 인덱스의 값을 대입
		int max = numArray[0];
		
		//1~4번까지의 인덱스까지 루프를 돌면서
		//최댓값보다 현재 인덱스의 값이 크면 최댓값을 현재의 값으로 교체
		for (int i = 1; i < numArray.length; i++) {
			if(numArray[i] > max) max = numArray[i];
		}
		
		//================== 출력 ==================//
		//인덱스에 들어간 숫자 출력
		for (int i = 0; i < numArray.length; i++) {
			System.out.printf("[%d]: %-3d", i, numArray[i]);
		}
		
		//최댓값 출력
		System.out.printf("\n최댓값: %d", max);
		//========================================//
	}
}