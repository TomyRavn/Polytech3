
public class Goods {
	
//	상품 하나를 표현하는 클래스 Goods를 작성하라.
//	
//	상품은 String 타입의 name,
//	int 타입의 price, numberOfStock, sold 등
//	네 개의 필드를 갖는다.
//	
//	Goods 클래스 내에 main() 메소드를 작성하여 Goods 객체를 생성하고 이 객체에 대한 참조 변수 명을 camera로 하라. 
	
	public String name;
	public int price, numberOfStock, sold;
	
	public Goods(String name2, int price2, int n, int sold2) {
		name = name2;
		price = price2;
		numberOfStock = n;
		sold = sold2;
	}

	public Goods() {
	}

//	public static void main(String[] args) {
//		Goods camera = new Goods();
//
//		
//				camera.name = "Nikon";
//				camera.price = 400000;
//				camera.numberOfStock = 50;
//				camera.sold = 30;
//				
//				System.out.println(camera.name + "," + camera.price + "," + camera.numberOfStock + "," + camera.sold);
//	}
//		
		
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

}
