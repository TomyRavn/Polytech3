package july_06;

public class Ex06 {

	public static void main(String[] args) {
		String str = "    �ѱ� ABCD efgh    ";		//�յڿ� �߰��� ������ ������, �ѱ۰� ���� �빮��, �ҹ��ڰ� �����ִ� ���ڿ�
		
		System.out.println("�� ���ڿ� ==> [" + str + "]");			
		System.out.println("�빮�ڷ� ==> [" + str.toUpperCase() + "]");		//�빮�ڷ� �ٲ۴�.
		System.out.println("�ҹ��ڷ� ==> [" + str.toLowerCase() + "]");		//�ҹ��ڷ� �ٲ۴�.
		System.out.println("�������� ==> [" + str.trim() + "]");				//������ �����Ѵ�.
	}

}
