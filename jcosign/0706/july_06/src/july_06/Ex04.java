package july_06;

public class Ex04 {

	public static void main(String[] args) {
		String str = "Java�� �����ϴ� ��, Java�� ����־��.^^";		//0����.�����̽��� ���ڿ�.
		
		System.out.println("���ڿ� ==>" + str);
		
		System.out.print("���� ó�� ������ Java ��ġ ==>");
		System.out.println(str.indexOf("Java"));		//Java ���ڰ� ó�� ������ ��ġ�� ����Ѵ�.
		System.out.print("���� �������� ������ Java ��ġ ==>");
		System.out.println(str.lastIndexOf("Java"));	//Java ���ڰ� ������ ������ ��ġ�� ����Ѵ�.
		
				//Ž���� �����ʺ��� ��������. ����� ���ʿ��� ���������� �Ѵ�.
	}

}
