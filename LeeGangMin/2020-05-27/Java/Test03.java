package may_27;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] lottoNumArray = new int[6];	//�ζ� ��ȣ ���� �迭
		int[] userNumArray = new int[6];	//������ �̴� ���ڸ� ���� �迭
		int[] sameNumArray = new int[6];	//��ġ�ϴ� ���ڸ� ��� ����� �迭
		
		boolean flag = true;				//���� �ݺ� ���Ḧ ���� �� ����
		boolean isShuffle = false;			//���� 1ȸ�� �ߴ��� Ȯ���ϱ� ���� �� ����
		
		//�ʱⰪ�� 100���� �����Ͽ� ���� ���� �ʾ��� �� �ʱ� ���� �����Ͽ� ��ġ�ϴ� ���ڰ� ������ �ʰ� ��
		for(int i = 0; i < lottoNumArray.length; i++) {
			lottoNumArray[i] = 100;
		}
		
		
		//���� �ݺ�
		while(flag) {
			
			int count = 0;						//��ġ�� �� �����ϴ� ī��Ʈ ����(��ġ�� �� ���� ����)
			
			System.out.println("\t     [[�޴� ����]]");
			System.out.println("1.�ζǹ�ȣ ����  2.�ζǹ�ȣ �Է�  3.��÷ Ȯ��  4.����");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				//1. �ζǹ�ȣ �ڵ� ���� && �ߺ� ����
				chooseNumberNoDuplicate(lottoNumArray, 45);
				//���� 1ȸ�� �ߴ��� Ȯ��
				isShuffle = true;
				//��ǻ�Ͱ� ���� ���� ���
				System.out.print("��ǻ�Ͱ� ���� ����: ");
				printArray(lottoNumArray);
				System.out.println("-------------------------------------");
				break;
				
			case 2:
				if(isShuffle) {
					//2. ����ڰ� �ζǹ�ȣ �Է�
					for(int i = 0; i < userNumArray.length; i++) {
						//����� �Է�
						System.out.printf("��÷ Ȯ���Ͻ� �ζ� ��ȣ �� %d��° ���ڸ� �Է��ϼ���(1~45) > ", i+1);
						userNumArray[i] = sc.nextInt();

						//1~45���� ������ ���ڰ� �ƴ� �� ���Է�
						if(userNumArray[i]<1 || userNumArray[i]>45) {
							System.out.println("�߸��� �Է�, 1 ~ 45���� ���ڸ� �Է��ϼ���");
							i--;
							continue;
						}
					}
				}
				else System.out.println("�ζ� ��ȣ�� �������� �ʾҽ��ϴ�.");
				break;
				
			case 3:
				if(isShuffle) {
					//3. ��÷Ȯ��
					count = resultCountInTwoOutCountAndOne(lottoNumArray, userNumArray, sameNumArray);

					//��� ���
					System.out.println("=================================");
					System.out.printf("�ζ� ���� ��ġ�ϴ� ���� : %d", count);
					System.out.printf("\n��ġ�ϴ� ���� : ");

					//����
					selectionSortArray(sameNumArray);
					//���ĵ� �� �Է��� ���ڿ� ��ġ�ϴ� �ζ� ��ȣ ���
					for (int i = 0; i < sameNumArray.length; i++) {
						if(sameNumArray[i] != 0) {
							System.out.printf("%-3d", sameNumArray[i]);	
						}
					}
					System.out.println();
				}
				else System.out.println("�ζ� ��ȣ�� �������� �ʾҽ��ϴ�.");

				break;
				
			case 4:
				//4. ����
				System.out.println("���α׷� ����");
				flag = false;
				break;
				
			default:
				System.out.println("�ٸ� ���� �Է��Ͽ����ϴ�. �ٽ� �������ּ���");
				break;
			}
		}
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	//�迭�� ��� ���ڸ� ����� �Լ�
	public static void printArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%-3d", x[i]);	
		}
		System.out.println();
	}
	
	//��ȣ�� �ߺ� ���� 1~max���� �̾��� �Լ�
	public static void chooseNumberNoDuplicate(int[] x, int max) {
		int temp = 0;						//�ζ� ��ȣ �ӽ÷� ���� ����
		
		for (int i = 0; i < x.length; i++) {

			boolean duplicate = true;		//�ζ� ��ȣ �ߺ� �̴� ���� ������ �� ����(�ʱⰪ�� true�� ����)

			while(duplicate) {

				temp = (int)(Math.random() * max + 1);	//�ζ� ��ȣ�� �ӽ÷� �̰�
				duplicate = false;						//�ߺ��� �ȵǸ� while���� ���� ����

				for (int j = 0; j < x.length; j++) {
					//�ߺ��� �Ǹ� duplicate ������ true�� �����Ǿ� ��� while���� ���� ��
					if(temp == x[j]) {
						duplicate = true;
						break;				//��ġ�� �� �� �̻� �˻縦 �ݺ��� �ʿ䰡 �����Ƿ� ���ڸ� �ٽ� �̴� while������ �ٷ� ���ư�
					}
				}

			}
			x[i] = temp;		//��ġ���� �ʴ� ��쿡�� while���� ���������Ƿ� �̶� temp�� ����� ���� �迭�� ����
		}
		
	}
	
	//�迭 3���� �Է¹޾Ƽ� x, y�迭�� �Է¹ް�,
	//z�迭�� ��ġ�ϴ� ���ڸ� �����ϴ� �迭�� ����
	//�׸��� ��ġ�ϴ� Ƚ���� ������ count ������ ��ȯ���ִ� �Լ�
	public static int resultCountInTwoOutCountAndOne(int[] x, int[] y, int[] z) {
		int count = 0;
		
		for(int i = 0; i < x.length; i++) {
			
			for(int j = 0; j < y.length; j++) {
				
				//����ڰ� ���� ������ �迭�� ��ǻ�Ͱ� �������� ���� ���ڸ� ���ؼ� ���� �� ī��Ʈ ����
				//�׸��� ��ġ�ϴ� ���ڸ� sameNumArray�迭�� �����
				if(y[j] == x[i]) {
					count++;
					z[i] = y[j];
				}
				
			}
		}
		return count;
	}
	
	//�迭�� �Է¹޾� ���� �������ִ� �Լ�
	public static void selectionSortArray(int[] x) {
		int temp = 0;	//���� ������ ���� �ӽ� �� ���� ����
		int index = 0;	//���� ������ ���� �ε��� ����
		int min = 0;	//���� ������ ���� �ּҰ� ����
		
		for (int i = 0; i < x.length; i++) {
			//���� ����
			for(int j = 0; j < x.length; j++) {
				
				index = j;				//�˻��� �ε��� �� �ʱ�ȭ
				min = x[j];	//�˻��� �ּҰ� �ʱ�ȭ
				
				for(int k = j + 1; k < x.length; k++) {
					//�ּҰ����� ���� �˻��ϴ� ���� ���� �� �ε����� �ּҰ��� ����
					if(x[k] < min) {
						index = k;
						min = x[k];
					}
				}
				//�˻��� �� �ּҰ��� �Ǿ� �ε����� ��ܿ�(�׸��� ���� for���� �ٽ� ������ ���� �ε����� �ּҰ����� ������)
				temp = x[j];
				x[j] = x[index];
				x[index] = temp;
			}
		}
	}
	
}