import java.util.Scanner;

public class GoodsArray {
	public static void main(String[] args) {
		Goods[] goodsArray;
		goodsArray = new Goods[3];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < goodsArray.length; i++) {
			System.out.print("��ǰ�� > ");
			String name = sc.next();
			System.out.print("���� > ");
			int price = sc.nextInt();
			System.out.print("��� ���� > ");
			int n = sc.nextInt();
			System.out.print("�Ǹ� ���� > ");
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