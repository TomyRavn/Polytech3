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
		
		System.out.print("너비 , 높이 입력 >> ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		Rectangle rect = new Rectangle(a, b);
		
		System.out.printf("사각형의 면적은 %d입니다.", rect.getArea());
	}
}