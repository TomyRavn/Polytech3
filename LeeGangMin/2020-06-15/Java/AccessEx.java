class Sample {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void setD(int d) {
		this.d = d;
	}
	
	public int getD() {
		return d;
	}
}

public class AccessEx extends Sample{
	public static void main(String[] args) {
		Sample aClass = new Sample();
		aClass.a = 10;
		aClass.b = 10;
		aClass.c = 10;
		aClass.setD(10);
		
		System.out.printf("%d, %d, %d, %d", aClass.a, aClass.b, aClass.c, aClass.getD());
	}
}

//Ŭ������ �뵵
//1. ���̺귯�� : �������� �̿�
//2. ����� : main() �޼ҵ带 ������ �ִ� ������ �������� ���� Ŭ����



//static Ű���尡 ���� �ʵ��
//�ڹ� ���α׷��� �����ϸ� JVM�� ���ؼ� ���ÿ� ����
//�������� ��ü�� �������� �ʾƵ� METHOD AREA������ �������
//METHOD AREA������ �ϳ��� ������

//�ν��Ͻ� �ʵ�� ��ü�� �׶��׶� ������ ������ ����ؼ� �� ������ ����

//Static �ʵ�(���� ���)�� ��ü�� �������� �ʰ� Ŭ�����̸��� ���ؼ� ���̷�Ʈ�� ���� �� Ȱ���� ����
