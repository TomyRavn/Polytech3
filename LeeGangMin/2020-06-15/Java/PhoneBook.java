import java.util.Scanner;

class Phone{
	String name;
	String tel;
}

public class PhoneBook {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("�ο��� >> ");
		int num = sc.nextInt();

		Phone[] a = new Phone[num];

		for (int i = 0; i < a.length; i++) {
			a[i] = new Phone();
			System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȭ��ȣ�� ��ĭ���� �Է�) >> ");
			a[i].name = sc.next();
			a[i].tel = sc.next();
		}
		System.out.println("����Ǿ����ϴ�.");
		sc.nextLine();
		
		
		while(true) {
			System.out.print("�˻��� �̸� >> ");
			String name = sc.nextLine();
			boolean isIn = true;
			
			if(name.equals("�׸�")) {
				break;
			}
			else {
				for (int i = 0; i < a.length; i++) {
					if(name.equals(a[i].name)) {
						System.out.printf("%s�� ��ȭ��ȣ�� %s�Դϴ�.\n", name, a[i].tel);
						isIn = true;
						break;
					}
					else {
						isIn = false;
					}
				}
				if(!isIn) System.out.printf("%s(��)�� �����ϴ�.\n", name);
			}

		}

	}
}