import java.util.Scanner;

public class Book {
	String title;
	String author;

	void show() {
		System.out.println(title + " " + author);
	}
	public Book() {
		    this("", "");
		     System.out.println("생성자 호출됨");
		   }

	public Book(String title) {
		     this(title, "작자미상");
		   }

	public Book(String title, String author) {
		      this.title = title;
		      this.author = author;
		   }

	public static void main(String[] args) {
		
		  Book littleprince = new Book("어린왕자", "생텍쥐페리");
	      Book loveStory = new Book("춘향전");
	      Book emptyBook = new Book();
	      loveStory.show();

		Scanner s = new Scanner(System.in);
			Book[] c = new Book[2];

		for (int i = 0; i < c.length; i++) {
			System.out.print("작가명:");
			String name = s.nextLine();
			System.out.print("책 제목:");
			String title = s.nextLine();
			c[i] = new Book(title,name);						
		}
		for (int i = 0; i < c.length; i++) {
			c[i].show();
		}
	}

}
