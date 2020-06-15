import java.util.Scanner;

class Phone{
	String name;
	String tel;
}

public class PhoneBook {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("인원수 >> ");
		int num = sc.nextInt();

		Phone[] a = new Phone[num];

		for (int i = 0; i < a.length; i++) {
			a[i] = new Phone();
			System.out.print("이름과 전화번호(이름과 전화번호는 빈칸없이 입력) >> ");
			a[i].name = sc.next();
			a[i].tel = sc.next();
		}
		System.out.println("저장되었습니다.");
		sc.nextLine();
		
		
		while(true) {
			System.out.print("검색할 이름 >> ");
			String name = sc.nextLine();
			boolean isIn = true;
			
			if(name.equals("그만")) {
				break;
			}
			else {
				for (int i = 0; i < a.length; i++) {
					if(name.equals(a[i].name)) {
						System.out.printf("%s의 전화번호는 %s입니다.\n", name, a[i].tel);
						isIn = true;
						break;
					}
					else {
						isIn = false;
					}
				}
				if(!isIn) System.out.printf("%s(은)는 없습니다.\n", name);
			}

		}

	}
}