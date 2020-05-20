import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in); 
		final int Kore = 1;     //기호 상수//
		final int ETC = 2;
		final int MALE = 3;
		final int FEMALE = 4;
		
		
		System.out.println("당신의 국적은 (KOREA(1)/ETC(2))?");
		int N = scan.nextInt();
		
		System.out.println("당신의 성별은 (MALE(3)/FEMALE(4))?");
		int S = scan.nextInt();
		
		if (N==1) 
			if(S==3)
			System.out.println("당신은 한국남자 입니다.");
			else
				System.out.println("당신은 한국여자 입니다.");	
			else
					if (S==3)
					System.out.println("당신은 외국 남성 입니다.");
					else
					System.out.println("당신은 외국 여성 입니다.");	
				
	}


	}

	