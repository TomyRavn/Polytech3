package kr.ac.kopo.exapp;

import java.util.ArrayList;

public class ExObject {
	
	public static void main(String[] args) {
		//ExList 클래의 내용을 참고하여 다음과 같은 기능을 수행하는 프로그램을 작성
		//1.음식이름을 저장할 수 있는 목록을 생성
		ArrayList<String> list = new ArrayList<String>();
		//2.좋아하는 음식이름 3개를 저장
		list.add("피자");
		list.add("치킨");
		list.add("햄버거");		
		//3.저장한 음식 이름를 순서대로 출력		
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
				
//		ArrayList<String> namelist = new ArrayList<String>();
//		ArrayList<Integer> pricelist = new ArrayList<Integer>(); 항목이 많으면 불편.->calss 사용
		ArrayList<Food> foodList = new ArrayList<Food>();
		//이름은 "피자", 가격은 "10,000원"인 음식을 추가
		Food f1 = new Food(); //저장할 공간을 선언 :Food(클래스) 사용하려면 new 변수로 저장해야함.
		//방금만든Food객체의name변수에"피자"를 저장
		f1.setName("피자"); //f1.name="피자";
		f1.setPrice(10000);	//f1.price = 1000;
		//방금만든Food객체의price변수에"10,000원"를 저장
		foodList.add(f1);
		//이름은 "스파게티", 가격은 "5,000원"인 음식을 추가
		Food f2 = new Food();
		f2.setName("스파게티");
		f2.setPrice(10000);
		foodList.add(f2);
		//이름은 "햅버거", 가격은 "2,000원"인 음식을 추가
		Food f3 = new Food();
		f3.setName("햄버거");
		f3.setPrice(2000);
		foodList.add(f3);		
		//3.저장한 음식 이름를 순서대로 출력
		for (int i = 0; i < foodList.size(); i++) {
			Food f = foodList.get(i);
			System.out.println(f.getName()+","+f.getPrice());	
		}
		//food클래스의 값을 주면안됨.foodList.get(0)=new Food();이므로f1은 공간을 부르는거임 .name을 주어 값을 불러와야함
		//System.out.println(foodList.get(i).name+","+foodList.get(i).price);
		//foodList.get(f1)을 Food f1으로 선언했기 때문에 변수를 Food타입으로 줘야함. 
		//한 회원의 아아디,이름,포인트를 저장할 수 있는 Member라는 데이터타입(클래스)를 정의
		//여러명의 회원 정보를 저장할 수 있는 목록을 생성
		//아아디"a001",이름"고길동",포인트100인 회원 정보를 목록에 저장
		//아아디"a002",이름"마이콜",포인트200인 회원 정보를 목록에 저장
		//아아디"a003",이름"도우너",포인트300인 회원 정보를 목록에 저장
		//회원목록에 저자된 전체 회원의 아이디,이름,포인트를 출력						
	}
	}


