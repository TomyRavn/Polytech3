import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {10, 20, 30, 40, 50};
		int[] brr = new int[10];
		
		//1.
//		brr = arr;
//		//arr의 주소값이 brr의 주소값에 할당되어지므로 brr과 arr이 가리키는 객체가 동일하게 바뀜
//		//length가 10인 기존의 brr 배열은 상실되어 더이상 쓸 수 없음
//		for (int i = 0; i < brr.length; i++) {
//			System.out.printf("%5d", brr[i]);
//		}
		
		//2.
//		for (int i = 0; i < arr.length; i++) {
//			brr[i] = arr[i];
//		}
//		
//		for (int i = 0; i < brr.length; i++) {
//			System.out.printf("%5d", brr[i]);
//		}
		
		//3.매개변수
//		//(복사할 대상, 대상의 몇 번째부터 복사할 것인가, 옮겨담을 대상(목적지), 옮겨담아질 위치, 복사할 길이(갯수)) 
//		System.arraycopy(arr, 0, brr, 0, arr.length);
//		
//		for (int i = 0; i < brr.length; i++) {
//			System.out.printf("%5d", brr[i]);
//		}
		
		//4.향상된 for문
//		int sum = 0;
//		
//		for(int n: arr) {
//			sum += n;
//		}
//		
//		System.out.printf("전체합 : %d", sum);
		
		//5. next 메소드를 이용해서
		//(1)
//		String str = "";
//		for(int i = 0; i < 5; i++) {
//			str += sc.next();
//		}
//		System.out.println(str);
		
		//(2)
		String[] str = new String[5];
		
		String longStr = "";
		
		//next()는 스페이스도 한 문자열의 완료로 본다.
		//nextLine()은 엔터만 완료로 보고 스페이스도 문자열로 취급한다.
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}
		
		for(String ok: str) {
			longStr += ok;
		}
		
		System.out.printf("연결 문장 : %s", longStr);
	}
}