package may_27;

public class Ex01 {
	public static void main(String[] args) {
//		//1.
//		//int[] intArray = {10, 20, 30};
//		
//		//2.
//		int[] intArray;
//		intArray = new int[5];		//0���� �ʱ�ȭ�� �Ǿ�����
//		
//		//3.
//		boolean[] boolArray;
//		boolArray = new boolean[5];	//false�� �ʱ�ȭ �Ǿ�����
//		
//		//4.
//		String[] strArray;
//		strArray = new String[5];	//null�� �ʱ�ȭ �Ǿ�����
//		
//		
//		//���
//		for (int i = 0; i < intArray.length; i++) {
//			System.out.println(intArray[i]);
//		}
//		
//		for (int i = 0; i < boolArray.length; i++) {
//			System.out.println(boolArray[i]);
//		}
//		
//		for (int i = 0; i < strArray.length; i++) {
//			System.out.println(strArray[i]);
//		}
		
		
		String str1 = "�Ӳ���";
		String str2 = "�Ӳ���";
		String str3 = new String("�Ӳ���");
		String str4 = "�Ӳ���";
		
		if(str1 == str2) System.out.println("��ġ");
		else System.out.println("����ġ");
		
		if(str1 == str3) System.out.println("��ġ");
		else System.out.println("����ġ");
		
		if(str2 == str3) System.out.println("��ġ");
		else System.out.println("����ġ");
		
		if(str2 == str4) System.out.println("��ġ");
		else System.out.println("����ġ");
		
		if(str3 == str4) System.out.println("��ġ");
		else System.out.println("����ġ");
	}
}