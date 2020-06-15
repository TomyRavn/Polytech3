class Calc{
	public static int abs(int a) { return a > 0? a:-a; }
	public static int max(int a, int b) { return (a>b)? a:b; }
	public static int min(int a, int b) { return (a>b)? b:a; }
}

public class CalcEx {
	public static void main(String[] args) {
		System.out.println(Calc.abs(-5));
		System.out.println(Calc.max(10, 8));
		System.out.println(Calc.min(-3, -8));
	}
}

//정적 메소드 내에서는 정적 멤버만 사용 가능

//운영체제에서 자바(JVM)에 일정 메모리 할당
//스택은 프레임(호출 등 작업 처리(순서))
//힙은 동적 , 객체 할당 등
//메소드 영역에서 이루어 지는 것이 static과 같이 자바를 실행했을 때 메모리 할당되는 부분