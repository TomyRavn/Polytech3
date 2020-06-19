import java.util.Scanner;

public class Rectangle {
	
	int width;
	int height;
	
	
	public double getArea(){
		return width*height;
		
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	Rectangle result;
	result = new Rectangle();
	
	System.out.println("너비를 입력하시오.");
	result.width = sc.nextInt();
	
	System.out.println("높이를 입력하시오.");
	result.height = sc.nextInt();
	
	System.out.printf("사각형의 면적 : "+ result.getArea());
	
	
}
}
