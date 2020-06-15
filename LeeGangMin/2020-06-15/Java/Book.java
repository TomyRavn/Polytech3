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
	
	//생성자 내에서 또다른 생성자를 호출할 때 this() // 클래스 내부의 다른 생성자 호출
	public Book(String title) {
		this(title, "작자미상");
		//title = t; author = "작자미상";
	}
	
	
//	public Book(String t, String a) {
//		title = t; author = a;
//	}
	public Book(String title, String author) {
		this.title = title; this.author = author;
	}
	
	
	
	public static void main(String[] args) {
//		Book littlePrince = new Book("어린왕자", "생택쥐페리");
//		Book lovestory = new Book("춘향전");
//		Book emptyBook = new Book();
//		
//		System.out.println(littlePrince.title + " " + littlePrince.author);
//		System.out.println(lovestory.title + " " + lovestory.author);
//		emptyBook.show();
//		lovestory.show();
		
		Scanner sc = new Scanner(System.in);
		Book[] bk = new Book[2];
		for (int i = 0; i < bk.length; i++) {
			System.out.printf("%d : 책 제목과 작가를 입력하세요\n", i+1);
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
		
		
		//접근 지정자
		//default : 같은 패키지 내에
		//매개변수 : 메소드가 처리할 입력 데이터
		
		//인자를 전달하는 방식
		//Call by Value
		//Call by Reference
	}
}