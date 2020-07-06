package kr.ac.kopo.exapp;

public class Food {
		
	private String name;
	private int price;
	
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
	
	
	
	
//	public void setName(String n) {
//		this.name = n;					
//}
//	public void setPrice(int p) {
//		this.price = p;
//}
//	public String  getName() {
//	return this.name;
//		
//	}
//	public int  getPrice() {
//	return this.price;		
//	}
}
//C,파이썬은 그대로 사용
//java는 외부에서 접근하지 못하도록 private 선언해주고