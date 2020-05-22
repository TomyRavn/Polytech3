package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exjdbcin {
	
		//클래스를 실행하면,회원아이디,비밀번호,이름,포인트를 입력받아서,데이터베이스의 member 태이블에 저장하고, 전체목록을 조회하여 출력하는 프로그램을 작성하세요.	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" 아이디:");
			String Id= sc.nextLine();
			System.out.println(" 비밀번호:");
			String Pass = sc.nextLine();
			System.out.println("이름:");
			String Name = sc.nextLine();
			System.out.println("포인트:");
			int Point = Integer.parseInt(sc.nextLine());
			
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user ="com"; //데이터 베이스 아이디
		String password = "com01";
									
		{	//sql문에서 변화하는 값은 ?로 표시
			String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)" 
				//	+ "VALUES ('" + Id + "', '" + Pass + "','" + Name + "'," + Point+")"; //c+1 해서 변수 밖으로 빼냄.
					+ "VALUES (?,?,?,?)";			
			try(
				Connection conn = DriverManager.getConnection(url, user, password);				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
				//주입할 값의 타입에 따라서 preparedStatement 객체의 set타입명()메서드를 사용
				pstmt.setString(1,Id); //pstmt에 들어 있는 sql문의 1번쨰 ?에 id값을 주입
				pstmt.setString(2,Pass);//pstmt에 들어 있는 sql문의 2번쨰 ?에 pw값을 주입
				pstmt.setString(3,Name);//pstmt에 들어 있는 sql문의 3번쨰 ?에 name값을 주입
				pstmt.setInt(4,Point);//pstmt에 들어 있는 sql문의 4번쨰 ?에 point값을 주입
				//pstm에 들어있는 sql문의 1번째 id 값을 주입
				int num= pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 변환
				System.out.println(num + "개의 레코드 추가"); 
									
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			}
			
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

