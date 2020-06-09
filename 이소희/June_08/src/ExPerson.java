
public class ExPerson {

	public static void main(String[] args) {
		//객체 배열 생성 및 사용
		
		Person[] pa;
		pa = new Person[10];
		for (int i = 0; i < pa.length; i++) {
			pa[i] = new Person();
			pa[i].age = 30 + i;
			
		}
		
		for (int i = 0; i < pa.length; i++) {
			System.out.println(pa[i].age + "");
			
		}
	}
}
