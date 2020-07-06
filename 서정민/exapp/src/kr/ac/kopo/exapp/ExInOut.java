package kr.ac.kopo.exapp; //ctrl + 1 ,, 패키지는 클래스 파일이 저장되는 폴더
import java.util.Scanner;

//자바 프로그램은 클래스 단위로 작성하고 실행
public class ExInOut {
	//클래스를 실행(한다는 의미) == 클래스 내부의 main 메소드에 정의된 명령문들을 순서대로 실행
	//실행하면 Hello Java 출력하는 프로그램을 작성하세요
	public static void main(String[] args) {
		//Scanner : 현재 시스템의 표준입력(키보드)으로부터 읽어내서 기능 제공
		//표준입력으로부터 데이터를 읽을 수 있는 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		//방금 위에서 만든 스캐너의 메서드를 실행 sc.~~~
		//엔터키를 입력할 때까지 입력한 문자열을 가져오기 sc.~~~
		
        //System.out.println(line);
		
		//이름을 입력하세요 라고 출력하고,
		//이름을 입력받고, "Hello, 입력한 이름"을 출력하는 프로그램을 작성하세요
		System.out.print("이름을 입력하세요 > ");
		String line = sc.nextLine();
		System.out.println("Hello, " + line);
	}
}