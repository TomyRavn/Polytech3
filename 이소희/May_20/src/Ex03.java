import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// 메뉴 선택 하기, 없는 메뉴를 선택하면 다시 선택하기 하기
		Scanner sc = new Scanner(System.in);
		int menu;
		
		do { System.out.println("1.파일 열기");
			System.out.println("2.파일저장");
		 	System.out.println("메뉴 선택>>");
		 	menu = sc.nextInt();
		 	
		}while (menu > 1 || menu < 3);
//		}while (!(menu >=1 && menu <=2));

	}

}
