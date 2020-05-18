import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {		
//		int i = 1;
//		int sum = 0;			
//		while (i <=9) {
//			System.out.printf(" %d x %d = %d\n", 7,i,7*i);
//			i++;	
//		int sum=0;
//		int x = 1; 	
//		while(x<=10) {
//			sum = sum + x; // sun += x;
//			x++;
//		}
//			System.out.printf("전체합:%d\n",sum);
				
//	while(true) {
//		System.out.println("Hello~");
//		
//		if(i>=5)
//			break;
//		i++;	
		//철학 중간점수 10개를 입력받고  학생의 인원수는 정해져 있지 않다.
		// 전체 합를 출력하여라
	//음수를 이용해서 루프를 빠져놔아라.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		
		int sum = 0;
		int x = 1;
		int score;
		
		while(true) { 
			System.out.printf("%d번 학생수 (나가기(음수입력)):",x);
			score = sc.nextInt();
			
			if(score<0) 
				break;
		
			sum += score;
			x++;		
		}
		
		double avg = (double)sum/x;	
		System.out.printf("철학과목 전체 평균점수:%.2f\n",avg);	
		
		}	
		
	}




