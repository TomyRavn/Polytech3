import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i <=5; i ++) {
			//0�̻� 1�̸��� �������� ���� ������ �߻���Ŵ (= Math.random()) 
			System.out.println(Math.random());	//Math.random()�� ���ϴ� �� - 1�� ������ ����
												//Math.random()*n + 1�� ������ �ּ� ������ 1��ŭ ����
		}
	}
}