package exam;

public class UsingOverride {
	public static void main(String[] args) {
		DObject start, last, obj;
		
		start = new Line();
		last = start;
		
		obj = new Rect();
		last.next = obj;
		last = obj;
		
		obj = new Line();
		last.next = obj;
		last = obj;
		
		obj = new Circle();
		last.next = obj;
		last = obj;
		
		obj = new Rect();
		last.next = obj;
		last = obj;
		
		DObject p = start;
		while(p != null) {
			p.draw();
			p = p.next;
		}
	}
}