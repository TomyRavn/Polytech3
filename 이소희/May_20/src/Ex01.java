
public class Ex01 {

	public static void main(String[] args) {
		//do-while 반복문 1부터 10 까지의 합
		
		int i =1;
		int sum = 0;
		
			
		do {sum += i;
			i++;
		} while (i<=10);
		System.out.printf("1부터 10까지의 합: %d" , sum);

	}

}
