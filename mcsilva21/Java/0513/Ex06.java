import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 	
		System.out.println("���������� �Է��ϼ���");
		int x = scan.nextInt();
		System.out.println("���������� �Է��ϼ���");
		int y = scan.nextInt();
		System.out.println("ö�������� �Է��ϼ���");
		int z = scan.nextInt();	
		
		String str = (x>=70 && y>=70 && z>=70) ? "���" :"������ȸ��";
		System.out.println(str);
	 
		
	}
	}
