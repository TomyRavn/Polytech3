package exam;

class SuperObject {
	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.print("�θ�");
		System.out.println(name);
	}
}

public class SubObject extends SuperObject{
	protected String name;
	
	public void test() {
		System.out.println("�׽�Ʈ");
	}
	
	@Override
	public void draw() {
		System.out.print("�ڽ�");
		name = "Sub";
		super.name = "Super";
		super.draw();
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		SubObject b = new SubObject();
		b.paint(); //->b.paint �� draw�� �ڽ� ��ü�� draw �޼ҵ带 ȣ��(�ڽ� Ŭ���� ����� ��ü���� ȣ���� �޼ҵ�� �ڽ� Ŭ������ �޼ҵ带 ȣ��)
		System.out.println("*");
//		b.draw();
		
		SuperObject a = new SuperObject();
		a.draw();	//�θ� Ŭ���� ����� ��ü���� ȣ���� �޼ҵ�� �θ� �ڽ��� �޼ҵ带 ȣ��
		//a.test(); //�ڽ� ��ü���� �߰��� ���Խ�Ų �޼ҵ�� �θ� Ŭ���� ������������ ���Ұ�
					//������ ���� �޼ҵ�� ��밡���ϴ�
	}
}