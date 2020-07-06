package 연습문제;

public class 기초문제_소수 {

	public static void main(String[] args) {

		int count = 0;

		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= i; j++) {

				if (i % j == 0) { // 소수는 1과 자기자신으로만 나눠지므로 자기자신으로 한번만 나눠질때 소수
					count++;
				}
			}

			if (count == 1) {
				System.out.println(i);
			}
			count = 0;
		}
	}

}
