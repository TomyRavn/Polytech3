public class Goods {
	String name;
	int price;
	int numberOfStock;
	int sold;
	
	public Goods() {
		
	}
	
	public Goods(String n, int p, int num, int s) {
		name = n;
		price = p;
		numberOfStock = num;
		sold = s;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getNumberOfStock() {
		return numberOfStock;
	}

	public int getSold() {
		return sold;
	}
	
	public static void main(String[] args) {
		//1.
//		Goods camera = new Goods();
//		camera.name = "Nikon";
//		camera.price = 400000;
//		camera.numberOfStock = 30;
//		camera.sold = 50;
//		System.out.printf("상품 이름 : %s\n상품 가격 : %d\n재고 수량 : %d\n팔린 수량 : %d\n", camera.name, camera.price, camera.numberOfStock, camera.sold);
		
		//2.
		Goods camera = new Goods("Nikon", 400000, 30, 50);
		System.out.printf("상품 이름 : %s\n상품 가격 : %d\n재고 수량 : %d\n팔린 수량 : %d\n", camera.name, camera.price, camera.numberOfStock, camera.sold);
	}
}