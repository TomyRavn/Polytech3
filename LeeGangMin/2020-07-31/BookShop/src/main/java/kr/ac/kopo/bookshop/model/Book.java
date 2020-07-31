package kr.ac.kopo.bookshop.model;

public class Book {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	//myBatis에서는 resultType을 Book으로 값을 주었다면, 해당 객체를 생성하고 받아서 처리해주는데,
	//이 때 myBatis는 setter,getter가 있다는 것을 가정하기 때문에
	//myBatis의 도움을 받기 위해서는 setter, getter 메소드가 필요함
	
//	input 태그의 name
//	java 필드명(camelCase)
//	database의 컬럼명('_'로 표기, 대/소문자 구별을 하지 않기 때문에 )
//	복합어를 쓰는 방식이 다름
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}