package may_25;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//사용자로부터 1~50사이의 숫자 10개를 입력받아 숫자만큼의 별표를 출력하는 프로그램
		//1~50이외의 숫자는 다시 입력

		Scanner sc = new Scanner(System.in);

//		for(int i = 1; i <= 10; i ++) {
//
//			//System.out.println("1 ~ 50사이의 숫자를 입력하세요.");
//			System.out.printf("막대%d의 길이 : ", i);
//			int num = Integer.parseInt(sc.nextLine());
//
//			if(num >= 1 && num <= 50)
//			{
//				
//				for(int j = 0; j < num; j++) {	
//					System.out.print("*");
//				}
//			}
//			else {
//				System.out.printf("\n허용되지 않는 길이입니다.\n다시 입력하세요!\n");
//				i--;
//			}
//			System.out.println();
//		}


		//================== 교수님 코드 =====================//
		for(int j = 1; j <= 10; j++) {
			System.out.printf("막대 %d의 길이: ", j);
			int n = sc.nextInt();
			
			if(!(n>=1 && n<=50)) {
				System.out.printf("허용되지 않는 값입니다.\n다시 입력하세요.\n");
				j--;
				continue;	//else 대신 순서를 앞으로 옮겨 가능
			}
			for(int i = 1; i <= n; i++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}