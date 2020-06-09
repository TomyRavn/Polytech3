import java.util.Scanner;

public class GoodsArray {
	public static void main(String[] args) {
		Goods[] goodsArray;
		goodsArray = new Goods[3];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < goodsArray.length; i++) {
			System.out.print("상품명 > ");
			String name = sc.next();
			System.out.print("가격 > ");
			int price = sc.nextInt();
			System.out.print("재고 수량 > ");
			int n = sc.nextInt();
			System.out.print("판매 수량 > ");
			int sold = sc.nextInt();
			goodsArray[i] = new Goods(name, price, n, sold);
		}
		
		for (int i = 0; i < goodsArray.length; i++) {
			System.out.print(goodsArray[i].getName() + " ");
			System.out.print(goodsArray[i].getPrice() + " ");
			System.out.print(goodsArray[i].getNumberOfStock() + " ");
			System.out.println(goodsArray[i].getSold());
		}
	}
}