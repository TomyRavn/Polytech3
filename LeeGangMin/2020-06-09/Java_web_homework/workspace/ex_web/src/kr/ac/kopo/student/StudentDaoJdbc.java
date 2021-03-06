package kr.ac.kopo.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDaoJdbc {
	
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
	
	
	public ArrayList<StudentVo> selectStudentList() {
		ArrayList<StudentVo> studentList = new ArrayList<StudentVo>();
		String sql = "SELECT stu_no, stu_name, stu_score FROM student";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
			while(rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNo(rs.getString("stu_no"));
				vo.setStuName(rs.getString("stu_name"));
				vo.setStuScore(rs.getInt("stu_score"));
				studentList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
	
	
	
	public int insertStudent(StudentVo vo) {
		
		int num = 0;
		
		String sql = "INSERT INTO student (stu_no, stu_name, stu_score) "
				+ "VALUES (?, ?, ?)";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, vo.getStuNo());
			pstmt.setString(2, vo.getStuName());
			pstmt.setInt(3, vo.getStuScore());
			
			num = pstmt.executeUpdate();

			} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	public void deleteStudent(String stuNo) {
		String sql = "DELETE FROM student WHERE stu_no = ?";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, stuNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public StudentVo selectStudent(String stuNo) {
		String sql = "SELECT stu_no, stu_name, stu_score FROM student WHERE stu_no = ?";
		
		StudentVo vo = null;

		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			pstmt.setString(1, stuNo);
			
			try (
					ResultSet rs = pstmt.executeQuery();	
					){
				
				if(rs.next()) {
					vo = new StudentVo();
					
					vo.setStuNo(rs.getString("stu_no"));
					vo.setStuName(rs.getString("stu_name"));
					vo.setStuScore(rs.getInt("stu_score"));
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	public void updateStudent(StudentVo vo) {
		String sql = "UPDATE student SET stu_name = ?, stu_score = ? WHERE stu_no = ?";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, vo.getStuName());
			pstmt.setInt(2, vo.getStuScore());
			pstmt.setString(3, vo.getStuNo());
			
			pstmt.executeUpdate(); 

			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}