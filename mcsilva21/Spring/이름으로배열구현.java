import java.util.Scanner;

public class 이름으로배열구현 {

	public static void main(String[] args) {			
		Scanner s = new Scanner(System.in);	
		String[] str = new String [5];
		
		String longStr = "";
		
		for (int i = 0; i < str.length; i++) {
			str[i] = s.nextLine();											
		}		
			for (String ok:str)	{
				longStr += ok;
			}
			System.out.printf("연결 문장:%s\n",longStr);
		}		
	}

	


