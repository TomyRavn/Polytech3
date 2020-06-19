import java.util.Scanner;

public class Ex12 {
// 입력 받은 a b c 숫자 중 최대값만 출력하기.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a>b && b>c)
			System.out.println("최대값: " +a);
		else if(c>a && c>b)
			System.out.println("최대값: " +c);
		else 
			System.out.println("최대값:" +b);
		


}

}