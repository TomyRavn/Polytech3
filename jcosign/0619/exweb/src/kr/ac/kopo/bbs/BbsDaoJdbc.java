package kr.ac.kopo.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object)
// 자바 데이터(객체) <-> 데이터베이스 데이터(테이블) 사이의 상호변환을 담당

public class BbsDaoJdbc implements BbsDao {
//	{
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}	
//	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 		
	String user = "com";										
	String password = "com01";	

	@Override
	public List<BbsVo> selectBbsList() {
		ArrayList<BbsVo> list= new ArrayList<BbsVo>();

		String sql = "SELECT bbs_no, bbs_title, bbs_writer, bbs_reg_date FROM bbs order by bbs_no" ;
//		sql처럼 order by bbs_no를 넣어 글번호 정렬을 했다.
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				ResultSet rs = pstmt.executeQuery(); 
				)
		{
			while (rs.next()) {
				BbsVo vo = new BbsVo();
				
				vo.setBbsNo( rs.getInt("bbs_no"));
				vo.setBbsTitle( rs.getString("bbs_title"));
				vo.setBbsWriter( rs.getString("bbs_writer"));
				vo.setBbsRegDate( rs.getTimestamp("bbs_reg_date"));
				list.add(vo);
				//담아서 List에 추가하고
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	//내용 출력
	}
	
	@Override
	public BbsVo selectBbs(int bbsNo) {
		BbsVo vo = null;
		String sql = "SELECT bbs_no, bbs_title, bbs_content, bbs_writer, bbs_reg_date, bbs_count FROM bbs WHERE bbs_no = ?";
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1,bbsNo);			
			try( ResultSet rs = pstmt.executeQuery(); ){
				if (rs.next()) {	
					vo = new BbsVo();
					vo.setBbsNo( rs.getInt("bbs_no"));
					vo.setBbsTitle( rs.getString("bbs_title"));
					vo.setBbsContent( rs.getString("bbs_content"));
					vo.setBbsWriter( rs.getString("bbs_writer"));
					vo.setBbsRegDate( rs.getTimestamp("bbs_reg_date"));
					vo.setBbsCount( rs.getInt("bbs_count"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	
	@Override
	public int insertBbs( BbsVo vo ) {
		int num = 0; 
		String sql = "insert into bbs(bbs_no,bbs_title, bbs_content, bbs_writer)" + 
				"values(seq_bbs_no.NEXTVAL, ?,?,?)";

		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
		) {
			pstmt.setString(1, vo.getBbsTitle());	
			pstmt.setString(2, vo.getBbsContent());	
			pstmt.setString(3, vo.getBbsWriter());
			num = pstmt.executeUpdate(); 
			//?를 순서대로 채워 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int updateBbs(BbsVo vo) {
		int num = 0;
		String sql = "UPDATE bbs SET bbs_title = ?, bbs_content = ? WHERE bbs_no = ?";
		
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				) {

			pstmt.setString(1, vo.getBbsTitle());	
			pstmt.setString(2, vo.getBbsContent());	
			pstmt.setInt(3, vo.getBbsNo());	
			num = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
			//순서대로 ?를 채워서 업데이트
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int deleteBbs(int BbsNo) {
		int num = 0;
		String sql = "DELETE FROM bbs WHERE bbs_no = ?";		
		try(
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setInt(1, BbsNo);
			//번호를 입력하면 ?에 그 번호를 채워 글번호 삭제=글삭제
			num = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
