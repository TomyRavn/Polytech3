package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exjdbc {
	public static void main(String[] args) { 
		
		//오라클 JDBC 드라이버(라이브러리) 클래스인
		// oracle.jdbc.OracleDriver 클래스를 메모리에 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		//접속정보 정의
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user ="com"; //데이터 베이스 아이디
		String password = "com01"; //데이터 베이스 비밀번호
		
		
		{
			
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)" 
					+ "VALUES ('a003', '1234','도우너',300)";
		
		//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 담아준다.(close)
		
		try(//데이터베이스에 접속(연결,로그인)
				Connection conn = DriverManager.getConnection(url, user, password);
				//실행할 sql문을 명령문 개체로 생성(실행준비)
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
	
			//SQL문을 담은 명령문(객체)를 실행
			//실행 결과로 데이터를 돌려받는 SQL문  (SELECT문은 executeQuerty로 실행
			//실행 결과로 데이터를 돌려받지 않는SQL문 (INSERT,DELETE,UPDATE)은 executeUpdate로 실행
			int num= pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 추가"); //성공여부 확인 
								
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
		{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
	
	//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 담아준다.(close)
	
	try(//데이터베이스에 접속(연결,로그인)
			Connection conn = DriverManager.getConnection(url, user, password);
			//실행할 sql문을 명령문 개체로 생성(실행준비)
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {

			//SQL문을 담은 명령문(객체)를 실행
			//실행 결과로 데이터를 돌려받는 SQL문  (SELECT문은 executeQuerty로 실행
			//실행 결과로 데이터를 돌려받지 않는SQL문 (INSERT,DELETE,UPDATE)은 executeUpdate로 실행
			//실행결과 레코드를 가리키고 있는 ResultSet
			//처음 ResultSet은 첫 레코드(행)이전을 가리키고 있는 상태
		
		while (rs.next()) {//다음 레코드를 가리키도록 이동하고, 다음 레코드가 없으면 FALSE가 반횐되어 반복 종료
										
//			다음과  같이 출력되도록 프로그램을 변경하세요
//			a001	1234	고길동	100
//			a002	1234	마이콜	200
//			a003	1234	도우너	300						
		String memId = rs.getString("mem_id"); 	//현재 rs가 가르키는 레코드에서 mem_id 컬럼값을 가져오기
//		System.out.println(memId);
		String memName = rs.getString("mem_name"); //현재 rs가 가르키는 레코드에서 mem_name 컬럼값을 가져오기
//		System.out.println(memName); 
		String memPass = rs.getString("mem_pass"); //현재 rs가 가르키는 레코드에서 mem_name 컬럼값을 가져오기
//		System.out.println(memPass); 
		int memPoint = rs.getInt("mem_point"); //현재 rs가 가르키는 레코드에서 mem_name 컬럼값을 가져오기
//		System.out.println(memPoint); 
				
		System.out.printf("%s :%s :%s :%s\n", memId,memPass,memName,memPoint);
	}

		
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	}
		
		//a001 회원이 포인트를 777로 변경하는 프로그램을 작성하세요.
		{			
			String sql = "UPDATE member SET mem_point = 777 where MEM_ID = 'a001'";
		
	try (
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			int num= pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 변경");
			
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	}
				
		//a003 회원을 삭제하는 프로그램을 작성하세요.
		
		{			
			String sql = "Delete from member where MEM_ID = 'a003'";
		
	try (
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			int num= pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 삭제");
			
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	}
		
		//전체 회원 정보를 다시 한번 조회하여 출력하세요.
		
		{
			String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
					
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			
			while (rs.next()) {
				
			String memId = rs.getString("mem_id"); 	
			String memName = rs.getString("mem_name"); 		 
			String memPass = rs.getString("mem_pass"); 		
			int memPoint = rs.getInt("mem_point"); 	
				
			System.out.printf("%s :%s :%s :%s\n", memId,memPass,memName,memPoint);
		}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
	}
}

