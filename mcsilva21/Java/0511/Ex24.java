
public class Ex24 {

	public static void main(String[] args) {
		
		//'a','b','c'의 ASCII코드 값을 10진수,8진수,16진수로 출력하는 프로그램을 작성하여 보자.
		
		char A,B,C;
		A = 'a';
		B = 'b';
		C = 'c';
		
		System.out.println("=============================");
		System.out.println("      10진수         8진수        16진수       ");
		System.out.println("------------------------------");
		System.out.printf("'a'\t" + "%d\t", (int)A); //10진수
		System.out.printf("%04o\t", (int)A); //8진수
		System.out.printf("%x\t", (int)A); //16진수 //System.out.printf("c,d의 값 ==> %5.1f,%5.1f\n",c,d);//
		System.out.printf("\n");
		
		
		System.out.printf("\t" + "%d\n", (int)B); //10진수
		System.out.printf("%o\n", (int)B); //8진수
		System.out.printf("%x\n", (int)B); //16진수
		
				
		
		
	}

}
