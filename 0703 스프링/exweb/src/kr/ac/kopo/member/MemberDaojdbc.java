package kr.ac.kopo.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Dao(Data Access Object) 자바 데이터 (객체) <-> 데이터베이스(테이블) 사이의 상호변환을 담당
//MVC패턴 

public class MemberDaojdbc implements MemberDao {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
	String user ="com";
	String password = "com01"; 
	
	
	@Override
	public List<MemberVo> selectMemberList() {
		ArrayList<MemberVo>list =new ArrayList<MemberVo>();
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member order by mem_id";
				
try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
		
		while (rs.next()) {	
			MemberVo vo = new MemberVo();
			vo.setMemId(rs.getString("mem_id"));
			vo.setMemPass(rs.getString("mem_pass"));
			vo.setMemName(rs.getString("mem_name"));
			vo.setMemPoint(rs.getInt("mem_point"));	
			
			list.add(vo);
		}			
} catch (SQLException e) {
		e.printStackTrace();
}
		return list;
	}
	
	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo=null;
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id = ?";

		try (
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){				
			pstmt.setString(1, memId);
			try (ResultSet rs = pstmt.executeQuery(); )
			{
				if (rs.next()) {
					vo = new MemberVo();
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPoint(rs.getInt("mem_point"));										
				}	
		} 
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return vo;
	}
		
	@Override
	public int insertMember(MemberVo vo) {
		int num=0;
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)" 
				+ "VALUES (?,?,?,?)";			
		try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {			
			pstmt.setString(1,vo.getMemId());
			pstmt.setString(2,vo.getMemPass());
			pstmt.setString(3,vo.getMemName());
			pstmt.setInt(4,vo.getMemPoint());
			num = pstmt.executeUpdate(); 			
								
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public int updateMember(MemberVo vo) {
		int num=0;
		
		String sql = "UPDATE  member SET mem_name = ?, mem_point =? where mem_id =?";
				
		try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {			
			pstmt.setString(3,vo.getMemId()); //파라미터값 받은걸로 채움
			pstmt.setString(1,vo.getMemName());
			pstmt.setInt(2,vo.getMemPoint());

			num = pstmt.executeUpdate(); 
								
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}	
		
		@Override
		public int delMember(String memId) {
		int num=0;
		
		String sql = "Delete from member where MEM_ID = ?";
		
try (
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
					
	) {
		pstmt.setString(1,memId); //?에 채워넣음
		num= pstmt.executeUpdate();
		

	} catch (SQLException e) {
	e.printStackTrace();
	}
		return num;
	}

		@Override
		public MemberVo selectLoginMember(MemberVo memberVo) {
			MemberVo vo=null;
			String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member "
					+ "WHERE mem_id = ? and mem_pass = ?";

			try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){				
				pstmt.setString(1, memberVo.getMemId());
				pstmt.setString(2, memberVo.getMemPass());
				
				try (ResultSet rs = pstmt.executeQuery(); )
				{
					if (rs.next()) {
						vo = new MemberVo();
						vo.setMemId(rs.getString("mem_id"));
						vo.setMemPass(rs.getString("mem_pass"));
						vo.setMemName(rs.getString("mem_name"));
						vo.setMemPoint(rs.getInt("mem_point"));										
					}	
			} 
			}catch (SQLException e) {
			e.printStackTrace();
			}
			return vo;
							
		}
	
				
}
