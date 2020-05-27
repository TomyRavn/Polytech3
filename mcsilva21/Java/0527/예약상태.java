import java.util.Scanner;

public class 예약상태 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		int[] arr = new int[10];
		int temp;

		while(true) {
			System.out.printf("\t현재의 예약 상태");
			System.out.println();
			prn(arr);
			
			System.out.println();
			System.out.printf("좌석선택(1~10):");
			int n =s.nextInt();	

			if(arr[n-1] ==0) {
				arr[n-1] = 1;
				System.out.printf("예약되었습니다.");
				System.out.println();
			}else {
				System.out.printf("이미예약되었습니다.");
				continue;
			}
			
			prn(arr);
			
		
			s.nextLine();
			System.out.print("\n계속 하시겠습니까(y/n)? ");
			char ans =  s.nextLine().charAt(0);

			if(ans == 'n')
				break;

		}

	}

	public static void prn(int[] a) {
		System.out.println("--------------------------");

		for (int i=1; i<=a.length; i++) {
			System.out.printf(i+" ");			
		}
		System.out.println();
		System.out.println("--------------------------");

		for (int i=0; i<a.length; i++) {	
			System.out.print(a[i]+" ");	
		} 	

	}	
}

