import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("  [[ MENU ]]  ");
		System.out.println("1.  «��");
		System.out.println("2.  ����");
		System.out.println("3.  ��ȸ�����");
		System.out.println("4.  Į����");
		System.out.print("�޴� ���� >> ");
		
		int menu = sc.nextInt();
		
		//if - else if���� �� == (��ġ ���� �Ǵ�)������ ���ǽĸ� switch�������� ��ȯ����
		//switch ������ ��� if - else if�������� ��ȯ����
		switch(menu) {
		case 1 : System.out.println("«�� ����~"); break;		//case�� �ٴ� ����� ������ �迭�� ����� �� �� ����(C������ ����)	
		case 2 : System.out.println("���� ����~");	break;		//������ ����� ������ ������ �ʴ´�
		case 3 : System.out.println("��ȸ����� ����~");	break;	//'A'�� ���� ���� ���� ����� ����(ASCII�ڵ��� ������)
		case 4 : System.out.println("Į���� ����~"); break;
		default : System.out.println("�������� �ʴ� �׸��Դϴ�. �ٽ� �Է����ּ���");
		}
	}
}