import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("Ű�� �Է��ϼ���");
		int H = scan.nextInt();
		System.out.println("������ �Է��ϼ���");
		int W = scan.nextInt();
		
		double result = (H-100)*0.9;
		double result2 = W - result;
		
		System.out.println("ǥ��ü��:"+result+"kg");
		
		if(result>W) {
			   System.out.println("ü������:"+result2+"kg");
			   System.out.println("��ü���Դϴ�.");
		
		} else if(W >= result - 5 && W >= result + 5) {
			   System.out.println("ǥ���Դϴ�.");	
		}
		  else System.out.println("ü������:"+result2+"kg");{
			   System.out.println("���Դϴ�.");
		  }
			  
		}
		
				
	}



