public class ColorPoint extends Point{
	String color;
	void setColor(String color) {
		this.color = color;
	}
	
	void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
	
	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);			//Point 클래스의 set() 메소드 호출
		cp.setColor("red");		//색 지정
		cp.showColorPoint();	//컬러 점의 좌표 출력
	}
}