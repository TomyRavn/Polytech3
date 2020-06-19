package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exdbcin {

	public static void main(String[] args) {
		// 클래스를 실행하면 
		// 회원 아이디, 비번, 이름, 포인트를 입력받아서.
		// 데이터 베이스의 member 테이블에 저장하고,
		// 전체 목록을 조회하여 출력하는 프로그램을 작성하세요.
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("회원 비밀번호를 입력하세요");
		String pw = sc.nextLine();
		System.out.println("회원 이름를 입력하세요");
		String name = sc.nextLine();
		System.out.println("회원 포인트를 입력하세요");
		int point = Integer.parseInt(sc.nextLine());
		
		
		try {
			Class.forName("new oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "com";
		String password = "com01";
		
				//SQL문에서 변화하는 값은 ?로 표시
				{String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
							+ "VALUES (?,?,?,?)";
					try(
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
						//주입할 값의 타입에 따라서  PreparedStatement 객체의 set 타입명() 메서드를 사용
						pstmt.setString(1, id); //pstmt에 들어있는 SQL문의 1번째 ?에 id 값을 주입
						pstmt.setString(2, pw); //pstmt에 들어있는 SQL문의 2번째 ?에 pw 값을 주입
						pstmt.setString(3, name); //pstmt에 들어있는 SQL문의 3번째 ?에 name 값을 주입
						pstmt.setInt(4, point); //pstmt에 들어있는 SQL문의 4번째 ?에 point 값을 주입
						int num = pstmt.executeUpdate(); 
						System.out.println(num + "개의 레코드 추가");

						
					} catch (SQLException e) {
						e.printStackTrace();
					} 
					}
//				{
//					String sql = "DELETE FROM member where MEM_ID = 'a006'";
//
//					try(
//						Connection conn = DriverManager.getConnection(url, user, password);		
//						PreparedStatement pstmt = conn.prepareStatement(sql);
//					) {
//						int num = pstmt.executeUpdate(); 
//						System.out.println(num + "개의 레코드 삭제");
//
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} 
//					}
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

		


