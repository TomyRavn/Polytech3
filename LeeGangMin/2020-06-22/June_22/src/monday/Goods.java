package monday;

public class Goods {
	
	//���� ������ : default -> ���� ��Ű�� ���� Ŭ������ ���� ����
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
		return "��ǰ�� : " + getName();
	}
	
}