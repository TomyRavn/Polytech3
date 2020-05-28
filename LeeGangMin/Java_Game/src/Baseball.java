import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		int randomNumber = 0;
		boolean duplicate = false;
		
		while(true) {
			System.out.println("몇 개의 숫자로 게임할 것인지 선택해주세요(1 ~ 9개)");
			number = sc.nextInt();
			
			if(number >= 1 && number <= 9) break;
			else System.out.println("범위를 벗어난 입력입니다(1 ~ 9개)");
		}
		
		int numberArray[];
		numberArray = new int[number];
		
		//초기화
		for(int i = 0; i < number; i++) {
			duplicate = true;
			//첫째 자리수는 0이 될 수 없다
			if(i == 0) {
				numberArray[i] = (int)(Math.random() * 9 + 1);
			}
			else {
				while(duplicate) {
					randomNumber = (int)(Math.random() * 9);
					duplicate = false;
					
					for(int j = 0; j < i; j++) {
						if(numberArray[j] == randomNumber) {	//앞에 들어간 수와 중첩되면
							duplicate = true;
							break;								//for문만 빠져나옴
						}
					}
				} //이 때 randomNumber는 중첩되지 않는 수
				numberArray[i] = randomNumber;	//그러므로 저장
			}
		}
		
		
		//유저 처리 부분
		int[] tempArray;					//분해를 위해서 임시 저장 배열
		int[] userNumArray;					//분해된 배열
		tempArray = new int [number];
		userNumArray = new int [number];
		
		//시도한 횟수
		int gameCount = 0;
		
		//유저가 입력한 자릿수를 입력받으므로, 10^n을 구해준다
		int multiply = 1;
		for(int i = 1; i < number; i++) {
			multiply *= 10;
		}
		
		//게임 시작
		while(true)
		{
			int strikeCount = 0;			//스트라이크 횟수 0으로 초기화
			int ballCount = 0;				//볼 횟수 0으로 초기화
			int multiplyTemp = multiply;	//10^n으로 초기화
			boolean empty = true;
			
			gameCount++;					//반복문이 돌아올때마다 도전 횟수 증가
			
			//사용자 입력
			System.out.printf("-------- %d회 째 --------\n", gameCount);
			System.out.printf("숫자를 입력하세요 > ");
			int userNum = sc.nextInt();
			
			//유저가 입력한 숫자를 배열에 하나씩 분해하여 저장
			for(int i = 0; i < number; i++) {
				userNumArray[i] = userNum / multiplyTemp;					//첫자리 수를 분해하여 저장
				tempArray[i] = userNum - (userNumArray[i] * multiplyTemp);	//첫자리 수를 뺀 나머지값을 뺀 값 저장(예: 98710 - 9 * 10000)
				userNum = tempArray[i];		//나머지값을 userNum에 저장하여 다시 반복문 계산
				multiplyTemp /= 10;			//10^n에서 자릿수를 감소하여 사용(이 때, 재시도를 위해 다시 구해준 multiply로 반복문 시작시 초기화)
			}
		
			//스트라이크, 볼 카운트 증가 처리
			for(int i = 0; i < number; i++) {
				if(userNumArray[i] == numberArray[i]) strikeCount++;		//입력된 자릿수와 똑같은 수일 때 스트라이크 횟수 증가
			
				for(int j = 0 ; j < number ; j ++)
				{
					if(i != j) {
						if(userNumArray[i] == numberArray[j]) ballCount++;	//자릿수는 다른데 똑같은 수가 있을 시 볼 횟수 증가
					}
				}
			}
		
			//출력용
//			for(int i = 0; i < number; i++){
//				System.out.printf("%d 번째 수 : %d\n", i+1, numberArray[i]);
//				System.out.printf("입력된 %d 번째 수 : %d\n", i+1, userNumArray[i]);
//			}
			
			//결과 출력
			System.out.printf("%d 스트라이크\t %d 볼\n", strikeCount, ballCount);
			//이기는 조건(반복문 빠져나옴)
			if(strikeCount == number) {
				System.out.printf("%d번 만에 정답을 맞추셨습니다.", gameCount);
				break;
			}
		}
	}
}