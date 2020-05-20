import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		//100~90 a
		//90~80 b
		//80~70 c
		//70~60 d
		//60 e//
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("성적을 입력하세요.");
		int score = scan.nextInt();
		
		if(score>=90) {
			System.out.println("점수가 A 등급입니다.");
		}else if(score>=80){
			System.out.println("점수가 B 등급입니다.");
		}else if(score>=70){
			System.out.println("점수가 C 등급입니다.");
		}else if(score>=60){
			System.out.println("점수가 D 등급입니다.");
		}else{
			System.out.println("점수가 E 등급입니다.");
		}
	
	}

}
