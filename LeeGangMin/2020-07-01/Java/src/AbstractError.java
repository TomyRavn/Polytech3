public class AbstractError {
	
	public static void main(String[] args) {
		
//		DObject obj = new DObject();
		
		//////////////////////////////////////
		//1.
//		DObject obj = new DObject() {
//			@Override
//			public void draw() {
//				System.out.println("æ»≥Á«œººø‰");
//			}
//		};
//		
//		obj.draw();
		
		
		DObject obj = new Line();
		obj.draw();
		obj = new Circle();
		obj.draw();
		System.out.println("-------");
		DObject obj1 = new Rect();
		obj.draw();
		obj1.draw();
		System.out.println("-------");
		obj = obj1;
		obj.draw();
		obj1.draw();
	}
	
}