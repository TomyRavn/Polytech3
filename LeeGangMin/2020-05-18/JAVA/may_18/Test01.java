import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//������ 1,2,3�� �̴� ����
//		int a = (int)(Math.random()*10 + 1);	//(int)Math.random()*10 �� �� ��� 0.XX�� ������ ���� ��ȯ�Ͽ� 0*10�� �ǹǷ� ����
												//1���� 9���� ������� �����ϼ����� �ƴ�. 1���� 10������
		
		//���Ǹ� ���� ����
		final int SCISSORS = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		//��ǻ�Ͱ� �̴� ����(����(1), ����(2), ��(3)�� ����)
		int com = 0;
		
		//1~3���� �̾Ƽ� ����
		com = (int)(Math.random()*3 + 1);
		
		//���� ��� ����,����,�� ����� ����
		String str = "";
		if(com == SCISSORS) str = "����";
		else if(com == ROCK) str = "����";
		else if(com == PAPER) str = "��";
		
		//����� �Է�
		System.out.println("���ڸ� �Է����ּ���. ����(1) ����(2) ��(3)");
		int input = sc.nextInt();
		
		//1. if�� �� ���
		if(com == input) System.out.println("�����ϴ�");					//����� ���
		else {															//�� ����� ���
			if(input == SCISSORS || input == ROCK || input == PAPER) {	//1,2,3 �Է� �̿��� �Է��� ��� ����ó��
				if(com == SCISSORS) {
					if(input == ROCK) System.out.println("�̰���ϴ�");
					else System.out.println("�����ϴ�");
				}
				else if(com == ROCK) {
					if(input == PAPER) System.out.println("�̰���ϴ�");
					else System.out.println("�����ϴ�");
				}
				else {
					if(input == SCISSORS) System.out.println("�̰���ϴ�");
					else System.out.println("�����ϴ�");
				}
			} else System.out.println("�߸��� �Է�");						//1,2,3 �Է� �̿��� �Է��� ��� ����ó��
		}
		System.out.printf("��ǻ�ʹ� %s�� �½��ϴ�.\n", str);
		
		
		//2. switch�� �� ���
//		String str2 = ""; 		//��� ����� ����
//		switch(input)
//		{
//		case SCISSORS:
//			str2 = com == SCISSORS? "�����ϴ�":com == ROCK? "�����ϴ�":"�̰���ϴ�";
//			break;
//		case ROCK:
//			str2 = com == SCISSORS? "�̰���ϴ�":com == ROCK? "�����ϴ�":"�����ϴ�";
//			break;
//		case PAPER:
//			str2 = com == SCISSORS? "�����ϴ�":com == ROCK? "�̰���ϴ�":"�����ϴ�";
//			break;
//		default:
//			str2 = "�߸��� �Է��Դϴ�";
//		}
//		System.out.println(str2);
//		System.out.printf("��ǻ�ʹ� %s�� �½��ϴ�.\n", str);
//		str ��� com==1?"����":com==2?"����":"��" �� �ᵵ ��
	}
}