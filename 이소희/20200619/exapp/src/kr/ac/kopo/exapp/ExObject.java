package kr.ac.kopo.exapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ExObject {


public static void main(String[] args) {
	//ExList 클래스의 내용을 참고하여 다음과 같은 기능을 수행하는 프로그램을 작성
	
	
	
	
	
		//1. 음식 이름을 저장할 수 있는 목록을 생성
		ArrayList<String> list = new ArrayList<String>();
		
		//2. 좋아하는 음식 이름 3개를 목록에 저장
		list.add(" 피자 "); 
		list.add(" 초밥 "); 
		list.add(" 커피 "); 
		
		//3. 저장한 음식 이름을 순서대로 출력
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		//4. 음식의 이름과 가격을 함께 저장하려면 어떻게 해야할지를 고민
		ArrayList<Food> foodList = new ArrayList<Food>();
		Food f1 = new Food();	
		//방금 만든 food 객체의 name 변수에 "피자"를 저장
		//방금 만든 food 객체의 price 변수에 "10000"를 저장
		f1.setName("피자");
		f1.setPrice(10000);
		foodList.add(f1);
		
		
		//이름은 "스파게티", 가격은 "5000" 원 인 음식을 추가
		//이름은 "햄버거", 가격은 "2000" 원 인 음식을 추가
		//저장한 음식 이름과 가격을 순서대로 출력
		Food f2 = new Food();
		f2.setName("스파게티");
		f2.setPrice(5000);
		foodList.add(f2);
		
		
		Food f3 = new Food();
		f3.setName("햄버거");
		f3.setPrice(2000);
		foodList.add(f3);
		
		
		
		//f1 은 foodList.get(0)과 동일하다
		for (int i = 0; i < foodList.size(); i++) {
			Food f = foodList.get(i);
			System.out.println(f.getName() + "," + f.getPrice());
			
		}
		
		
		
		
		//회원의 아이디, 이름, 포인트를 저장할 수 있는 Member 라는 데이터 타입(클래스)를 정의
		//여러 명의 회원 정보를 저장할 수 있는 목록을 생성
		//아이디 "a001", 이름 "고길동" , 포인트 100인 회원 정보를 목록에 저장  
		//아이디 "a002", 이름 "마이클" , 포인트 200인 회원 정보를 목록에 저장  
		//아이디 "a003", 이름 "도우너" , 포인트 300인 회원 정보를 목록에 저장
		//회원 몰록에 저장된 전체 회원의 아이디, 이름, 포인트를 출력
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member a1 = new Member();
		a1.setId("a001");
		a1.setName("고길동");
		a1.setPoint(100);
		memberList.add(a1);
		
		Member a2 = new Member();
		a2.setId("a002");
		a2.setName("마이클");
		a2.setPoint(200);
		memberList.add(a2);
		
		Member a3 = new Member();
		a3.setId("a003");
		a3.setName("고길동");
		a3.setPoint(300);
		memberList.add(a3);
		
		for (int j = 0; j < memberList.size(); j++) {		
		Member a = memberList.get(j);
		System.out.println(a.getId() + " ," + a.getName() + " ," + a.getPoint());
		}
}
}
