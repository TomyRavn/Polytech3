
public class Ex01 {

	public static void main(String[] args) {
//		String[] intArray;
//		intArray = new String[5];
//		
//		for (int i =0; i<intArray.length; i++) {
//			System.out.println(intArray[i]);
//
//	}
		
		String str1 = "홍길동";
		String str2 = "임꺽정";
		String str3 = new String("임꺽정");
		String str4 = "임꺽정";
		
//		if(str1 == str2)
//			System.out.println("일치");
//		else
//			System.out.println("불일치");
//		
//		if(str4 == str2)
//			System.out.println("일치");
//		else
//			System.out.println("불일치");
		
		if(str1.equals(str2))
			System.out.println("일치");
		else
			System.out.println("불일치");
		
		if(str4 == str2)
			System.out.println("일치");
		else
			System.out.println("불일치");
	}
}
