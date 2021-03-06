package kr.ac.kopo.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO : Data Access Object
//자바 데이터(객체) <-> 데이터베이스 데이터(테이블) 사이의 상호변환을 담당

public class MemberDaoJdbc implements MemberDao {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";
	
	
	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> memberList = new ArrayList<MemberVo>();
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMemId(rs.getString("mem_id"));
				vo.setMemPass(rs.getString("mem_pass"));
				vo.setMemName(rs.getString("mem_name"));
				vo.setMemPoint(rs.getInt("mem_point"));
				memberList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	
	
	@Override
	public int insertMember(MemberVo vo) {
		
		int num = 0;
		
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
				+ "VALUES (?, ?, ?, ?)";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
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
	
	
	@Override
	public void deleteMember(String memId) {
		String sql = "DELETE FROM member WHERE mem_id = ?";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, memId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public MemberVo selectMember(String memId) {
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id = ?";
		
		MemberVo vo = null;

		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			pstmt.setString(1, memId);
			
			try (
					ResultSet rs = pstmt.executeQuery();	
					){
				
				if(rs.next()) {
					vo = new MemberVo();
					
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPoint(rs.getInt("mem_point"));
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
//	@Override
//	public MemberVo selectLoginMember(String memId, String memPass) {
//		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id=? and mem_pass=?";
//		
//		MemberVo vo = null;
//
//		try (	
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//			){
//			
//			pstmt.setString(1, memId);
//			pstmt.setString(2, memPass);
//			
//			try (
//					ResultSet rs = pstmt.executeQuery();	
//					){
//				
//				if(rs.next()) {
//					vo = new MemberVo();
//					
//					vo.setMemId(rs.getString("mem_id"));
//					vo.setMemPass(rs.getString("mem_pass"));
//					vo.setMemName(rs.getString("mem_name"));
//					vo.setMemPoint(rs.getInt("mem_point"));
//				}
//				
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return vo;
//	}
	
	
	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		MemberVo vo = null;
		
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id=? and mem_pass=?";

		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			pstmt.setString(1, memberVo.getMemId());
			pstmt.setString(2, memberVo.getMemPass());
			
			try (
					ResultSet rs = pstmt.executeQuery();	
					){
				
				if(rs.next()) {
					vo = new MemberVo();
					
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPoint(rs.getInt("mem_point"));
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public void updateMember(MemberVo vo) {
		String sql = "UPDATE member SET mem_name = ?, mem_point = ? WHERE mem_id = ?";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, vo.getMemName());
			pstmt.setInt(2, vo.getMemPoint());
			pstmt.setString(3, vo.getMemId());
			
			pstmt.executeUpdate(); 

			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}