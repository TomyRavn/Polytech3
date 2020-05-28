import java.util.Scanner;

public class Ex06 {
	
	//난수 랜덤을 통해서 발생하는 값은  0<=Math.random()<1 double을 출력한다. 0.5486318	
	//for(int i=1; i<=3; i++)
		//System.out.println((int)(Math.random()*3)+1); //최소값 :0 최대값:2 이므로 +1을 해야 1~3을 출력

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("1:가위 2:바위 3:보를 입력하세요");
		
		int put = sc.nextInt();
			//System.out.println("당신이 입력한 값은:"+ put);//
			if(put==1)
			System.out.println("가위");
			if(put==2)
			System.out.println("바위");
			if(put==3)
			System.out.println("보");
			
			int num = ((int)(Math.random()*3)+1);
			System.out.println("컴퓨터는"+num+"을 냈습니다.");							
					
		switch(num) {
			case 1:
				System.out.println("가위"); break;
			case 2:
				System.out.println("바위"); break;
			default:
				System.out.println("보"); break;
		
		}
			
				if(put == num) System.out.println("무승부입니다.");		
				if(put==1 && num==2) System.out.println("컴퓨터가 이겼습니다.");
				if(put==1 && num==3) System.out.println("당신이 이겼습니다.");
				if(put==2 && num==1) System.out.println("당신이 이겼습니다.");
				if(put==2 && num==3) System.out.println("컴퓨터가 이겼습니다.");
				if(put==3 && num==1) System.out.println("컴퓨터가 이겼습니다.");
				if(put==3 && num==2) System.out.println("당신이 이겼습니다.")	;		
				
			
	}

}
