import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ���� ���ڷ� ������ ������ �������ּ���");
		int number = sc.nextInt();
		
		int numberArray[];
		numberArray = new int[number];
		boolean differentArray[][];
		boolean finaltest = false;
		differentArray = new boolean[number][number];
		
		//�ʱ�ȭ
		for(int i = 0; i < numberArray.length; i++) {
			//ù° �ڸ����� 0�� �� �� ����
			if(i == 0) {
				numberArray[i] = (int)(Math.random() * 9 + 1);
			}
			else {
				numberArray[i] = (int)(Math.random() * 9);
			}
			for(int j = 0; j < numberArray.length; j++) {
				differentArray[i][j] = false;
			}
		}

		//�� �ڸ����� ������ ���ڰ� ���� �� �ٽ� ������
		while(true) {

			for(int i = 0; i < numberArray.length; i++) {
				for(int j = 0; j < numberArray.length; j++) {
					
				if(i == j) {differentArray[i][j] = true;}
				else {
					if(numberArray[i] != numberArray[j]) differentArray[i][j] = true; 
					else {
						numberArray[j] = (int)(Math.random() * 9);
						differentArray[i][j] = false;
					}
				}
				
				}
			}
			
			for(int i = 0; i < differentArray.length; i++) {
				for(int j = 0; j < differentArray.length; j++) {
				
					if(!differentArray[i][j]) {
						numberArray[j] = (int)(Math.random() * 9);
						differentArray[i][j] = false;
					}
					else {
						differentArray[i][j] = true;
					}
				
				}
			}
			
			finaltest = true;
			if(finaltest == true) break;
		}
		
		
		for(int i = 0; i < numberArray.length; i++){
			System.out.printf("%d ��° �� : %d\n", i+1, numberArray[i]);
		}
		
	}
}