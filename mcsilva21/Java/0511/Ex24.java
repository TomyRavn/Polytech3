
public class Ex24 {

	public static void main(String[] args) {
		
		//'a','b','c'�� ASCII�ڵ� ���� 10����,8����,16������ ����ϴ� ���α׷��� �ۼ��Ͽ� ����.
		
		char A,B,C;
		A = 'a';
		B = 'b';
		C = 'c';
		
		System.out.println("=============================");
		System.out.println("      10����         8����        16����       ");
		System.out.println("------------------------------");
		System.out.printf("'a'\t" + "%d\t", (int)A); //10����
		System.out.printf("%04o\t", (int)A); //8����
		System.out.printf("%x\t", (int)A); //16���� //System.out.printf("c,d�� �� ==> %5.1f,%5.1f\n",c,d);//
		System.out.printf("\n");
		
		
		System.out.printf("\t" + "%d\n", (int)B); //10����
		System.out.printf("%o\n", (int)B); //8����
		System.out.printf("%x\n", (int)B); //16����
		
				
		
		
	}

}
