import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		//좌석 예약 시스템 10개의 좌석 예약하기
		//좌석이 있는 경우 이미 선택한 좌석입니다 라고 출력 후 좌석 선택 반복
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
		
		System.out.println("현재 예약 상태");
		System.out.println("----------------------------");
			for(int i=0; i<10; i++) 
	        System.out.print(i+1 + "  ");
		 System.out.println();
		 System.out.println("----------------------------");

			for (int i = 0; i<arr.length; i++) {
					System.out.print(arr[i]+"  ");
					System.out.println();}
			
		System.out.println("----------------------------");		
		
		System.out.println("좌석을 선택하세요.(1~10)>>");	
		int num = sc.nextInt();
		System.out.printf("좌석 선택(1~10): %d" , num);
		System.out.println();
		
				
		
			if (arr[num-1] == 0) {
				arr[num-1] = 1;
				System.out.println("예약이 완료 되었습니다.");
				System.out.println("현재 예약 상태");
				System.out.println("-----------------------");
				
			}	else {
					System.out.println("이미 예약되었습니다.");
					continue;
				}
			
						System.out.println("-----------------------");

						
						for (int i = 0; i<arr.length; i++) {
							System.out.printf("%4d", i+1);
							}
						
						sc.nextLine();
						char a = sc.nextLine().charAt(0);
						
							for(int i = j; i<=j; j++) 
								arr[num-1] = 1;
								System.out.print(arr[j]+" ");
								System.out.println();
								System.out.println("-----------------------");
								}	


			if (arr[num-1] == 1) {
				System.out.println("이미 예약된 좌석입니다.");
				
			
				}
		
			}
		
			}
			
	

	








	





