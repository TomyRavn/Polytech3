package may_27;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] lottoNumArray = new int[6];	//로또 번호 담을 배열
		int[] userNumArray = new int[6];	//유저가 뽑는 숫자를 담을 배열
		int[] sameNumArray = new int[6];	//일치하는 숫자를 담고 출력할 배열
		
		boolean flag = true;				//무한 반복 종료를 위한 논리 변수
		boolean isShuffle = false;			//생성 1회를 했는지 확인하기 위한 논리 변수
		
		//초기값을 100으로 설정하여 생성 받지 않았을 때 초기 값이 동일하여 일치하는 숫자가 생기지 않게 함
		for(int i = 0; i < lottoNumArray.length; i++) {
			lottoNumArray[i] = 100;
		}
		
		
		//무한 반복
		while(flag) {
			
			int count = 0;						//일치할 시 증가하는 카운트 변수(일치할 때 값이 증가)
			
			System.out.println("\t     [[메뉴 선택]]");
			System.out.println("1.로또번호 생성  2.로또번호 입력  3.당첨 확인  4.종료");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				//1. 로또번호 자동 생성 && 중복 방지
				chooseNumberNoDuplicate(lottoNumArray, 45);
				//생성 1회를 했는지 확인
				isShuffle = true;
				//컴퓨터가 뽑은 숫자 출력
				System.out.print("컴퓨터가 뽑은 숫자: ");
				printArray(lottoNumArray);
				System.out.println("-------------------------------------");
				break;
				
			case 2:
				if(isShuffle) {
					//2. 사용자가 로또번호 입력
					for(int i = 0; i < userNumArray.length; i++) {
						//사용자 입력
						System.out.printf("당첨 확인하실 로또 번호 중 %d번째 숫자를 입력하세요(1~45) > ", i+1);
						userNumArray[i] = sc.nextInt();

						//1~45까지 범위의 숫자가 아닐 시 재입력
						if(userNumArray[i]<1 || userNumArray[i]>45) {
							System.out.println("잘못된 입력, 1 ~ 45사이 숫자만 입력하세요");
							i--;
							continue;
						}
					}
				}
				else System.out.println("로또 번호가 생성되지 않았습니다.");
				break;
				
			case 3:
				if(isShuffle) {
					//3. 당첨확인
					count = resultCountInTwoOutCountAndOne(lottoNumArray, userNumArray, sameNumArray);

					//결과 출력
					System.out.println("=================================");
					System.out.printf("로또 숫자 일치하는 갯수 : %d", count);
					System.out.printf("\n일치하는 숫자 : ");

					//정렬
					selectionSortArray(sameNumArray);
					//정렬된 후 입력한 숫자와 일치하는 로또 번호 출력
					for (int i = 0; i < sameNumArray.length; i++) {
						if(sameNumArray[i] != 0) {
							System.out.printf("%-3d", sameNumArray[i]);	
						}
					}
					System.out.println();
				}
				else System.out.println("로또 번호가 생성되지 않았습니다.");

				break;
				
			case 4:
				//4. 종료
				System.out.println("프로그램 종료");
				flag = false;
				break;
				
			default:
				System.out.println("다른 값을 입력하였습니다. 다시 선택해주세요");
				break;
			}
		}
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	//배열에 담긴 숫자를 출력할 함수
	public static void printArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%-3d", x[i]);	
		}
		System.out.println();
	}
	
	//번호를 중복 없이 1~max까지 뽑아줄 함수
	public static void chooseNumberNoDuplicate(int[] x, int max) {
		int temp = 0;						//로또 번호 임시로 담을 변수
		
		for (int i = 0; i < x.length; i++) {

			boolean duplicate = true;		//로또 번호 중복 뽑는 것을 방지할 논리 변수(초기값을 true로 설정)

			while(duplicate) {

				temp = (int)(Math.random() * max + 1);	//로또 번호를 임시로 뽑고
				duplicate = false;						//중복이 안되면 while문을 빠져 나옴

				for (int j = 0; j < x.length; j++) {
					//중복이 되면 duplicate 변수가 true로 설정되어 계속 while문을 돌게 됨
					if(temp == x[j]) {
						duplicate = true;
						break;				//일치할 시 더 이상 검사를 반복할 필요가 없으므로 숫자를 다시 뽑는 while문으로 바로 돌아감
					}
				}

			}
			x[i] = temp;		//일치하지 않는 경우에만 while문을 빠져나오므로 이때 temp에 저장된 수를 배열에 저장
		}
		
	}
	
	//배열 3개를 입력받아서 x, y배열은 입력받고,
	//z배열은 일치하는 숫자를 저장하는 배열을 저장
	//그리고 일치하는 횟수를 저장한 count 변수를 반환해주는 함수
	public static int resultCountInTwoOutCountAndOne(int[] x, int[] y, int[] z) {
		int count = 0;
		
		for(int i = 0; i < x.length; i++) {
			
			for(int j = 0; j < y.length; j++) {
				
				//사용자가 뽑은 숫자의 배열과 컴퓨터가 랜덤으로 뽑은 숫자를 비교해서 같을 시 카운트 증가
				//그리고 일치하는 숫자를 sameNumArray배열에 담아줌
				if(y[j] == x[i]) {
					count++;
					z[i] = y[j];
				}
				
			}
		}
		return count;
	}
	
	//배열을 입력받아 선택 정렬해주는 함수
	public static void selectionSortArray(int[] x) {
		int temp = 0;	//선택 정렬을 위한 임시 값 담을 변수
		int index = 0;	//선택 정렬을 위한 인덱스 변수
		int min = 0;	//선택 정렬을 위한 최소값 변수
		
		for (int i = 0; i < x.length; i++) {
			//선택 정렬
			for(int j = 0; j < x.length; j++) {
				
				index = j;				//검사할 인덱스 값 초기화
				min = x[j];	//검사할 최소값 초기화
				
				for(int k = j + 1; k < x.length; k++) {
					//최소값보다 현재 검사하는 값이 작을 시 인덱스와 최소값을 저장
					if(x[k] < min) {
						index = k;
						min = x[k];
					}
				}
				//검사한 후 최소값을 맨앞 인덱스로 당겨옴(그리고 이후 for문을 다시 돌때는 다음 인덱스가 최소값으로 설정됨)
				temp = x[j];
				x[j] = x[index];
				x[index] = temp;
			}
		}
	}
	
}