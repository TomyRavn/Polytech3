import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i <=5; i ++) {
			//0이상 1미만의 더블형의 수를 난수로 발생시킴 (= Math.random()) 
			System.out.println(Math.random());	//Math.random()에 곱하는 수 - 1이 난수의 범위
												//Math.random()*n + 1은 난수의 최소 범위를 1만큼 증가
		}
	}
}