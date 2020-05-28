package may_27;

public class Ex01 {
	public static void main(String[] args) {
//		//1.
//		//int[] intArray = {10, 20, 30};
//		
//		//2.
//		int[] intArray;
//		intArray = new int[5];		//0으로 초기화가 되어있음
//		
//		//3.
//		boolean[] boolArray;
//		boolArray = new boolean[5];	//false로 초기화 되어있음
//		
//		//4.
//		String[] strArray;
//		strArray = new String[5];	//null로 초기화 되어있음
//		
//		
//		//출력
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
		
		
		String str1 = "임꺽정";
		String str2 = "임꺽정";
		String str3 = new String("임꺽정");
		String str4 = "임꺽정";
		
		if(str1 == str2) System.out.println("일치");
		else System.out.println("불일치");
		
		if(str1 == str3) System.out.println("일치");
		else System.out.println("불일치");
		
		if(str2 == str3) System.out.println("일치");
		else System.out.println("불일치");
		
		if(str2 == str4) System.out.println("일치");
		else System.out.println("불일치");
		
		if(str3 == str4) System.out.println("일치");
		else System.out.println("불일치");
	}
}