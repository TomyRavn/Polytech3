package super_sub;

public class B extends A{
	void set() {
		
		//�ν��Ͻ� ����̱� ������ ��ü ���� �� ȣ�� ���� 
		i = 1;
		pro = 2;
//		pri = 3;
		setPri(3);
		pub = 4;
		
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.set();
		
		System.out.println(b.i);
		System.out.println(b.pro);
		System.out.println(b.getPri());
		System.out.println(b.pub);
	}
}