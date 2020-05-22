import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 개의 숫자로 게임할 것인지 선택해주세요");
		int number = sc.nextInt();
		
		int numberArray[];
		numberArray = new int[number];
		
		for(int i = 0; i < numberArray.length; i++)
		{
			numberArray[i] = (int)(Math.random() * 9);	//1 ~ 10^n개

			if(numberArray[0] == 0) continue;
			else {
				for(int j = 0; j < numberArray.length; j++) {
					numberArray[i] = (int)(Math.random() * 9);
					if(numberArray[i] == numberArray[j]) continue;
					else break;
				}
			}
		}
		
		for(int i = 0; i < numberArray.length; i++)
		{
			System.out.printf("%d 번째 수 : %d\n", i+1, numberArray[i]);
		}
		
	}
}