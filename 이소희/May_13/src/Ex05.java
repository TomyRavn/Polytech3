
public class Ex05 {

	public static void main(String[] args) {
		/*Q3> 1부터 5 까지의 정수에 대하여 제곱 값과 세제곱 값을 화면에 출력하는 프로그램을 작성하시오.(정수 값의 증가는 증감 연산자를 활용한다.)
		Int		Square		Cube
		1		1			1
		2		4			8
		3		9			27
		4		16			64
		5		25			125 */
		
		int x= 1;
	
		System.out.printf("%15s%15s%15s\n", "Int","Square","Cube");
		System.out.printf("%15s%15s%15s\n", x, x*x, x*x*x);
		x++;
		System.out.printf("%15s%15s%15s\n", x, x*x, x*x*x);
		x++;
		System.out.printf("%15s%15s%15s\n", x, x*x, x*x*x);
		x++;
		System.out.printf("%15s%15s%15s\n", x, x*x, x*x*x);
		x++;
		System.out.printf("%15s%15s%15s\n", x, x*x, x*x*x);
		

	}

}
