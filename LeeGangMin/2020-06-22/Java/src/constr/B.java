package constr;

class B extends A{
	public B() {
		System.out.println("������ B");
	}
	
	public B(int x) {
		//������ super(); �⺻�����ڰ� �־ �⺻�����ڰ� ����Ǵ� ���̾���
		super(x);
		System.out.println("�Ű����� ������ B");
	}
}