package may_27;

public class Test02 {
	public static void main(String[] args) {
		int[] numArray = new int[5];
		
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = (int)(Math.random() * 9 + 1);
		}
		
		int min = numArray[0];
		int index = 0;
		int temp = 0;
		
		//////////////////정렬 이전 출력///////////////////
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i]);
		}
		System.out.println();
		/////////////////////////////////////////////
		
		for(int i = 0; i < numArray.length; i++) {
			index = i;
			min = numArray[i];
			
			for(int j = i + 1; j < numArray.length; j++) {
				if(numArray[j] < min) {
					index = j;
					min = numArray[j];
				}
			}
			
			temp = numArray[i];
			numArray[i] = numArray[index];
			numArray[index] = temp;
		}
		
		//////////////////정렬 이후 출력///////////////////
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i]);
		}
		/////////////////////////////////////////////
	}
}