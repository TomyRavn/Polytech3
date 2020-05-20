import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("키를 입력하세요");
		int H = scan.nextInt();
		System.out.println("몸무게 입력하세요");
		int W = scan.nextInt();
		
		double result = (H-100)*0.9;
		double result2 = W - result;
		
		System.out.println("표준체중:"+result+"kg");
		
		if(result>W) {
			   System.out.println("체중차이:"+result2+"kg");
			   System.out.println("저체중입니다.");
		
		} else if(W >= result - 5 && W >= result + 5) {
			   System.out.println("표준입니다.");	
		}
		  else System.out.println("체중차이:"+result2+"kg");{
			   System.out.println("비만입니다.");
		  }
			  
		}
		
				
	}



