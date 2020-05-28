import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		int randomNumber = 0;
		boolean duplicate = false;
		
		while(true) {
			System.out.println("�� ���� ���ڷ� ������ ������ �������ּ���(1 ~ 9��)");
			number = sc.nextInt();
			
			if(number >= 1 && number <= 9) break;
			else System.out.println("������ ��� �Է��Դϴ�(1 ~ 9��)");
		}
		
		int numberArray[];
		numberArray = new int[number];
		
		//�ʱ�ȭ
		for(int i = 0; i < number; i++) {
			duplicate = true;
			//ù° �ڸ����� 0�� �� �� ����
			if(i == 0) {
				numberArray[i] = (int)(Math.random() * 9 + 1);
			}
			else {
				while(duplicate) {
					randomNumber = (int)(Math.random() * 9);
					duplicate = false;
					
					for(int j = 0; j < i; j++) {
						if(numberArray[j] == randomNumber) {	//�տ� �� ���� ��ø�Ǹ�
							duplicate = true;
							break;								//for���� ��������
						}
					}
				} //�� �� randomNumber�� ��ø���� �ʴ� ��
				numberArray[i] = randomNumber;	//�׷��Ƿ� ����
			}
		}
		
		
		//���� ó�� �κ�
		int[] tempArray;					//���ظ� ���ؼ� �ӽ� ���� �迭
		int[] userNumArray;					//���ص� �迭
		tempArray = new int [number];
		userNumArray = new int [number];
		
		//�õ��� Ƚ��
		int gameCount = 0;
		
		//������ �Է��� �ڸ����� �Է¹����Ƿ�, 10^n�� �����ش�
		int multiply = 1;
		for(int i = 1; i < number; i++) {
			multiply *= 10;
		}
		
		//���� ����
		while(true)
		{
			int strikeCount = 0;			//��Ʈ����ũ Ƚ�� 0���� �ʱ�ȭ
			int ballCount = 0;				//�� Ƚ�� 0���� �ʱ�ȭ
			int multiplyTemp = multiply;	//10^n���� �ʱ�ȭ
			boolean empty = true;
			
			gameCount++;					//�ݺ����� ���ƿö����� ���� Ƚ�� ����
			
			//����� �Է�
			System.out.printf("-------- %dȸ ° --------\n", gameCount);
			System.out.printf("���ڸ� �Է��ϼ��� > ");
			int userNum = sc.nextInt();
			
			//������ �Է��� ���ڸ� �迭�� �ϳ��� �����Ͽ� ����
			for(int i = 0; i < number; i++) {
				userNumArray[i] = userNum / multiplyTemp;					//ù�ڸ� ���� �����Ͽ� ����
				tempArray[i] = userNum - (userNumArray[i] * multiplyTemp);	//ù�ڸ� ���� �� ���������� �� �� ����(��: 98710 - 9 * 10000)
				userNum = tempArray[i];		//���������� userNum�� �����Ͽ� �ٽ� �ݺ��� ���
				multiplyTemp /= 10;			//10^n���� �ڸ����� �����Ͽ� ���(�� ��, ��õ��� ���� �ٽ� ������ multiply�� �ݺ��� ���۽� �ʱ�ȭ)
			}
		
			//��Ʈ����ũ, �� ī��Ʈ ���� ó��
			for(int i = 0; i < number; i++) {
				if(userNumArray[i] == numberArray[i]) strikeCount++;		//�Էµ� �ڸ����� �Ȱ��� ���� �� ��Ʈ����ũ Ƚ�� ����
			
				for(int j = 0 ; j < number ; j ++)
				{
					if(i != j) {
						if(userNumArray[i] == numberArray[j]) ballCount++;	//�ڸ����� �ٸ��� �Ȱ��� ���� ���� �� �� Ƚ�� ����
					}
				}
			}
		
			//��¿�
//			for(int i = 0; i < number; i++){
//				System.out.printf("%d ��° �� : %d\n", i+1, numberArray[i]);
//				System.out.printf("�Էµ� %d ��° �� : %d\n", i+1, userNumArray[i]);
//			}
			
			//��� ���
			System.out.printf("%d ��Ʈ����ũ\t %d ��\n", strikeCount, ballCount);
			//�̱�� ����(�ݺ��� ��������)
			if(strikeCount == number) {
				System.out.printf("%d�� ���� ������ ���߼̽��ϴ�.", gameCount);
				break;
			}
		}
	}
}