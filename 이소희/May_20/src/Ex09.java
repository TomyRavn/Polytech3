import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		//임의의 양의 정수를 반복해서 입력받아  그 중에서 전체 짝수의 개수를 출력하는 프로그램을 작성하시오.
		//음수를 입력하면 반복문을 빠져나온다.
		Scanner sc = new Scanner(System.in);
			
		System.out.println("정수를 입력하시오(나가기: 음수 입력)");
		int num = sc.nextInt();
		int sum = 0;		
		
		
		do { 		
			if(num %2 == 0)
				sum++;
			System.out.println("정수를 입력하시오(나가기: 음수 입력)");
			num = sc.nextInt();
				
			
			}while(num>0); 
			System.out.println(sum);
		}
		}
