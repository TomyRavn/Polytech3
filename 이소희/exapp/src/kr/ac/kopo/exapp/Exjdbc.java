package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exjdbc {
	public static void main(String[] args) {
		//오라클 JDBC 드라이버(라이브러리) 클래스인
		//new oracle.jdbc.OracleDriver 클래스를 메모리에 로드
		try {
			Class.forName("new oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
		//접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user = "com"; //데이터베이스 계정 아이디 주소
		String password = "com01"; //데이터베이스 계정 비밀번호
		{
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
				+ "VALUES ('a003','1234','도우너',300)";
		
		
		
		
		//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다(close)
		try(//데이터 베이스 접속
			Connection conn = DriverManager.getConnection(url, user, password);
			//실행할 SQL문을 명령문 객체로 생성(실행 준비)		
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			//SQL문을 담은 명령문(객체)을 실행
			//실행 결과로 데이터를 돌려받는 SQL문 (SELECT)는 executeQuery();로 실행
			//실행 결과로 데이터를 돌려받지 않는 SQL문 (INSERT, DELETE, UPDATE)는 executeUpdate();로 실행
			int num = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
			System.out.println(num + "개의 레코드 추가");

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
		
		{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		
		//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다(close)
		try(//데이터 베이스 접속
			Connection conn = DriverManager.getConnection(url, user, password);
			//실행할 SQL문을 명령문 객체로 생성(실행 준비)		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//SQL문을 담은 명령문(객체)을 실행
			//실행 결과로 데이터를 돌려받는 SQL문 (SELECT)는 executeQuery();로 실행
			//실행 결과로 데이터를 돌려받지 않는 SQL문 (INSERT, DELETE, UPDATE)는 executeUpdate();로 실행
			ResultSet rs = pstmt.executeQuery(); //실행결과 레코드들을 가리키고 있는 ResultSet 반환
		) {
			//처음 ResultSet은 첫 레코드(행) 이전을 가리키고 있는 상태
			while (rs.next()) { //다음 레코드로 이동하고, 다음 레코드가 없으면 false가 반환되어 반복 종료
//				다음과 같이 출력되도록 프로그램을 변경하시오.
//				a001	:	1234	:	고길동	:	100
//				a002	:	1234	:	마이클	:	200
//				a003	:	1234	:	도우너	:	300
				
				String memId = rs.getString("mem_id"); //현재 rs가 가리키는 레코드에서 mem_id 컬럼값 가져오기
//				System.out.println("mem_id:" + memId);
				String mempass = rs.getString("mem_pass");
//				System.out.println("mempoint:" + mempass);
				String memName = rs.getString("mem_name");
//				System.out.println("mem_name:" + memName);
				String mempoint = rs.getString("mem_point");
//				System.out.println("mempoint:" + mempoint);
//				System.out.println(memId + ":" + mempass + ":" + memName + ":" + mempoint);
				System.out.printf("%s : %s : %s : %s\n", memId, mempass, memName, mempoint);
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
		

		//a001 회원의 포인트를 777로 변경하는 프로그램을 작성하세요.
		{
			String sql = "UPDATE member SET mem_point = 777 where MEM_ID = 'a001'";
			try(
				Connection conn = DriverManager.getConnection(url, user, password);		
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				int num = pstmt.executeUpdate(); 
				System.out.println(num + "개의 레코드 변경");

			} catch (SQLException e) {
				e.printStackTrace();
			} 
			}
		
		
		
		
		//a003 회원을 삭제하는 프로그램을 작성하세요.
		{
			String sql = "DELETE FROM member where MEM_ID = 'a003'";

			try(
				Connection conn = DriverManager.getConnection(url, user, password);		
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				int num = pstmt.executeUpdate(); 
				System.out.println(num + "개의 레코드 삭제");

			} catch (SQLException e) {
				e.printStackTrace();
			} 
			}
			
		
		
		//전체 회원 정보를 다시 한번 조회 하여 출력하세요.
		{
			String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";

			try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
				
				while (rs.next()) { 
			String memId = rs.getString("mem_id");
					String mempass = rs.getString("mem_pass");
					String memName = rs.getString("mem_name");
					String mempoint = rs.getString("mem_point");
					System.out.println(memId + ":" + mempass + ":" + memName + ":" + mempoint);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} 
			}

		
	}
}


