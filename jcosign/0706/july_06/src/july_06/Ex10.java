package july_06;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		//�Էµ� ���ڿ��� �Ųٷ� ���
		Scanner s = new Scanner(System.in);
		String str;
		
		System.out.print("���ڿ� �Է� ==>");
		str = s.nextLine();

		System.out.print("���ڿ� ��� ==>");
		
		for(int i=str.length()-1; i>=0; i--)		//���ڿ��� �Ųٷ� �ؾ��ϴ� ���ڰ� �Ųٷ� ����. 
			System.out.printf("%c",str.charAt(i));
	}

}
