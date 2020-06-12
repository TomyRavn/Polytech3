package kr.ac.kopo.exapp;

//Food라는 타입을 만듬
public class Food {
	//setura? petura 방식?
	
	//접근 제한자 private 사용시 해당클래스내에서만 private 붙은 변수 사용가능
	//예 ) private String name;
	
	private String name;
	private int price;
	
	//1. 자동 생성 : 우클릭 > source > generate getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//2. 변수에 대한 직접 접근은 막고, 값은 세팅할 수 있게 함
//	public void setName(String n) {
//		//this.name = n;
//		name = n;
//	}
//	
//	public void setPrice(int p) {
//		price = p;
//	}
//	
//	
//	public String getName() {
//		return name;
//	}
//	
//	public int getPrice() {
//		return price;
//	}
	
	
}