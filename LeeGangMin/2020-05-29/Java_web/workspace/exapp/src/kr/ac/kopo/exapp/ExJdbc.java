package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExJdbc {
	public static void main(String[] args) {
		//jdbc를 쓰려면 정의된 클래스를 메모리에 올려야함
		//oracle.jd~ -> 자동완성이 안됨, 쓰려면 build path를 생성해주어야함(컴파일러가 찾을 수 있게)
		//Referenced Libraries가 추가됨
		
		
		//오라클 JDBC 드라이버(라이브러리) 클래스인
		//oracle.jdbc.OracleDriver 클래스를 메모리에 업로드
		//cf. new로 만들수도 있음
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		//첫 빨간줄은 예외처리가 안되서 발생하므로 try-catch문으로 surround
		//컴파일러가 아무리 찾아도 못찾을 때가 있으므로
		
		//바로 넣는 것보다 변수를 따로 만들어 쓰도록 함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	//데이터베이스 주소
			//현재 컴퓨터의 1521번 포트를 할당받은 xe프로그램
			//@myhost 에 ip주소를 입력
			//daum.net이면 http://daum.net과 같이 보이지 않는 형식도 써줄 것
		String user = "com";		//데이터베이스 계정 아이디
		String password = "com01";	//데이터베이스 계정 비밀번호
		
		{
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
				+ "VALUES ('a007', '1239', '마하', 100)";
		
		//연결한 결과를 받아야 함(conn에 연결한 결과 저장)
		try (	//try{안}에 들어갈 내용을 try(안)에 넣어 실행하여 finally에서 닫아줘야할 부분을 자동으로 닫아주는 새로운 자바 7이후 기능
				
				//db에 접속하기 위한 문장
				//데이터베이스에 접속(연결, 로그인)
				Connection conn = DriverManager.getConnection(url, user, password);
				
				//실행할 SQL문을 명령문 객체로 생성(실행준비)
				//PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) VALUES ('a003', '1236', '단백질', 0)");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			
			
			//SQL문을 담은 명령문(객체)을 실행
			//실행 결과로 데이터를 돌려받는 SQL문 (SELECT)은 executeQuery()로 실행
			//실행 결과로 데이터를 돌려받지 않는 SQL문	(INSERT, UPDATE, DELETE)은 executeUpdate()로 실행
			//pstmt.executeUpdate();			//리턴값은 있음
			int num = pstmt.executeUpdate(); 	//실행결과 변경된 레코드(row) 수를 반환// 즉, INSERT 성공 시 1 반환 -> 잘 반영되었는지 결과 확인가능
			System.out.println(num + "개의 레코드 추가");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		//원래는
//		finally {	//try여도 catch여도 최종적으로 무조건 실행하게 함
//			//동시 접속자 수 제한에 걸리지 않기 위해 연결을 끊어주어야 함
//			pstmt.close();
//			conn.close();
//		}
		//예외처리를 해서 터지지 않아야 다른 사용자가 이용을 제대로 할 수 있다
	} //중괄호로 생성범위 제한(주석처리 안할 시)
		
		{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		
		//연결한 결과를 받아야 함(conn에 연결한 결과 저장)
		try (	//try{안}에 들어갈 내용을 try(안)에 넣어 실행하여 finally에서 닫아줘야할 부분을 자동으로 닫아주는 새로운 자바 7이후 기능
				
				//db에 접속하기 위한 문장
				//데이터베이스에 접속(연결, 로그인)
				Connection conn = DriverManager.getConnection(url, user, password);
				
				//실행할 SQL문을 명령문 객체로 생성(실행준비)
				//PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) VALUES ('a003', '1236', '단백질', 0)");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();//rs도 닫아줘야 하므로 여기로 이동
				) {
			
			
			//SQL문을 담은 명령문(객체)을 실행
			//실행 결과로 데이터를 돌려받는 SQL문 (SELECT)은 executeQuery()로 실행
			//실행 결과로 데이터를 돌려받지 않는 SQL문	(INSERT, UPDATE, DELETE)은 executeUpdate()로 실행
			//pstmt.executeUpdate();				//리턴값은 있음
			//ResultSet rs = pstmt.executeQuery(); 	//실행결과 레코드들을 가리키고 있는 ResultSet 반환
													//처음의 rs = mem_id, mem_pass, mem_name, mem_point의 행(row)를 가리키고 있음
													//executeQuery 때는 타입형 변경필요
			
			while (rs.next()) {		//다음 레코드로 이동하고, 다음 레코드가 없으면 false가 되어 반복 종료
				//처음 ResultSet은 첫 레코드(행)이전을 가리키고 있는 상태
				//따라서 바로 출력하지 않고 next로 한줄을 이동 
//				rs.next(); 	//다음 레코드를 가리키도록 함
							//다음 레코드가 있으면 true를 리턴해줌

//				String memId = rs.getString("mem_id"); //매개변수는 컬럼 이름이나 컬럼 인덱스 둘 중 택1
//				//현재 rs가 가리키는 레코드에서 "mem_id"컬럼 값 가져오기
//				System.out.println(memId);
//				String memName = rs.getString("mem_name");
//				System.out.println(memName);
				
				//Q1.
//				a001 : 1234 : 고길동 : 100
//				a002 : 1235 : 고단백 : 0
//				a003 : 1236	: 단백질 : 0    과 같이 출력되도록 프로그램을 변경
				
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				int memPoint = rs.getInt("mem_point");
				
				//System.out.printf("%s : %s : %s : %d", memId, memPass, memName, memPoint);
				//System.out.println();
				System.out.println(memId + " : " + memPass + " : " + memName  + " : " + memPoint);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		
		//Q2.
		//a001 회원의 포인트를 777로 변경하는 프로그램을 작성
	//update
		{
		String sql = "UPDATE member SET mem_point = 777 where mem_id = 'a001'";
			try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			int num = pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		//Q3.
		//a003 회원을 삭제하는 프로그램 작성
	//delete
		{
			String sql = "DELETE FROM member WHERE mem_id = 'a003'";
			try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			int num = pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 변경");
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		
		//Q4.
		//전체 회원 정보를 다시 조회하여 출력
		{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		
		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				) {
			
			while (rs.next()) {
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				int memPoint = rs.getInt("mem_point");
				
				System.out.println(memId + " : " + memPass + " : " + memName  + " : " + memPoint);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		
	}
}