import java.util.Scanner;

public class Book {
	String title;
	String author;
	
	void show() {
		System.out.println(title + " " + author);
	}
	
	public Book() {
		this("", "");
		System.out.println("������ ȣ���");
	}
	
	//������ ������ �Ǵٸ� �����ڸ� ȣ���� �� this() // Ŭ���� ������ �ٸ� ������ ȣ��
	public Book(String title) {
		this(title, "���ڹ̻�");
		//title = t; author = "���ڹ̻�";
	}
	
	
//	public Book(String t, String a) {
//		title = t; author = a;
//	}
	public Book(String title, String author) {
		this.title = title; this.author = author;
	}
	
	
	
	public static void main(String[] args) {
//		Book littlePrince = new Book("�����", "�������丮");
//		Book lovestory = new Book("������");
//		Book emptyBook = new Book();
//		
//		System.out.println(littlePrince.title + " " + littlePrince.author);
//		System.out.println(lovestory.title + " " + lovestory.author);
//		emptyBook.show();
//		lovestory.show();
		
		Scanner sc = new Scanner(System.in);
		Book[] bk = new Book[2];
		for (int i = 0; i < bk.length; i++) {
			System.out.printf("%d : å ����� �۰��� �Է��ϼ���\n", i+1);
			String tit = sc.nextLine();
			String aut = sc.nextLine();
			
			if(aut.equals("")) {
				bk[i] = new Book(tit);
			}
			else {
				bk[i] = new Book(tit, aut);
			}
			
		}
		
		for (int i = 0; i < bk.length; i++) {
			bk[i].show();
		}
		
		
		//���� ������
		//default : ���� ��Ű�� ����
		//�Ű����� : �޼ҵ尡 ó���� �Է� ������
		
		//���ڸ� �����ϴ� ���
		//Call by Value
		//Call by Reference
	}
}