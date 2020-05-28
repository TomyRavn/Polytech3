import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		//사용자로부터 입력받은 두 수의 합과 차를 구하여 출력하여 보자. 두 수의 차는 큰 수에서 작은 수를 뺀 것으로 한다.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		int n1 = sc.nextInt();
		
		System.out.println("점수를 입력하세요.");
		int n2 = sc.nextInt();
		
		System.out.printf("두 수의 합 :%d\n", n1 + n2);
		
		if (n1 > n2)
		System.out.printf("두 수의 차:%d\n", n1 - n2);
		else
		System.out.printf("두 수의 차 : %d\n", n2 - n1);


//		System.out.println("두 수의 합 : " +(n1 + n2));
//		if (n1 > n2)
//		System.out.println("두 수의 차:" + (n1 - n2));
//		else
//		System.out.println("두 수의 차 : " +(n2 - n1));

	}

}
