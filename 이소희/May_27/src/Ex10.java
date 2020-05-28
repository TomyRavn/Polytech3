
public class Ex10 {

	public static void main(String[] args) {
		//10개의 원소로 구성된 정수형 1차원 배열 a를 선언하고, 
		//난수 함수를 이용하여, 0~9사이의 임의의 수가 발생되도록 100번 시험하여, 
		//각 숫자들의 발생 빈도수를 구하여 가장 발생 빈도가 큰 값(최빈값)의 번호를 구하여 출력하시오.
		
		int[] freq = new int[10];
		
		
		for(int i=0; i<100; i++) {
			freq[(int)(Math.random()*10)]++;

		}
		int m = 0;
		
		for(int i =1; i<freq.length; i++) {
			if(freq[i] > freq[m])
				m = i;
		}	
		
		for(int i = 0; i<freq.length; i++) {
		System.out.printf("%d:%4d회\n",i,freq[i]);		
		}
			
		System.out.printf("\n최빈값:%d, 최빈값의 빈도수:%d\n", m , freq[m]);
		}
			
			
	}

