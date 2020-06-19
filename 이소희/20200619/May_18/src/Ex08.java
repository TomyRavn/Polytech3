
public class Ex08 {

	public static void main(String[] args) {
		// while 반복문 1 부터 10까지의 합
		
		
		int i = 1;
		int sum = 0;
		
		while(i <=10) {
		sum += i; //sum = sum + 1;
		i++;
		}
		
		System.out.printf("전체합: %d\n" , sum);
	}
}

		
// 5번 반복 후 빠져나오기! 
//	int i = 1;
//	
//	
//	while(true){
//		System.out.println("Hello~");
//		
//		if(i >= 5)
//			break;
//		
//		i++;
//}
//
//	
//}

