import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ���� ���ڷ� ������ ������ �������ּ���");
		int number = sc.nextInt();
		
		int numberArray[];
		numberArray = new int[number];
		
		for(int i = 0; i < numberArray.length; i++)
		{
			numberArray[i] = (int)(Math.random() * 9);	//1 ~ 10^n��

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
			System.out.printf("%d ��° �� : %d\n", i+1, numberArray[i]);
		}
		
	}
}