import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 	
		System.out.println("물리점수를 입력하세요");
		int x = scan.nextInt();
		System.out.println("역사점수를 입력하세요");
		int y = scan.nextInt();
		System.out.println("철학점수를 입력하세요");
		int z = scan.nextInt();	
		
		String str = (x>=70 && y>=70 && z>=70) ? "통과" :"다음기회에";
		System.out.println(str);
	 
		
	}
	}
