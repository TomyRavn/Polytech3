import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		final int SCI =1;
		final int ROCK =2;
		final int PAPER =3;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(1)/바위(2)/보(3)중 선택 >> ");
		int me = sc.nextInt();
		String result;
		
		
		int com = (int)(Math.random()*3)+1;
		System.out.println(com);

		
		if(me == SCI)
			if(com == SCI)
				result = "무승부";
			else if(com == ROCK)
				result = "컴승";
			else
				result = "나의 승";
		
		else if (me == ROCK)
			if(com == SCI)
				result = "나의 승";
			else if (com == ROCK)
				result = "무승부";
			else 
				result = "컴승";
		
		else
			if(com == SCI)
				result = "컴승";
			else if (com == ROCK)
				result = "나의승";
			else 
				result = "무승부";
		
		System.out.println("게임의 결과는" + result + "입니다.");
		System.out.printf("컴퓨터는%s를 냈습니다.\n",com == 1? "가위":com==2?"바위":"보");
	}	

}
