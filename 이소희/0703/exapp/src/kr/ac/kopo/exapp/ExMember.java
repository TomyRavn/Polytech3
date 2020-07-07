
package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExMember {

	public static void main(String[] args) {
		//1.회원 목록 2.회원 추가 3.회원 삭제 4.종료 라고 메뉴를 출력
		//번호를 입력 받는다.
		//"1"을 입력한 경우 데이터베이스에 존재하는 모든 회원 목록을 출력
		//"2"를  회원 아이디, 비번, 이름, 포인트를 입력받아서 데이터 베이스의 member 테이블에 저장하고,
		//"3"를 입력한 경우, "삭제할 회원의 아이디를 입력하세요"라고 출력하고, 입력한 아이디의 회원을 member 테이블에서 삭제
		//"4"를 입력한 경우, 프로그램을 종료
		//위 작업을 무한 반복
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "com";
		String password = "com01";
		

		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			System.out.println("1.회원 목록 2.회원 추가 3.회원 삭제 4.종료");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1":
				
				String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";

				try (Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();) {

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
				break;
		
			
			case "2" :
					System.out.println("회원 아이디를 입력하세요");
					String id = sc.nextLine();
					System.out.println("회원 비밀번호를 입력하세요");
					String pw = sc.nextLine();
					System.out.println("회원 이름를 입력하세요");
					String name = sc.nextLine();
					System.out.println("회원 포인트를 입력하세요");
					int point = Integer.parseInt(sc.nextLine());
					
					
					sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) " + "VALUES (?,?,?,?)";
					try (Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);) {		
					pstmt.setString(1, id); 
					pstmt.setString(2, pw); 
					pstmt.setString(3, name); 
					pstmt.setInt(4, point); 
					int num = pstmt.executeUpdate();
					System.out.println(num + "개의 레코드 추가");

					} catch (SQLException e) {
							e.printStackTrace();
					}break;
			
			case "3" : 
					{System.out.println("삭제할 회원 아이디를 입력하세요.");
					String delid = sc.nextLine();
					{
						sql = "DELETE FROM member where MEM_ID = ?";

					try(
						Connection conn = DriverManager.getConnection(url, user, password);		
						PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
						pstmt.setString(1, delid); 
						int num = pstmt.executeUpdate(); 
						System.out.println(num + "명의 회원 삭제");

					} catch (SQLException e) {
					e.printStackTrace();
					} 
					}
					}
					break;
				
				
			case "4":
					flag = false;
					break;
				
			default:
					break;
		}
				
	}


	}
}



