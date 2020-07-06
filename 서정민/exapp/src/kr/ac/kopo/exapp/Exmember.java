package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exmember {
		//1.회원목록 2.회원추가 3.회원삭제 4.종료 출력 번호를 입력받는다. 1"을 입력한 경우, 현재까지 입력한 값들을 모두 출력
		//"2"을 입력한 경우,회원아이디,비밀번호,이름,포인트 입력받아서"데이버 베이스의 member 테이블에 저장
		//"3"을 입력한 경우, 삭제할 아이디를 입력하세요 라고 출력하고,입력한 아이디의 회원을 데이터베이스 삭제		
		//"4"을 입력한 경우,프로그램을 종료
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user ="com";
		String password = "com01"; 
			
		boolean flag = true;
		
		while(flag){
			System.out.println("1.회원목록 2.회원추가 3.회원삭제 4.프로그램종료");	
			String menu = sc.nextLine();
		
			switch(menu) {
			case "1":
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
				break;			
			case "2":
				System.out.println("회원 아이디를 입력하세요");
				System.out.println(" 아이디:");
				String Id= sc.nextLine();
				System.out.println(" 비밀번호:");
				String Pass = sc.nextLine();
				System.out.println("이름:");
				String Name = sc.nextLine();
				System.out.println("포인트:");
				int Point = Integer.parseInt(sc.nextLine());
				String line = sc.nextLine();
					
				{
					String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)" 
							+ "VALUES (?,?,?,?)";			
					try(
						Connection conn = DriverManager.getConnection(url, user, password);				
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {
						
						pstmt.setString(1,Id);
						pstmt.setString(2,Pass);
						pstmt.setString(3,Name);
						pstmt.setInt(4,Point);
						int num= pstmt.executeUpdate(); 
						System.out.println(num + "개의 레코드 추가"); 
											
					} catch (SQLException e) {
						e.printStackTrace();
					} 
					}
				break;	
				
			case "3":
				System.out.println("삭제할 회원의 아이디를 입력하세요");
				String delId = sc.nextLine();
												
				{			
					String sql = "Delete from member where MEM_ID = ?";
				
			try (
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
								
				) {
					pstmt.setString(1,delId);
					int num= pstmt.executeUpdate();
					System.out.println("1명의 회원삭제");

			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
				break;	
			
			case "4":
				flag=false;
				System.out.println("종료합니다.");										
	
			default:
				break;
		}
					
		}
				
	}

}
