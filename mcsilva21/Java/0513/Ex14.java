import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		//100~90 a
		//90~80 b
		//80~70 c
		//70~60 d
		//60 e//
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("������ �Է��ϼ���.");
		int score = scan.nextInt();
		
		if(score>=90) {
			System.out.println("������ A ����Դϴ�.");
		}else if(score>=80){
			System.out.println("������ B ����Դϴ�.");
		}else if(score>=70){
			System.out.println("������ C ����Դϴ�.");
		}else if(score>=60){
			System.out.println("������ D ����Դϴ�.");
		}else{
			System.out.println("������ E ����Դϴ�.");
		}
	
	}

}
