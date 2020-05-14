
public class Ex05 {
	public static void main(String[] args) {
		int var1 = 10;
		int var2 = 012;
		int var3 = 0xA;
		
		//System.out.println(var1);
		//System.out.println(var2);
		//System.out.println(var3);
		
		System.out.printf("10진수:%d\n", var1);
		System.out.printf("8진수:%o\n", var2);
		System.out.printf("16진수:%x\n", var3);
		System.out.printf("16진수:%#x", var3);
		//#을 붙이면 문자열 그대로 출력!
	}              

}
