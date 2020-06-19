import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		//가위 바위 보 랜덤

		Scanner sc = new Scanner(System.in);
		
		final int sci = 1;
		final int roc = 2;
		final int pap = 3;
		
		int com = ((int)(Math.random()*3)+1);
		
		System.out.println("가위(1)/바위(2)/보(3) 선택>>");
		int me = sc.nextInt();
		String result;
		
		if(me == sci)
			if(com == sci)
				result = "무승부";
			else if(com == roc)
				result = "컴의 승";
			else
				result = "나의 승";
		
		
		else if(me == roc)
			if(com == sci)
				result = "나의 승";
			else if(com == roc)
				result = "무승부";
			else
				result = "컴의 승";
		
		
		else if(com == sci)
				result = "컴의 승";
			else if(com == roc)
				result = "나의 승";
			else
				result = "무승부";
		
		System.out.println("게임의 결과는 :" + result + "");
//		if (com == 1) System.out.println("컴퓨터는 보를 냈습니다.");
//		else if ( com == 2)System.out.println("컴퓨터는 보를 냈습니다.");
//		else System.out.println("컴퓨터는 보를 냈습니다.");
//		

		System.out.printf("컴퓨터는 %s를 냈습니다.\n" , com == 1? "가위" : com == 2? "바위" : "보");
	}
}

