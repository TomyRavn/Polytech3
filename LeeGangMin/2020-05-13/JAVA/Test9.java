import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ĺ��� �Է��ϼ��� > ");
		char ch = sc.nextLine().charAt(0);
		
		if(ch>=65 && ch<97) System.out.println("1");	//==> ��Ȯ�� ������ 65~90���� ���� (ch>=65 && ch <=90)
		else System.out.println("0");					//�Ǵ� ���������� (ch>='A' && ch<='Z')�� ǥ��
		
		//=== 2. ===//
//		ch = ch>=65 && ch<97? '1':'0';
//		System.out.println(ch);
		
		//=== ����(�� �ҹ��� ��ȯ) ===//
		if(ch>=65 && ch<97) ch += 32;	//�빮�ڸ� �ҹ��ڷ�
		else ch -= 32;					//�ҹ��ڸ� �빮�ڷ�
		System.out.println(ch);
	}
}