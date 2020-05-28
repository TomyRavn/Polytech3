import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 국적은(korea(1)/ETC(2)");
		int x = sc.nextInt();			
		if (x == 1)
			System.out.println("당신의 성별은(MALE(3)/FEMALE(4)");
		else  System.out.println("당신은 외국인 입니다.");
		
		int y = sc.nextInt();
		if (y == 4)
			System.out.println("당신은 한국 여성입니다.");
		else System.out.println("당신은 한국 남성입니다.");
		
		


}
}