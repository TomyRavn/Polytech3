import java.util.Scanner;

public class Rectangle {
	int width;
	int height;
	
	public Rectangle(int w, int h){
		width = w;
		height = h;
	}
	
	public int getArea() {
		return width * height;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ʺ� , ���� �Է� >> ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		Rectangle rect = new Rectangle(a, b);
		
		System.out.printf("�簢���� ������ %d�Դϴ�.", rect.getArea());
	}
}