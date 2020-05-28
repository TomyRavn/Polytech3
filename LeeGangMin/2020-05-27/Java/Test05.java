package may_27;

public class Test05 {
	public static void main(String[] args) {
		//0 ~ 9 난수 발생
		//for loop를 이용해 100번 반복
		//발생 빈도 횟수를 배열에 저장하여 가장 큰 값의 번호를 구하여 출력
		//최빈값 : x, 발생빈도 : y회
		
		//배열 선언 (0으로 자동 초기화됨)
		int[] count = new int[10];
		
		//100회 루프 시키면서 숫자 뽑기
		for(int j = 0; j < 100; j++) {

			int temp = (int)(Math.random() * 10);
			
			//1.값이 0~9의 인덱스값과 같으면 해당 인덱스 값 증가
//			for (int i = 0; i < count.length; i++) {
//				if(i == temp) {
//					count[i]++;
//				}
//			}
			//2.
			count[temp]++;
		}
		
		//최빈값 인덱스 저장할 변수
		int bestIndex = 0;
		
		//최빈값 인덱스 저장
		for(int i = 0; i < count.length; i++) {	
			if(count[i] > count[bestIndex]) bestIndex = i;
		}
		
		//출력
		for(int i = 0; i < count.length; i++) {
			System.out.printf("count[%d]: %4d번\n", i, count[i]);
		}
		
		System.out.printf("\n최빈값 : %d, 발생빈도 : %d회", bestIndex, count[bestIndex]);
	}
}