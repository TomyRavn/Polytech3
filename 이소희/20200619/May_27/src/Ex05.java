import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		//로또 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 로또 번호 자동 생성");
		System.out.println("2. 로또 번호 입력");
		System.out.println("3. 당첨 확인");
		System.out.println("4. 종료");
		System.out.println("메뉴 선택>>");
		
		int num = sc.nextInt();
		
		
		
		
		int temp = 0;
		
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			
		
		lotto[i]= (int) Math.random() * 45 + 1;
		}
		
		
		for(int i=0; i<9999999; i++){
		            temp = (int)(Math.random() * 45 + 1);}
		            if(lotto.length == 0){
		               int m = temp;
		            }
		            else {
		                int count = 0;
		                for(int j=0; j<lotto.length; j++){
		                
		                    if(lotto[j] == temp){
		                    count = count+1;
		                    }          
		                    }
		                    if (count == 0){
		                   int m = temp;
		            
		                        }
		                        }
		                    if(lotto.length == 6){
		                    break;
		                            }
		                            }
		        System.out.println(lotto);

	}

}
}

