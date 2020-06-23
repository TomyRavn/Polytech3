package monday;

public class Goods {
	
	//접근 제한자 : default -> 같은 패키지 내의 클래스만 접근 가능
	public String name;
	int price;
	
	public Goods() {
		System.out.println("Goods~~");
	}

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
	
	public String toString() {
		return "제품명 : " + getName();
	}
	
}