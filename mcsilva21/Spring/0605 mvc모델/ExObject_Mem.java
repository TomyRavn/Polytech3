package kr.ac.kopo.exapp;

import java.util.ArrayList;

public class ExObject_Mem {
	
	public static void main(String[] args) {
		
		//한 회원의 아아디,이름,포인트를 저장할 수 있는 Member라는 데이터타입(클래스)를 정의
				//여러명의 회원 정보를 저장할 수 있는 목록을 생성
				//아아디"a001",이름"고길동",포인트100인 회원 정보를 목록에 저장
				//아아디"a002",이름"마이콜",포인트200인 회원 정보를 목록에 저장
				//아아디"a003",이름"도우너",포인트300인 회원 정보를 목록에 저장
				//회원목록에 저장된 전체 회원의 아이디,이름,포인트를 출력	
		
		
		//여러명의 회원 정보를 저장할 수 있는 목록을 생성
		ArrayList<Member> MemberList = new ArrayList<Member>();
	
		//아아디"a001",이름"고길동",포인트100인 회원 정보를 목록에 저장
		Member m1 = new Member(); 		
		m1.setId("a001");
		m1.setName("고길동");
		m1.setPoint(100);
		MemberList.add(m1);
		
		//아아디"a002",이름"마이콜",포인트200인 회원 정보를 목록에 저장
		Member m2 = new Member(); 		
		m2.setId("a002");
		m2.setName("마이콜");
		m2.setPoint(200);
		MemberList.add(m2);
		
		//아아디"a003",이름"도우너",포인트300인 회원 정보를 목록에 저장
		Member m3 = new Member(); 		
		m3.setId("a003");
		m3.setName("도우너");
		m3.setPoint(300);
		MemberList.add(m3);
		
		//회원목록에 저장된 전체 회원의 아이디,이름,포인트를 출력	
		for (int i = 0; i < MemberList.size(); i++) {
			Member m  = MemberList.get(i);
			System.out.println(m.getId()+","+m.getName()+","+m.getPoint());	
		}
		
	}

}
