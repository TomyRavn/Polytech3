import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		
		
		int s = 9;
		int i = 1;
		int sum = 0;
		int sum1 = 0;
		int x = 1;
		
		for(i=1; i<=9; i++)
			System.out.println(s+"x"+i+"="+(s*i));
		
		for(i=1; i<=10; i++)
			sum += i;
		System.out.printf("1부터 10의 합은: %d\n",sum);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int n = scan.nextInt();
		
		for(x =1; i<=n; i++)
			sum1 += x++;
		System.out.printf("전체합:%d\n",sum1);
		
		
		
	}

}
