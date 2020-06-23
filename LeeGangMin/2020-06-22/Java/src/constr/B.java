package constr;

class B extends A{
	public B() {
		System.out.println("생성자 B");
	}
	
	public B(int x) {
		//원래는 super(); 기본생성자가 있어서 기본생성자가 실행되는 것이었음
		super(x);
		System.out.println("매개변수 생성자 B");
	}
}