import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		//Ű�� �����Ը� �Է¹޾�, �������� ������ ����ϴ� ���α׷� �ۼ�
		//( Ű - 100 ) * 0.9 == ǥ�� ü��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ű�� �Է��ϼ��� > ");
		double height = sc.nextInt();
		System.out.print("�����Ը� �Է��ϼ��� > ");
		double weight = sc.nextInt();
		double average_weight = (height - 100) * 0.9;
		
		//ǥ�� ü�� ����ϴ� �׽�Ʈ �Լ�
//		System.out.println(average_weight);
//		
//		if(average_weight >= weight) System.out.println("����");
//		else System.out.println("��");
		
		if(average_weight < weight)
			System.out.println("��ü��");
		else if(weight >= average_weight -5 && weight <= average_weight + 5) //���� ��ü�� �������� ������ �� else if ���
			System.out.println("ǥ��");
		else
			System.out.println("��ü��");		//==> �Է��� ���� if�� else if �� �����ϸ� �ش� if������ ���̻� üũ���� �ʰ� �ٷ� ��������
											//���� if(10>=5){} if(10>=9){}�� ���� �������� ���� if�� �ۼ��̸� �� �� üũ������
											//if(10>=5){} else if(10>=9){}�� ���� �ۼ��Ǹ� �� ó���� if���� üũ�� ��
	}
}