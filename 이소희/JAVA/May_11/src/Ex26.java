
public class Ex26 {

	public static void main(String[] args) {
		int val = 10;
		int nextX;
		
		nextX = ++val;
		System.out.printf("nextX:%d, val:%d\n", nextX , val);
		//전위 증가는 값 출력 전에 미리 값 변화!
		nextX = val++;
		System.out.printf("nextX:%d, val:%d\n", nextX , val);
		//후위 증가는 값 출력 후에 값 변화!
		
		nextX = --val;
		System.out.printf("nextX:%d, val:%d\n", nextX , val);
		//전감
		nextX = val--;
		System.out.printf("nextX:%d, val:%d\n", nextX , val);
		//후감

	}

}
