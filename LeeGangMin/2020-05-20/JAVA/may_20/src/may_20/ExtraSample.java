package may_20;
import java.util.Scanner;

public class ExtraSample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		char ans;
		
		while(true) {
			System.out.println("1. 가위바위보");
			System.out.println("2. 테트리스");
			System.out.print("\n게임 선택>> ");
			n = sc.nextInt();
			
			System.out.print("\n게임을 계속하시겠습니까(y/n)?");
			sc.nextLine();	//버퍼를 비워주는 용도(scanner 타입이 달라질 때 enter입력을 기준으로 비워줌("엔터가 입력된 것을 비워줌"))
			ans = sc.nextLine().charAt(0);
			
			if(ans == 'n') {
				System.out.println("게임을 종료합니다.\n");
				break;
			}
			
		}
	}
}