public class Omok {
	public static void main(String[] args) {
		
		String[][] Omokpan = new String [19][19];
		
		for (int i = 0; i < Omokpan.length; i++) {
			for (int j = 0; j < Omokpan[i].length; j++) {
				if(i == 0) System.out.print("¦¨");
				else if(i == Omokpan.length-1) System.out.print("¦ª");
				else System.out.print("¦«");
			}
			System.out.println();
		}
	}
}