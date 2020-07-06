package 연습문제;

import java.util.Scanner;

public class 연습문제_입력받은_값_소수_구하기 {

	//문제:정수 n을 입력받아 n까지 모든 소수 구하기
	//소수 : 1보다 큰 자연수 중 1과 자기자신 두개만들 약수로 갖는 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int n = sc.nextInt();
				
		for (int i = 2; i <=n; i++) {
			boolean prm = true;
			for (int j = 2; j*j<=i; j++) {	
				if(i%n==0) {
					prm = false;
					break;
//소수가 아닐때 ex:n으로 8을 받으면 8을2로 나눴을때 나머지가 0이되므로 소수가 아니다.
				}				
			}
		if(prm) {
			//나머지가 0이 아닐떄만 출력해야 한다.
			System.out.println(i+ " ");
		}
		}
		sc.close(); // 스캐너 입력을 종류해주는 함수
}		
}
