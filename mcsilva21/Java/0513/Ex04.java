import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		//3���� ������ x,y,z ���� ū ���� ����
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("���ڸ� �Է��ϼ���");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		int max;
		
		max = x>y? x:y;
		max = max>z? max:z;
		
		// int max = (x>=y && x>=z)? x:(y>=x && y>=z)?y:z;)
			
		System.out.printf("�ִ밪:%d\n", max);	

	}

}
