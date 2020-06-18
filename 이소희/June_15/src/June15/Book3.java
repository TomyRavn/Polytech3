package June15;

import java.util.Scanner;

public class Book3 {
	String title;
	String author;

	void show() {
		System.out.println(title + " " + author);
	}

	public Book3() { // 생성자
		this("", "");
		System.out.println("생성자 호출됨");
	}

	public Book3(String title) {
		this(title, "작자미상");
	}

	public Book3(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book3[] ok = new Book3[2];

		for (int i = 0; i < ok.length; i++) {
			System.out.print("작가명을 입력하세요.");
			String name = sc.next();
			System.out.print("책 제목을 입력하세요.");
			String title = sc.next();

			ok[i] = new Book3(title, name);

		}
		for (int i = 0; i < ok.length; i++) {
			ok[i].show();

		}

	}

}
