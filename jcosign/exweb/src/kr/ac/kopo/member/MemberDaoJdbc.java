package kr.ac.kopo.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO(Data Access Object)
// 자바 데이터(객체) <-> 데이터베이스 데이터(테이블) 사이의 상호변환을 담당

public class MemberDaoJdbc {
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 		
	String user = "com";										
	String password = "com01";	

	public ArrayList<MemberVo> selectMemberList() {
		ArrayList<MemberVo> list= new ArrayList<MemberVo>();

		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				ResultSet rs = pstmt.executeQuery(); 
				)
		{
			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMemId( rs.getString("mem_id"));
				vo.setMemPass( rs.getString("mem_pass"));
				vo.setMemName( rs.getString("mem_name"));
				vo.setMemPoint( rs.getInt("mem_point"));
				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insertMember( MemberVo vo ) {

		//		public int insertMember(String memId, String memPass, String memName, int memPoint) {
		int num = 0; 
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)"
				+ "VALUES (?, ?, ?, ?)";

		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				) {

			pstmt.setString(1, vo.getMemId());	
			pstmt.setString(2, vo.getMemPass());	
			pstmt.setString(3, vo.getMemName());	
			pstmt.setInt(4, vo.getMemPoint());	
			num = pstmt.executeUpdate(); 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public MemberVo selectMember(String memId) {
		MemberVo vo = null;
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id = ?";
		//학번, 이름, 성적, 테이블 이름. 이때 값은 최소 0명, 최대 1명이다.
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

			pstmt.setString(1,memId);			
			try( ResultSet rs = pstmt.executeQuery(); ){
				if (rs.next()) {	
					vo = new MemberVo();
					vo.setMemId( rs.getString("mem_id"));
					vo.setMemPass( rs.getString("mem_pass"));
					vo.setMemName( rs.getString("mem_name"));
					vo.setMemPoint( rs.getInt("mem_point"));
					//				String memId = rs.getString("mem_id"); 		
					//				String memPass = rs.getString("mem_pass"); 	
					//				String memName = rs.getString("mem_name"); 		
					//				int memPoint = rs.getInt("mem_point"); 	

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int updateMember(MemberVo vo) {
		int num = 0;
		String sql = "UPDATE member SET mem_name = ?, mem_point = ? WHERE mem_id = ?";

		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				) {
			pstmt.setString(3, vo.getMemId());	
			pstmt.setString(1, vo.getMemName());	
			pstmt.setInt(2, vo.getMemPoint());	
			num = pstmt.executeUpdate(); 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public int deletMember(String memId) {
		int num = 0;
		String sql = "DELETE FROM member WHERE mem_id = ?";		
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				){
			pstmt.setString(1, memId);
			num = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public MemberVo selectLoginMember(MemberVo memberVo) {
		//		selectMember과 비슷하다. 
		MemberVo vo = null;
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member "
				+ "WHERE mem_id = ? and mem_pass = ?";
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

			pstmt.setString(1, memberVo.getMemId() );	
			pstmt.setString(2, memberVo.getMemPass() );	
			try( ResultSet rs = pstmt.executeQuery(); ){
				if (rs.next()) {	
					vo = new MemberVo();
					vo.setMemId( rs.getString("mem_id"));
					vo.setMemPass( rs.getString("mem_pass"));
					vo.setMemName( rs.getString("mem_name"));
					vo.setMemPoint( rs.getInt("mem_point"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
