
public class Ex02 {

	private static int result;

	public static void main(String[] args) {
		int v1 = 15;
		if(v1>10) {
			int v2;
			v2 = v1 - 10;
		}

		int v2 = v1 - 10;
		int v3 = v1 + v2 + 5;
		result = v3;
		System.out.println(result);
	}

}
