import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 스트링 값 2개에 각각의 경우를 설정하여 저장해 출력
//		System.out.print("당신의 국적은 (KOREA(1) / ETC(2))? ");
//		int c = sc.nextInt();
//		System.out.print("당신의 성별은 (MALE(3) / FEMALE(4))? ");
//		int g = sc.nextInt();
//		String str1, str2;
//		str1 = str2 = "";
//		
//		if(c == 1) {
//			str1 = "한국 ";
//		}else if(c == 2) {
//			str1 = "해외 ";
//		}
//		if(g == 3) {
//			str2 = "남성";
//		}else if(g == 4) {
//			str2 = "여성";
//		}
//		System.out.println("당신은 " + str1 + str2 + "입니다.");
		
		//2. 스트링 값 1개에 조건에 따라 문자열을 추가하는 방식으로 출력
//		String str = "";
//		System.out.print("당신의 국적은 (KOREA(1) / ETC(2))? ");
//		int info = sc.nextInt();
//		
//		if (info == 1) {
//			str += "한국 ";
//		} else if(info == 2) {
//			str += "해외 ";
//		}
//		
//		System.out.print("당신의 성별은 (MALE(3) / FEMALE(4))? ");
//		info = sc.nextInt();
//		
//		if (info == 3) {
//			str += "남성";
//		} else if(info == 4) {
//			str += "여성";
//		}
//		
//		System.out.println("당신은 " + str + "입니다.");
		
		//3. 중첩 if문으로 해당 조건 만족하는 경우 바로 출력
		System.out.print("당신의 국적은 (KOREA(1) / ETC(2))? ");
		int c = sc.nextInt();
		System.out.print("당신의 성별은 (MALE(3) / FEMALE(4))? ");
		int g = sc.nextInt();
		
		//final int KOR = 1;
		//final int ETC = 2;
		//final int MALE = 3;
		//final int FEMALE = 4;	==> 가독성을 위해 숫자를 문자로 정의(이후에 KOR, ETC, MALE, FEMALE을 1,2,3,4 대신 쓸 수 있음)
		
		if(c==1) {
			if(g==3) System.out.println("당신은 한국 남성입니다.");
			else System.out.println("당신은 한국 여성입니다.");
		}
		else {
			if(g==3) System.out.println("당신은 해외 남성입니다.");
			else System.out.println("당신은 해외 여성입니다.");
		}
	}
}