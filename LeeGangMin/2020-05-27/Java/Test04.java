package may_27;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seatArray = new int[10];	//좌석 저장할 배열
		boolean flag = true;			//while문 종료를 위한 논리함수
		
		//모든 좌석 0으로 초기화(예약 가능 상태)
		for (int i = 0; i < seatArray.length; i++) {
			seatArray[i] = 0;
		}
		
		//무한반복
		while(flag) {
			
			printList(seatArray);	//출력용 함수
			
			//사용자 입력
			System.out.print("\n좌석 선택(1~10) :");
			//입력은 1~10부터 이루어지므로 -1을 하여 인덱스값을 낮춰 저장
			int seat = sc.nextInt() - 1;
			
			if(seatArray[seat] == 0) {
				seatArray[seat] = 1;
				System.out.println("예약되었습니다.");
			}
			else {
				System.out.println("이미 예약된 좌석, 예약 불가");
				continue;			//다시 예약화면 출력
			}
			
			printList(seatArray);	//출력용 함수
			
			
			//Y,y,N,n 입력이 아닐 시 반복해서 입력받음
			boolean wrongInput = true;
			sc.nextLine();	//앞에서  int형으로 받았기 때문에 한줄 건너뜀
			
			while(wrongInput) {
				System.out.println("계속하시겠습니까?(y/n)?");	
				String input = sc.nextLine();
				wrongInput = false;
				
				switch(input) { 
				case "Y": case "y":
					flag = true;
					break;
				case "N": case "n":
					flag = false;
					break;
				default: wrongInput = true;
					System.out.println("잘못된 입력입니다.");
					break;
				}
			}
		}
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////
	//출력 함수
	public static void printList(int[] x) {
		System.out.println("\t\t현재의 예약 상태");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%4d", i+1);
		}
		System.out.println();
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%4d", x[i]);	
		}
		System.out.println();
		System.out.println("--------------------------------------------");
	}
}