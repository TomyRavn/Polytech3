import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
				
		final int KOR = 1;
		final int ETC = 2;
		final int MALE = 3;
		final int FEMALE = 4;
		
		System.out.println("당신의 국적은(korea(1)/ETC(2)");
		int country = sc.nextInt();
		
		System.out.println("당신의 성별은(MALE(3)/FEMALE(4)");
		int gender = sc.nextInt();
		
		if(country == KOR)
			if(gender == MALE)
				System.out.println("당신은 한국 남성입니다.");
			else System.out.println("당신은 한국 여성입니다.");
		else if (gender == MALE)
			System.out.println("당신은 외국 남성입니다.");
		else System.out.println("당신은 외국 여성입니다.");


}
}