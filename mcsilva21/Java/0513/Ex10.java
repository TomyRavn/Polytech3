import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in); 
		final int Kore = 1;     //��ȣ ���//
		final int ETC = 2;
		final int MALE = 3;
		final int FEMALE = 4;
		
		
		System.out.println("����� ������ (KOREA(1)/ETC(2))?");
		int N = scan.nextInt();
		
		System.out.println("����� ������ (MALE(3)/FEMALE(4))?");
		int S = scan.nextInt();
		
		if (N==1) 
			if(S==3)
			System.out.println("����� �ѱ����� �Դϴ�.");
			else
				System.out.println("����� �ѱ����� �Դϴ�.");	
			else
					if (S==3)
					System.out.println("����� �ܱ� ���� �Դϴ�.");
					else
					System.out.println("����� �ܱ� ���� �Դϴ�.");	
				
	}


	}

	