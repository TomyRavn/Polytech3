public abstract class DObject {			//추상 클래스 선언
	
	public DObject next;
	public DObject() {next = null;}
	abstract public void draw();		//추상 메소드 선언
	
}