public class Test3 {
	public static void main(String[] args) {
		//1���� 5���� ������ ���Ͽ� ���� ���� �� ���� ���� ȭ�鿡 ����ϴ� ���α׷� �ۼ�
		//(���� ���� ������ ���� �����ڸ� Ȱ��)
		int num=1;
		System.out.printf("%-6s %s\t %s\n", "Int", "Square", "Cube");
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		num++;
		System.out.printf("%-7d  %d\t  %d\n", num, num*num, num*num*num);
		
//		System.out.printf("Int\t Square\t Cube\n");
//		for(int i = 1; i <= 5; i++) {
//			System.out.printf("%d\t %d\t %d\n", num, num*num, num*num*num);
//			num++;
//		}
	}
}